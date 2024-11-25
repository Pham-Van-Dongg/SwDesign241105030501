### 1. Distribute subsystem behavior to subsystem elements

**Phân tích hành vi của hệ thống con**

Hệ thống chạy bảng lương được chia thành các hệ thống con và mỗi hệ thống con đảm nhận một vai trò cụ thể:

  + SystemClockInterface Subsystem:

    - Kiểm tra xem hôm nay có phải là ngày trả lương hay không bằng cách gọi phương thức isPayday().

  + PayrollController Subsystem:

    - Điều phối toàn bộ quy trình tính toán và thanh toán lương:
    - Gọi các phương thức từ Employee, Timecard, và PurchaseOrder để lấy thông tin.
    - Tính toán lương qua phương thức calculatePay().
    - Tạo đối tượng Paycheck với số tiền đã tính toán.
    - Xác định phương thức thanh toán (in phiếu lương hoặc gửi qua ngân hàng).

  + Employee Subsystem:

    + Cung cấp thông tin nhân viên, bao gồm:

      - Thông tin chấm công (Timecard) hoặc hóa đơn bán hàng (PurchaseOrder) nếu cần.
      - Phương thức thanh toán (nhận trực tiếp, qua thư, hoặc chuyển khoản ngân hàng).

  + External Subsystems:

    - iPrintService: In phiếu lương cho nhân viên nhận lương qua thư hoặc trực tiếp.
    - iBankSystem: Gửi giao dịch ngân hàng cho nhân viên nhận lương qua chuyển khoản.

  + Entity Subsystem:

    - Paycheck: Lưu trữ thông tin phiếu lương được tạo ra.

### 2. Document subsystem elements

**Mô tả chi tiết các thành phần của từng hệ thống con**

1. SystemClockInterface Subsystem

Mục đích: Cung cấp thông tin về thời gian.

Thành phần chính:

- Phương thức isPayday(): Kiểm tra xem hôm nay có phải ngày trả lương không.

2. PayrollController Subsystem

Mục đích: Điều phối toàn bộ quy trình chạy bảng lương.

Thành phần chính:

- Phương thức runPayroll(): Khởi động quy trình chạy bảng lương.
- Phương thức getPayAmount(): Tính toán lương cho từng nhân viên.
- Phương thức getPaymentMethod(): Xác định phương thức thanh toán.
- Phương thức deposit() hoặc print(): Gửi lương qua ngân hàng hoặc in phiếu lương.

3. Employee Subsystem

Mục đích: Cung cấp thông tin liên quan đến nhân viên.

Thành phần chính:

- Phương thức getTimecardInfo(): Truy xuất thông tin chấm công (cho nhân viên tính lương theo giờ).
- Phương thức getPOInfo(): Truy xuất thông tin hóa đơn bán hàng (cho nhân viên hoa hồng).
- Phương thức calculatePay(): Tính toán lương dựa trên thông tin chấm công hoặc hóa đơn.
- Phương thức getBankInfo(): Truy xuất thông tin ngân hàng (cho nhân viên nhận lương qua chuyển khoản).

4. External Subsystems

iPrintService:

- Phương thức print(Paycheck, String): In phiếu lương cho nhân viên nhận qua thư hoặc trực tiếp.

iBankSystem:

- Phương thức deposit(Paycheck, BankInfo): Gửi giao dịch ngân hàng.

5. Entity Subsystem

Paycheck:

- Thuộc tính amount: Số tiền lương.
- Thuộc tính paymentMethod: Phương thức thanh toán (thư, trực tiếp, ngân hàng).
- Thuộc tính bankInfo: Thông tin ngân hàng (nếu có).

### 3. Describe subsystem dependencies

**Phân tích phụ thuộc giữa các hệ thống con**

Dựa trên sơ đồ tuần tự, các phụ thuộc chính giữa các hệ thống con được mô tả như sau:

SystemClockInterface → PayrollController:

PayrollController phụ thuộc vào SystemClockInterface để kiểm tra ngày trả lương thông qua phương thức isPayday().
PayrollController → Employee:

PayrollController lấy thông tin từ Employee để tính toán lương:
Gọi getTimecardInfo() hoặc getPOInfo() để lấy thông tin chấm công/hóa đơn.
Gọi calculatePay() để tính toán lương.
Gọi getBankInfo() để lấy thông tin ngân hàng (nếu cần).
PayrollController → Entity Subsystem:

PayrollController tạo đối tượng Paycheck để lưu trữ thông tin lương.
PayrollController → External Subsystems:

PayrollController gọi:
iPrintService để in phiếu lương.
iBankSystem để gửi giao dịch ngân hàng.
Sơ đồ phụ thuộc giữa các hệ thống con

![Diagram](https://www.planttext.com/api/plantuml/png/V5DBReCm4Drp2YkhH6eka4MLDkeYYwYHw0K6Cn0BOoDxg8gYdAoB7gbNADzWGwWtIFEUvxrv7dw_V_QMm52Pow00da6AR1LMbZ0_ICspeo8q2N1aOHdPjhvYru3LXqkmbZtaTeJk27k6AePglTcnI6k9e5hq5jo2KRBc62tbGIjglcYMzEP4LyoKgYUiDquvHQhBBxak5Jq0SbHqGhhes0DZBBGL_eN2Y7iBVuAtl92wmiMWxlZLr_yGEN8myL4bUkRjVLRb87afWV3SHEhJNq5bpeM9FqM2gdzYvHVacUSEsi1sB94Qo0t1ZMp7Ggf3IHqywdruqCJDLxqh2kJen_g6nBb9EaJpAIOBrJt1OFYfrnX6TbiqUNJxwJKOtdLiCGJdvFPmhxVRv_a21lELR7Z3Uo_0W_W2x8s_n1dd2_QeuleV_WC00F__0m00)

4. Checkpoints
