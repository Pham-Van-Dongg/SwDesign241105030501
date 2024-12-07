# 1. Run Payroll (with SS Interface)

## 1.1 Phân tích hành vi hệ thống con

Hệ thống chạy bảng lương được chia thành các hệ thống con, mỗi hệ thống đảm nhận một vai trò cụ thể:

- **SystemClockInterface Subsystem**:
  - Kiểm tra ngày trả lương qua phương thức `isPayday()`.

- **PayrollController Subsystem**:
  - Điều phối toàn bộ quy trình tính toán và thanh toán lương:
    - Gọi các phương thức từ `Employee`, `Timecard`, và `PurchaseOrder` để lấy thông tin.
    - Tính toán lương qua `calculatePay()`.
    - Tạo đối tượng `Paycheck`.
    - Xác định và thực hiện phương thức thanh toán.

- **Employee Subsystem**:
  - Cung cấp thông tin nhân viên, gồm:
    - Chấm công (`Timecard`) hoặc hóa đơn bán hàng (`PurchaseOrder`).
    - Phương thức thanh toán (nhận trực tiếp, thư, hoặc ngân hàng).

- **External Subsystems**:
  - `iPrintService`: In phiếu lương.
  - `iBankSystem`: Gửi giao dịch ngân hàng.

- **Entity Subsystem**:
  - `Paycheck`: Lưu trữ thông tin phiếu lương.

## 1.2 Mô tả chi tiết hệ thống con

### SystemClockInterface
- **Mục đích**: Cung cấp thông tin ngày trả lương.
- **Thành phần**:
  - `isPayday()`: Kiểm tra ngày trả lương.

### PayrollController
- **Mục đích**: Điều phối quy trình bảng lương.
- **Thành phần**:
  - `runPayroll()`: Khởi chạy quy trình trả lương.
  - `calculatePay()`: Tính toán lương.
  - `getPaymentMethod()`: Xác định phương thức thanh toán.
  - `deposit()`/`print()`: Gửi lương qua ngân hàng hoặc in phiếu lương.

### Employee
- **Mục đích**: Cung cấp thông tin nhân viên.
- **Thành phần**:
  - `getTimecardInfo()`: Lấy thông tin chấm công.
  - `getPOInfo()`: Lấy thông tin hóa đơn bán hàng.
  - `calculatePay()`: Tính toán lương.
  - `getBankInfo()`: Lấy thông tin ngân hàng.

### External Subsystems
- **iPrintService**:
  - `print(Paycheck, String)`: In phiếu lương.
- **iBankSystem**:
  - `deposit(Paycheck, BankInfo)`: Gửi giao dịch ngân hàng.

### Entity Subsystem
- **Paycheck**:
  - **Thuộc tính**:
    - `amount`: Số tiền lương.
    - `paymentMethod`: Phương thức thanh toán.
    - `bankInfo`: Thông tin ngân hàng.
  - **Phương thức**:
    - `create(amount: float)`: Tạo phiếu lương.

## 1.3 Phân tích phụ thuộc hệ thống con

### Phụ thuộc chính:
- **SystemClockInterface → PayrollController**:
  - PayrollController gọi `isPayday()` để kiểm tra ngày trả lương.

- **PayrollController → Employee**:
  - Gọi các phương thức: `getTimecardInfo()`, `getPOInfo()`, `calculatePay()`, `getBankInfo()`.

- **PayrollController → Entity Subsystem**:
  - Tạo đối tượng `Paycheck`.

- **PayrollController → External Subsystems**:
  - Gọi `iPrintService` hoặc `iBankSystem` để xử lý thanh toán.

### Sơ đồ phụ thuộc
![Diagram](https://www.planttext.com/api/plantuml/png/V5DBReCm4Drp2YkhH6eka4MLDkeYYwYHw0K6Cn0BOoDxg8gYdAoB7gbNADzWGwWtIFEUvxrv7dw_V_QMm52Pow00da6AR1LMbZ0_ICspeo8q2N1aOHdPjhvYru3LXqkmbZtaTeJk27k6AePglTcnI6k9e5hq5jo2KRBc62tbGIjglcYMzEP4LyoKgYUiDquvHQhBBxak5Jq0SbHqGhhes0DZBBGL_eN2Y7iBVuAtl92wmiMWxlZLr_yGEN8myL4bUkRjVLRb87afWV3SHEhJNq5bpeM9FqM2gdzYvHVacUSEsi1sB94Qo0t1ZMp7Ggf3IHqywdruqCJDLxqh2kJen_g6nBb9EaJpAIOBrJt1OFYfrnX6TbiqUNJxwJKOtdLiCGJdvFPmhxVRv_a21lELR7Z3Uo_0W_W2x8s_n1dd2_QeuleV_WC00F__0m00)

# 3. Run Payroll (with Distribution)

## 1. Distribute Subsystem Behavior to Subsystem Elements

### 1.1. **SystemClockInterface Subsystem**
- **Mục đích**: Cung cấp thông tin thời gian.
- **Hành vi chính**:
  - `isPayday()`: Kiểm tra xem hôm nay có phải ngày trả lương hay không.
- **Tương tác**:
  - Tương tác với `PayrollController` để khởi động quy trình bảng lương.

---

### 1.2. **PayrollController Subsystem**
- **Mục đích**: Điều phối quy trình tính toán và thanh toán lương.
- **Hành vi chính**:
  - `runPayroll()`: Khởi chạy quy trình bảng lương.
  - Gọi các phương thức từ các hệ thống con khác:
    - `isPayday()` từ `SystemClockInterface` để xác định ngày trả lương.
    - `getPayAmount()`, `calculatePay()`, và `getPaymentMethod()` từ `Employee` để lấy thông tin lương.
    - `create()` từ `Paycheck` để tạo phiếu lương.
    - `deposit()` từ `iBankSystem` hoặc `print()` từ `iPrintService` để thực hiện thanh toán.

---

### 1.3. **Employee Subsystem**
- **Mục đích**: Cung cấp thông tin về nhân viên.
- **Hành vi chính**:
  - `getTimecardInfo()`: Truy xuất thông tin chấm công (cho nhân viên hưởng lương theo giờ).
  - `getPOInfo()`: Truy xuất thông tin hóa đơn bán hàng (cho nhân viên hưởng hoa hồng).
  - `calculatePay()`: Tính toán lương dựa trên thông tin chấm công hoặc hóa đơn.
  - `getBankInfo()`: Truy xuất thông tin ngân hàng của nhân viên.

---

### 1.4. **External Subsystems**
- **iPrintService**:
  - **Mục đích**: In phiếu lương cho nhân viên nhận qua thư hoặc trực tiếp.
  - **Hành vi chính**: 
    - `print()`: In phiếu lương từ đối tượng `Paycheck`.
- **iBankSystem**:
  - **Mục đích**: Gửi lương qua ngân hàng.
  - **Hành vi chính**: 
    - `deposit()`: Gửi giao dịch lương vào tài khoản ngân hàng của nhân viên.

---

### 1.5. **Entity Subsystem**
- **Paycheck**:
  - **Mục đích**: Lưu trữ thông tin phiếu lương.
  - **Hành vi chính**:
    - `create()`: Tạo phiếu lương với các thông tin như số tiền, phương thức thanh toán, và thông tin ngân hàng.

---

## 2. Mô Tả Chi Tiết Các Thành Phần Của Từng Hệ Thống Con

### 2.1. **SystemClockInterface**
- **Hành vi**:
  - Gọi phương thức `isPayday()` từ `PayrollController` để kiểm tra ngày trả lương.

---

### 2.2. **PayrollController**
- **Hành vi**:
  - Gọi `SystemClockInterface` để kiểm tra ngày trả lương.
  - Gọi `Employee` để lấy thông tin chấm công hoặc hóa đơn và tính toán lương.
  - Tạo đối tượng `Paycheck` với số tiền đã tính toán.
  - Gọi `iPrintService` hoặc `iBankSystem` để thực hiện thanh toán.

---

### 2.3. **Employee**
- **Hành vi**:
  - Gọi phương thức `getTimecardInfo()` từ `Timecard` để lấy thông tin chấm công.
  - Gọi `getPOInfo()` từ `PurchaseOrder` để lấy thông tin hóa đơn bán hàng.
  - Gọi `calculatePay()` để tính toán lương.

---

### 2.4. **External Subsystems**
- **iPrintService**:
  - Nhận yêu cầu từ `PayrollController` để in phiếu lương.
- **iBankSystem**:
  - Nhận yêu cầu từ `PayrollController` để gửi lương qua ngân hàng.

---

### 2.5. **Entity Subsystem**
- **Paycheck**:
  - Được tạo bởi `PayrollController` với các thông tin lương và phương thức thanh toán.

---

## 3. Phân Tích Phụ Thuộc Giữa Các Hệ Thống Con

### 3.1. **Phụ Thuộc Chính**
- **SystemClockInterface → PayrollController**:
  - `PayrollController` phụ thuộc vào `SystemClockInterface` để kiểm tra ngày trả lương thông qua phương thức `isPayday()`.

- **PayrollController → Employee**:
  - `PayrollController` gọi các phương thức từ `Employee` để lấy thông tin:
    - `getTimecardInfo()` hoặc `getPOInfo()` để lấy thông tin chấm công hoặc hóa đơn.
    - `calculatePay()` để tính toán lương.
    - `getBankInfo()` để lấy thông tin ngân hàng.

- **PayrollController → Entity Subsystem**:
  - `PayrollController` tạo đối tượng `Paycheck` để lưu trữ thông tin lương.

- **PayrollController → External Subsystems**:
  - `PayrollController` gọi:
    - `iPrintService` để in phiếu lương.
    - `iBankSystem` để gửi giao dịch ngân hàng.

---

### 3.2. **Sơ Đồ Phụ Thuộc**  
![Diagram](https://www.planttext.com/api/plantuml/png/T95DRW8n38NtESKi1wbSe8iAWRfWHIIuWEMO4ar-HewdqfoD1KVg5He3Wq30AihBvsS_v-zuMXG1bY46insBK5o5ZDqw2V4Ua9hv_AknC78EOPMJw4dSV3Q-LDN1sCwCUNxNgk_OXpmILVY7PESZ8R1RftrkPnygsSrqGGWu112oPyFNVbN50s5N_P2fmYt4F2HvEu2tx9DiYNyzwXIzNjl-QlEkZLz2wYwhg3ME-bpyVPMvvL9wYlKgv2Df1yO35DgmEo_mRW7c5ar1xQywHn2VqmMTn0elABdwNVy0003__mC0)
# 4. Run Payroll (with OOD)

## 1. **Phân Tích Hành Vi Của Các Hệ Thống Con**

### 1.1. **SystemClockInterface Subsystem**
- **Mục đích**: Cung cấp thông tin thời gian để xác định ngày trả lương.
- **Hành vi chính**: 
  - `isPayday()`: Kiểm tra xem hôm nay có phải ngày trả lương hay không.
- **Tương tác**: 
  - Tương tác với `PayrollController` tại bước kiểm tra ngày trả lương.

---

### 1.2. **PayrollController Subsystem**
- **Mục đích**: Điều phối toàn bộ quy trình chạy bảng lương.
- **Hành vi chính**: 
  - `runPayroll()`: Khởi động quy trình bảng lương.
  - Gọi các phương thức từ các hệ thống con khác:
    - `isPayday()` từ `SystemClockInterface`.
    - `getEmployeeListing()` từ `PayrollDBManager`.
    - `getPayAmount()`, `calculatePay()`, và `getPaymentMethod()` từ `Employee`.
    - `create()` từ `Paycheck`.
    - `deposit()` từ `iBankSystem` hoặc `print()` từ `iPrintService`.

---

### 1.3. **PayrollDBManager Subsystem**
- **Mục đích**: Quản lý cơ sở dữ liệu nhân viên và thông tin liên quan.
- **Hành vi chính**: 
  - `getEmployeeListing()`: Truy xuất danh sách nhân viên cần xử lý bảng lương.
  - `savePaycheck()`: Lưu thông tin phiếu lương vào cơ sở dữ liệu.
- **Tương tác**: 
  - Giao tiếp với `PayrollController` để lấy và lưu thông tin nhân viên.

---

### 1.4. **Employee Subsystem**
- **Mục đích**: Quản lý thông tin và tính toán liên quan đến nhân viên.
- **Hành vi chính**: 
  - `getTimecardInfo()`: Truy xuất thông tin chấm công (nhân viên lương theo giờ).
  - `getPOInfo()`: Truy xuất thông tin hóa đơn (nhân viên hoa hồng).
  - `calculatePay()`: Tính toán lương dựa trên thông tin làm việc.
  - `getPaymentMethod()`: Lấy phương thức thanh toán của nhân viên.

---

### 1.5. **External Subsystems**
- **iPrintService**:
  - **Mục đích**: In phiếu lương cho nhân viên.
  - **Hành vi chính**: 
    - `print()`: In thông tin phiếu lương từ `Paycheck`.
- **iBankSystem**:
  - **Mục đích**: Thực hiện giao dịch gửi lương qua tài khoản ngân hàng.
  - **Hành vi chính**: 
    - `deposit()`: Gửi tiền vào tài khoản nhân viên.

---

### 1.6. **Entity Subsystem**
- **Paycheck**:
  - **Mục đích**: Lưu trữ thông tin liên quan đến phiếu lương.
  - **Hành vi chính**: 
    - `create()`: Tạo phiếu lương với các thông tin về lương, nhân viên, và phương thức thanh toán.

---

## 2. **Phân Tích Phụ Thuộc Giữa Các Hệ Thống Con**

### 2.1. **Phụ Thuộc Chính**
- **SystemClockInterface → PayrollController**:
  - `PayrollController` phụ thuộc vào `SystemClockInterface` để kiểm tra ngày trả lương qua phương thức `isPayday()`.

- **PayrollController → Employee**:
  - `PayrollController` gọi các phương thức từ `Employee`:
    - `getTimecardInfo()` hoặc `getPOInfo()` để lấy thông tin làm việc.
    - `calculatePay()` để tính toán lương.
    - `getPaymentMethod()` để lấy phương thức thanh toán.

- **PayrollController → PayrollDBManager**:
  - Truy xuất danh sách nhân viên cần xử lý bảng lương qua `getEmployeeListing()`.
  - Lưu thông tin phiếu lương qua `savePaycheck()`.

- **PayrollController → iPrintService/iBankSystem**:
  - Gửi lương qua ngân hàng với `deposit()` từ `iBankSystem`.
  - In phiếu lương với `print()` từ `iPrintService`.

---

## 3. **Mô Tả Chi Tiết Các Thành Phần**

### 3.1. **SystemClockInterface**
- **Hành vi**:
  - Gọi `isPayday()` từ `PayrollController` để xác định ngày trả lương.

---

### 3.2. **PayrollController**
- **Hành vi**:
  - Điều phối quy trình tính và phân phối lương.
  - Gọi các hệ thống con như `SystemClockInterface`, `Employee`, `PayrollDBManager`, `iPrintService`, và `iBankSystem`.

---

### 3.3. **PayrollDBManager**
- **Hành vi**:
  - Lấy danh sách nhân viên cần xử lý bảng lương.
  - Lưu thông tin phiếu lương.

---

### 3.4. **Employee**
- **Hành vi**:
  - Cung cấp thông tin làm việc và tính toán lương.

---

### 3.5. **External Subsystems**
- **iPrintService**: In phiếu lương từ thông tin nhận từ `PayrollController`.
- **iBankSystem**: Gửi tiền lương qua tài khoản ngân hàng.

---

### 3.6. **Entity Subsystem**
- **Paycheck**: Lưu thông tin phiếu lương được tạo bởi `PayrollController`.

# 5. Run Payroll (With Everything)

## 1. Hệ Thống Con Và Vai Trò

### 1.1. SystemClockInterface
- **Mục đích**: Xác định ngày trả lương.
- **Hành vi chính**:
  - `isPayday()`: Kiểm tra xem hôm nay có phải ngày trả lương không.
- **Vai trò trong quy trình**:
  - Được gọi tại bước 1.2 bởi `PayrollController` để xác định có tiếp tục quy trình bảng lương hay không.

### 1.2. PayrollController
- **Mục đích**: Điều phối toàn bộ quy trình chạy bảng lương.
- **Hành vi chính**:
  - `runPayroll()`: Khởi động quy trình.
  - `getEmployeeListing()`: Lấy danh sách nhân viên từ `PayrollDBManager`.
  - `calculatePay()`: Tính toán lương cho từng nhân viên.
  - `getPaymentMethod()`: Xác định phương thức thanh toán của nhân viên.
  - `deposit()`: Xử lý thanh toán qua ngân hàng.
  - `print()`: Xử lý in phiếu lương.
- **Vai trò trong quy trình**:
  - Là hệ thống trung tâm điều phối, gọi các hệ thống con khác để thực hiện từng bước trong quy trình.

### 1.3. PayrollDBManager
- **Mục đích**: Quản lý dữ liệu nhân viên và phiếu lương.
- **Hành vi chính**:
  - `getEmployeeListing()`: Lấy danh sách nhân viên cùng thông tin liên quan (chấm công, hóa đơn bán hàng).
  - `savePaycheck()`: Lưu phiếu lương vào cơ sở dữ liệu.
- **Vai trò trong quy trình**:
  - Được gọi tại bước 1.1 để lấy danh sách nhân viên.
  - Được gọi tại bước 1.2.6 để lưu phiếu lương.

### 1.4. Employee
- **Mục đích**: Đại diện cho từng nhân viên, cung cấp thông tin cần thiết để tính lương.
- **Hành vi chính**:
  - `getTimecardInfo()`: Lấy thông tin chấm công từ `Timecard`.
  - `getPOInfo()`: Lấy thông tin hóa đơn bán hàng từ `PurchaseOrder`.
  - `calculatePay()`: Tính toán lương dựa trên thông tin chấm công hoặc hóa đơn bán hàng.
  - `getBankInfo()`: Lấy thông tin tài khoản ngân hàng của nhân viên.
- **Vai trò trong quy trình**:
  - Được gọi tại bước 1.2.3 để lấy thông tin và tính toán lương.
  - Được gọi tại bước 1.2.7 để xác định phương thức thanh toán.

### 1.5. Timecard
- **Mục đích**: Lưu trữ thông tin chấm công của nhân viên hưởng lương theo giờ.
- **Hành vi chính**:
  - `getTimecardInfo()`: Cung cấp thông tin chấm công cho `Employee`.
- **Vai trò trong quy trình**:
  - Được gọi tại bước 1.2.3.1 bởi `Employee` để tính toán lương theo giờ.

### 1.6. PurchaseOrder
- **Mục đích**: Lưu trữ thông tin hóa đơn bán hàng của nhân viên hưởng hoa hồng.
- **Hành vi chính**:
  - `getPOInfo()`: Cung cấp thông tin hóa đơn bán hàng cho `Employee`.
- **Vai trò trong quy trình**:
  - Được gọi tại bước 1.2.3.2 bởi `Employee` để tính toán lương hoa hồng.

### 1.7. Paycheck
- **Mục đích**: Lưu trữ thông tin phiếu lương của nhân viên.
- **Hành vi chính**:
  - `create()`: Tạo phiếu lương với số tiền đã tính toán.
- **Vai trò trong quy trình**:
  - Được gọi tại bước 1.2.4 bởi `PayrollController` để tạo phiếu lương.

### 1.8. iPrintService
- **Mục đích**: Xử lý in phiếu lương cho nhân viên nhận qua thư hoặc trực tiếp.
- **Hành vi chính**:
  - `print()`: In phiếu lương từ đối tượng `Paycheck`.
- **Vai trò trong quy trình**:
  - Được gọi tại bước 1.2.8 bởi `PayrollController` để in phiếu lương.

### 1.9. iBankSystem
- **Mục đích**: Xử lý các giao dịch thanh toán qua ngân hàng.
- **Hành vi chính**:
  - `deposit()`: Thực hiện giao dịch lương vào tài khoản ngân hàng của nhân viên.
- **Vai trò trong quy trình**:
  - Được gọi tại bước 1.2.10 bởi `PayrollController` để gửi lương qua ngân hàng.

## 2. Phân Tích Các Bước Trong Quy Trình

### 2.1 Quy trình `runPayroll()`:
1. `PayrollController` khởi động quy trình chạy bảng lương.
2. `PayrollController` gọi `PayrollDBManager` để lấy danh sách nhân viên và thông tin liên quan.
3. `PayrollController` gọi `SystemClockInterface` để kiểm tra ngày trả lương.
4. Tính toán lương cho từng nhân viên:
   - Gọi `Employee` để lấy thông tin chấm công (`Timecard`) hoặc hóa đơn bán hàng (`PurchaseOrder`).
   - `Employee` tính toán lương bằng cách gọi `calculatePay()`.
5. Tạo phiếu lương:
   - `PayrollController` gọi `Paycheck` để tạo đối tượng phiếu lương.
6. Lưu phiếu lương:
   - `PayrollController` gọi `PayrollDBManager` để lưu phiếu lương vào cơ sở dữ liệu.
7. Xác định phương thức thanh toán:
   - Gọi `Employee` để lấy thông tin phương thức thanh toán.
8. Thực hiện thanh toán:
   - Nếu thanh toán qua ngân hàng: Gọi `iBankSystem`.
   - Nếu nhận lương qua thư hoặc trực tiếp: Gọi `iPrintService`.

## 3. Kết Luận
Hệ thống trong sơ đồ tuần tự được thiết kế với các hệ thống con phối hợp chặt chẽ. `PayrollController` đóng vai trò trung tâm, điều phối các hệ thống con khác để thực hiện quy trình chạy bảng lương. Các hệ thống con như `SystemClockInterface`, `PayrollDBManager`, `Employee`, và `Paycheck` đảm bảo tính độc lập, dễ bảo trì và mở rộng.


### 2. Maintain Timecard (with security)

#### 1. Phân phối hành vi của hệ thống con đến các phần tử (Distribute Subsystem Behavior to Subsystem Elements)

**Hệ thống con và hành vi tương ứng:**

- **Employee:**
  - Gọi phương thức `maintainTimecard()` để bắt đầu quy trình.
  - Tương tác với `EmployeeSession` để lấy quyền truy cập bảo mật.

- **MainTimecardForm:**
  - Hiển thị giao diện người dùng cho bảng chấm công.
  - Gửi lệnh đến `TimecardController` để xử lý logic nghiệp vụ.

- **TimecardController:**
  - Lấy thông tin bảng chấm công hiện tại (`getTimecard()`).
  - Tạo bảng chấm công mới nếu chưa tồn tại (`addTimecard()`).
  - Lấy danh sách mã công việc từ `ProjectManagementDatabase`.
  - Xử lý logic cập nhật và lưu bảng chấm công.

- **Timecard:**
  - Lưu trữ dữ liệu bảng chấm công.
  - Cung cấp phương thức `save()` để lưu dữ liệu.

- **TimecardAccess & SecurityAccess:**
  - Đảm bảo quyền truy cập bảo mật cho bảng chấm công.
  - Cấp quyền "open", "read", "write", "delete" cho nhân viên.

- **EmployeeSession:**
  - Quản lý phiên làm việc bảo mật của nhân viên.
  - Cung cấp thông tin bảo mật cho tất cả các hệ thống con.

- **ProjectManagementDatabase:**
  - Cung cấp danh sách mã công việc (`getChargeNumbers()`).

#### 2. Tài liệu hóa các phần tử hệ thống con (Document Subsystem Elements)

**Các phần tử và mô tả chi tiết:**

- **Employee:**
  - **Vai trò:** Người dùng khởi tạo quy trình quản lý bảng chấm công.
  - **Giao diện:** Gọi phương thức `maintainTimecard()`.

- **MainTimecardForm:**
  - **Vai trò:** Giao diện người dùng để hiển thị và chỉnh sửa bảng chấm công.
  - **Phương thức chính:**
    - `displayTimecard()`: Hiển thị bảng chấm công.
    - `getChargeCodes()`: Lấy danh sách mã công việc.
    - `saveTimecard()`: Lưu bảng chấm công.

- **TimecardController:**
  - **Vai trò:** Xử lý logic nghiệp vụ liên quan đến bảng chấm công.
  - **Phương thức chính:**
    - `getTimecard()`: Lấy bảng chấm công hiện tại.
    - `addTimecard()`: Tạo bảng chấm công mới.
    - `updateTimecard()`: Cập nhật bảng chấm công.
    - `getChargeNumbers()`: Lấy danh sách mã công việc từ cơ sở dữ liệu.

- **Timecard:**
  - **Vai trò:** Lưu trữ dữ liệu bảng chấm công.
  - **Phương thức chính:**
    - `save()`: Lưu bảng chấm công vào cơ sở dữ liệu.

- **TimecardAccess & SecurityAccess:**
  - **Vai trò:** Đảm bảo quyền truy cập bảo mật cho bảng chấm công.
  - **Phương thức chính:**
    - `makeReadable()`, `makeWriteable()`, `makeDeletable()`: Thiết lập quyền truy cập.

- **EmployeeSession:**
  - **Vai trò:** Quản lý phiên làm việc bảo mật của nhân viên.
  - **Phương thức chính:**
    - `getSession()`: Lấy thông tin phiên làm việc hiện tại.

- **ProjectManagementDatabase:**
  - **Vai trò:** Cung cấp danh sách mã công việc.
  - **Phương thức chính:**
    - `getChargeNumbers()`: Truy xuất danh sách mã công việc.

#### 3. Mô tả các phụ thuộc giữa các hệ thống con (Describe Subsystem Dependencies)

**Quan hệ giữa các hệ thống con:**

- **Employee → MainTimecardForm:**
  - Employee khởi tạo quy trình thông qua phương thức `maintainTimecard()`.

- **MainTimecardForm → TimecardController:**
  - MainTimecardForm gửi lệnh đến TimecardController để xử lý logic.

- **TimecardController → Timecard:**
  - TimecardController tương tác với Timecard để lấy hoặc lưu dữ liệu bảng chấm công.

- **TimecardController → ProjectManagementDatabase:**
  - TimecardController truy vấn danh sách mã công việc từ ProjectManagementDatabase.

- **TimecardController → TimecardAccess & SecurityAccess:**
  - TimecardController thiết lập quyền truy cập bảo mật cho Timecard.

- **TimecardAccess & SecurityAccess → EmployeeSession:**
  - EmployeeSession cung cấp thông tin bảo mật cho TimecardAccess.

**Sơ đồ phụ thuộc:**

![Diagram](https://www.planttext.com/api/plantuml/png/X5BDJeGm4BxtANfS4tc1FHWDgxSrnbtZUQ0JH5jAEcKJOdmo3pwIhs21BYoKHf8Uc6z-lldc-_t-kIKBnZPAibm24RzNjTGj8lzat7qAoigwTomLvc34vchBJxeKx8lvWlq5-g2DwWiJRdqerPKrMaeqMtuCOlqCKL8jeGr6T5Y1Ddq3Ks2g1T8C8ZXXd5OuQq5iejE71LZ8W73Bdun-nzpkeO825LPsvw4-Zp1lJ6dRkpn7egd9y7_clBeB2B4QRsetF5nbjlvZep8q5D_JtwiJ9Puqa1nF-u7F208oYREX7V3gTiHLP8SIRO0Gsg7v9jJtciEgM07Di_SE3YnrvNaw3NoWctZm-h-GSyzO6RtPr2Egu-Zu9Ba9tCm2UtTPAqPUyTjbPWoFc-sVXjvlYyjs6GiLsHy0003__mC0)

### 3. Maintain Timecard (with Distribution)

1. **Distribute Subsystem Behavior to Subsystem Elements**  
   Hệ thống được chia thành các hệ thống con như sau:

   - **UI Subsystem**:
     - **Thành phần**: `TimecardForm`
     - Chịu trách nhiệm giao tiếp với người dùng, nhận input và hiển thị thông tin.
   
   - **Controller Subsystem**:
     - **Thành phần**: `TimecardController`
     - Xử lý logic nghiệp vụ, điều phối giữa giao diện người dùng và hệ thống dữ liệu.

   - **Data Subsystem**:
     - **Thành phần**: `Timecard`, `ProjectManagementDatabase`
     - Lưu trữ và quản lý dữ liệu bảng chấm công và danh sách mã công việc.

2. **Document Subsystem Elements**  
   Mô tả chi tiết các thành phần trong từng hệ thống con.

   - **UI Subsystem**
     - **Thành phần**: `TimecardForm`
     - **Mô tả**: Là giao diện chính để nhân viên tương tác với hệ thống. Nhận yêu cầu từ nhân viên và chuyển tiếp đến `TimecardController`.
     - **Hành vi**:
       - `lookup(String)`: Kết nối đến đối tượng điều khiển qua URL.
       - `displayTimecard()`: Hiển thị bảng chấm công hiện tại.
       - `displayChargeCodes()`: Hiển thị danh sách mã công việc.

   - **Controller Subsystem**
     - **Thành phần**: `TimecardController`
     - **Mô tả**: Là lớp điều khiển trung tâm, xử lý logic nghiệp vụ. Kết nối giữa giao diện người dùng, bảng chấm công, và cơ sở dữ liệu.
     - **Hành vi**:
       - `getTimecard(Date)`: Lấy bảng chấm công hiện tại theo ngày.
       - `updateTimecard()`: Cập nhật giờ công vào bảng chấm công.
       - `getChargeNumbers()`: Lấy danh sách mã công việc từ cơ sở dữ liệu.

   - **Data Subsystem**
     - **Thành phần**: `Timecard`, `ProjectManagementDatabase`
     - **Mô tả**:
       - `Timecard`: Đại diện cho dữ liệu bảng chấm công.
       - `ProjectManagementDatabase`: Quản lý danh sách mã công việc.
     - **Hành vi**:
       - `save()`: Lưu bảng chấm công vào cơ sở dữ liệu.
       - `getChargeNumbers()`: Truy xuất danh sách mã công việc.

3. **Describe Subsystem Dependencies**  
   Mô tả các phụ thuộc giữa các hệ thống con:

   - **Phụ thuộc từ UI Subsystem đến Controller Subsystem**:
     - Thành phần `TimecardForm` trong UI Subsystem phụ thuộc vào `TimecardController` trong Controller Subsystem để thực hiện các nhiệm vụ sau:
       - Lấy dữ liệu bảng chấm công (qua phương thức `getTimecard(Date)`).
       - Lấy danh sách mã công việc (qua phương thức `getChargeNumbers()`).
       - Cập nhật bảng chấm công (qua phương thức `updateTimecard()`).

   - **Phụ thuộc từ Controller Subsystem đến Data Subsystem**:
     - Thành phần `TimecardController` trong Controller Subsystem phụ thuộc vào các thành phần sau trong Data Subsystem:
       - `Timecard`: Để lưu và truy xuất dữ liệu bảng chấm công (qua phương thức `save()`).
       - `ProjectManagementDatabase`: Để lấy danh sách mã công việc (qua phương thức `getChargeNumbers()`).

   - **Không có phụ thuộc từ Data Subsystem đến các hệ thống con khác**:
     - Các thành phần trong Data Subsystem (Timecard và ProjectManagementDatabase) không phụ thuộc vào bất kỳ hệ thống con nào khác. Chúng chỉ cung cấp dữ liệu khi được yêu cầu bởi `TimecardController`.

   **Sơ đồ phụ thuộc:**
   ![Diagram](https://www.planttext.com/api/plantuml/png/V99DRi9038NtSueHAxh85H1IgafTj4A27i39M6bW_cHxAY74oLZqI5o1X98qj0cp6_lDUv-jEP--bon0afnL4SeTLAXd7wzwdGhUiw2RwOFIkhJ0h3UrmnB8l0Hort9xR0Yx5ETheTfNJxUYgJbQs7SFvd_g-ITGXNamoDVMKHtLRtmUl52m5kanna3NmLGeVUOp27QvAPhczW-daV-Wl2TN88t1D2xm6ACFP_Z2cqEdML7OOYblu1ipXrvQkm8OXyGJ27VRphB5oDngP1L3vLH_4aijqPlsBrm0003__mC0)

### 4. Maintain Timecard (with OOD)

1. **Distribute Subsystem Behavior to Subsystem Elements**  
   Phân phối hành vi từ Sequence Diagram đến các phần tử hệ thống con:

   - **UI Subsystem**:
     - **Thành phần**: `TimecardForm`
     - Chịu trách nhiệm giao tiếp với người dùng, nhận input và hiển thị thông tin.

   - **Controller Subsystem**:
     - **Thành phần**: `TimecardController`
     - Điều phối giữa giao diện người dùng và các thành phần hệ thống khác.

   - **Data Subsystem**:
     - **Thành phần**: `PayrollDBManager`, `Timecard`, `IProjectManagementDatabase`
     - Lưu trữ và quản lý dữ liệu bảng chấm công và danh sách mã công việc.

2. **Document Subsystem Elements**  
   Mô tả chi tiết các thành phần trong từng hệ thống con.

   - **UI Subsystem**
     - **Thành phần**: `TimecardForm`
     - **Mô tả**: Giao diện chính để nhân viên tương tác với hệ thống. Nhận yêu cầu từ người dùng và chuyển tiếp đến `TimecardController`.
     - **Hành vi**:
       - `open()`: Khởi tạo giao diện.
       - `get current timecard()`: Gửi yêu cầu lấy bảng chấm công hiện tại.
       - `displayTimecard()`: Hiển thị bảng chấm công.
       - `displayChargeCodes()`: Hiển thị danh sách mã công việc.

   - **Controller Subsystem**
     - **Thành phần**: `TimecardController`
     - **Mô tả**: Lớp điều khiển trung tâm, xử lý logic nghiệp vụ. Kết nối giữa giao diện người dùng và các hệ thống dữ liệu.
     - **Hành vi**:
       - `getTimecard(Employee, Date)`: Lấy bảng chấm công hiện tại từ `PayrollDBManager`.
       - `getChargeNumbers()`: Lấy danh sách mã công việc từ `IProjectManagementDatabase`.
       - `updateTimecard()`: Cập nhật giờ công vào bảng chấm công.

   - **Data Subsystem**
     - **Thành phần**: `PayrollDBManager`, `Timecard`, `IProjectManagementDatabase`
     - **Mô tả**:
       - `PayrollDBManager`: Quản lý cơ sở dữ liệu bảng chấm công.
       - `Timecard`: Đại diện cho dữ liệu bảng chấm công.
       - `IProjectManagementDatabase`: Quản lý danh sách mã công việc.
     - **Hành vi**:
       - `save(Timecard, Employee)`: Lưu bảng chấm công.
       - `getChargeNumbers()`: Truy xuất danh sách mã công việc.

3. **Describe Subsystem Dependencies**  
   Mô tả mối quan hệ phụ thuộc giữa các hệ thống con:

   - **Phụ thuộc từ UI Subsystem đến Controller Subsystem**:
     - Thành phần `TimecardForm` trong UI Subsystem phụ thuộc vào `TimecardController` trong Controller Subsystem để:
       - Lấy bảng chấm công (qua phương thức `getTimecard(Employee, Date)`).
       - Lấy danh sách mã công việc (qua phương thức `getChargeNumbers()`).
       - Cập nhật bảng chấm công (qua phương thức `updateTimecard()`).

   - **Phụ thuộc từ Controller Subsystem đến Data Subsystem**:
     - Thành phần `TimecardController` trong Controller Subsystem phụ thuộc vào:
       - `PayrollDBManager`: Để lưu bảng chấm công (qua phương thức `save(Timecard, Employee)`).
       - `IProjectManagementDatabase`: Để lấy danh sách mã công việc (qua phương thức `getChargeNumbers()`).

   - **Không có phụ thuộc từ Data Subsystem đến các hệ thống con khác**:
     - Các thành phần trong Data Subsystem chỉ cung cấp dữ liệu khi được yêu cầu bởi `TimecardController`.

   **Sơ đồ phụ thuộc:**
   ![Diagram](https://www.planttext.com/api/plantuml/png/d5DBQiCm4Dtx5BEC8Rc0AI4uRcYXAO4MkbRjgUDMbin83fZIatNH8_KAjMJPRco5GZT2cdapUcy-tvzV6wKPwRhaGSgPKl1Ob9WoodQIIdWF05QWdMahXIR9EL8qm4PR2mMG5Of56C595farvAYtDH4AtKUSkRD2LPmrNfy9FJBASIipLBumd_iZc0WP6Jev5MlCEudtJB3SY3bCB1sCv2kcEeaZk3rqzyvTjcAIkASuKCUouh91ZE3QtPQGCTs-a_OCnvATYxklosSao_-kKFhgGLCXyhK5rPL9CFpGzs5CDHCzLM8b0oXsGa_u4kQa9ntuXxnP1rpTvnciUKnYdqTPatgIz8OjqJshN46MiEEIwQuk2lMDWItIOG0Yw74sGTJ19s8k1OKERgWNGYEzi1IzNNVr_BDxRQApHLgjrhwLySoeGSxcyGBEEvUp4VZzTx11aPbb_m400F__0m00)

### 5. Maintain Timecard (with Everything)

#### 1. Distribute Subsystem Behavior to Subsystem Elements

Dựa trên **Sequence Diagram**, ta xác định các hành vi chính và phân phối chúng đến các phần tử:

- **Xác thực phiên làm việc (Secure Session)**:
  - **Thực hiện bởi**: Naming, EmployeeSession
  - **Mục đích**: Đảm bảo rằng chỉ người dùng hợp lệ mới có thể truy cập dữ liệu.

- **Lấy thông tin timecard của nhân viên**:
  - **Thực hiện bởi**: PayrollDBManager, TimecardController, Timecard
  - **Mục đích**: Lấy thông tin timecard từ cơ sở dữ liệu hoặc tạo mới nếu chưa tồn tại.

- **Tạo mới timecard nếu chưa tồn tại**:
  - **Thực hiện bởi**: TimecardController, Timecard
  - **Mục đích**: Tạo một đối tượng Timecard mới và liên kết với nhân viên.

- **Lấy danh sách mã công việc (Charge Code)**:
  - **Thực hiện bởi**: TimecardController, ProjectManagementDatabase
  - **Mục đích**: Lấy danh sách mã công việc để nhân viên nhập giờ làm việc.

- **Cập nhật timecard**:
  - **Thực hiện bởi**: TimecardController, Timecard
  - **Mục đích**: Lưu giờ làm việc mới vào timecard.

- **Lưu timecard vào cơ sở dữ liệu**:
  - **Thực hiện bởi**: PayrollDBManager
  - **Mục đích**: Lưu timecard đã chỉnh sửa vào cơ sở dữ liệu.

- **Kiểm tra quyền truy cập**:
  - **Thực hiện bởi**: TimecardAccess, SecurityAccess, EmployeeSession
  - **Mục đích**: Đảm bảo chỉ nhân viên có quyền mới được truy cập hoặc chỉnh sửa timecard.

#### 2. Document Subsystem Elements

**a. Naming**
- **Vai trò**: Cung cấp đối tượng từ xa (remote object)
- **Trách nhiệm**:
  - Tra cứu các đối tượng từ xa dựa trên URL.
  - Trả về tham chiếu đến đối tượng từ xa để sử dụng.

**b. EmployeeSession**
- **Vai trò**: Quản lý phiên làm việc của nhân viên
- **Trách nhiệm**:
  - Xác thực phiên làm việc của nhân viên.
  - Kiểm tra quyền truy cập vào dữ liệu.

**c. TimecardController**
- **Vai trò**: Điều phối các thao tác liên quan đến timecard
- **Trách nhiệm**:
  - Lấy thông tin timecard từ PayrollDBManager.
  - Tạo mới timecard nếu chưa tồn tại.
  - Lấy danh sách mã công việc từ ProjectManagementDatabase.
  - Cập nhật thông tin timecard.
  - Kiểm tra quyền truy cập của nhân viên.

**d. PayrollDBManager**
- **Vai trò**: Quản lý cơ sở dữ liệu bảng lương
- **Trách nhiệm**:
  - Truy xuất thông tin timecard từ cơ sở dữ liệu.
  - Lưu timecard đã chỉnh sửa vào cơ sở dữ liệu.

**e. Timecard**
- **Vai trò**: Đại diện cho bảng chấm công của nhân viên
- **Trách nhiệm**:
  - Lưu trữ thông tin giờ làm việc theo từng mã công việc.
  - Cập nhật giờ làm việc khi có thay đổi.

**f. ProjectManagementDatabase**
- **Vai trò**: Quản lý cơ sở dữ liệu mã công việc
- **Trách nhiệm**:
  - Cung cấp danh sách mã công việc để nhân viên nhập giờ làm việc.

**g. TimecardAccess**
- **Vai trò**: Quản lý quyền truy cập timecard
- **Trách nhiệm**:
  - Xác nhận quyền truy cập của nhân viên đối với timecard.

**h. SecurityAccess**
- **Vai trò**: Quản lý quyền truy cập hệ thống
- **Trách nhiệm**:
  - Xác thực và kiểm tra quyền truy cập của nhân viên.

#### 3. Describe Subsystem Dependencies

Dựa trên **Sequence Diagram**, ta mô tả các phụ thuộc giữa các hệ thống con:

- **TimecardForm → TimecardController**:
  - TimecardForm gửi yêu cầu đến TimecardController để lấy, hiển thị, cập nhật và lưu thông tin timecard.
  
- **TimecardController → PayrollDBManager**:
  - TimecardController phụ thuộc vào PayrollDBManager để lấy và lưu thông tin timecard từ cơ sở dữ liệu.
  
- **TimecardController → ProjectManagementDatabase**:
  - TimecardController lấy danh sách mã công việc từ ProjectManagementDatabase.
  
- **TimecardController → Timecard**:
  - TimecardController tạo mới hoặc cập nhật thông tin trong đối tượng Timecard.
  
- **EmployeeSession → Naming**:
  - EmployeeSession sử dụng Naming để tra cứu và lấy tham chiếu đến các đối tượng từ xa.
  
- **EmployeeSession → SecurityAccess**:
  - EmployeeSession sử dụng SecurityAccess để xác thực quyền truy cập của nhân viên.
  
- **TimecardAccess → SecurityAccess**:
  - TimecardAccess sử dụng SecurityAccess để kiểm tra quyền truy cập timecard.

#### Sơ đồ phụ thuộc:

![Diagram](https://www.planttext.com/api/plantuml/png/d5HBJiCm4Dtd55wc4hr0L5Mb7qGbMYeLmNhg3Acf4qUsKob2d8m5H-8AsB6JVX8GRHRvUDuR-xsPoVVdrqXfaBf8UK0vA4MMaB8i8Uy1CHSNObVaOI5vHDPQca0l8e-RDwGw-0WyOvRcN9I8QrIAYSnJcNe6pcA_62htdCT7YJP2S8IiWcz1tL9gG66XK1vWDqIY4eMas45iZl34KgGWuud8j1ISewnEqISvbFPxEbv01WdAYApELXnC2gjfEex8VENUNJZ5pAnM9qnGrzk4w2MVoAcZDNgo1PdWiaWtA5Le00zCwO633ojGaSUWiScg_SiXbI7j1NCP5Up_0sqyEHVgwtAPZ4ithGFU_lO6rR9L7P6fkLUVMrDVzIBa3Wri0VcWBlqT5w2TLH37CrFRCgH7hXwQf4eHESAnQSxXQvZ6ftiRwgJrFC4APvb6-GeKErlduFhVxT1oq4s3ftUCHoEWiogj2LaZBIJJvKdQlPrGuyzLazSnS_t-i3rVl-0wvwpLinRPDEIPDIUnyv-G3Pvg3aQOnVO_zmC00F__0m00)

# III. Login

### 1. Login

#### 1. Distribute subsystem behavior
Hệ thống con trong hình liên quan đến chức năng Login. Các hành vi được phân phối như sau:

- **Actor (Any User)**:
  - Nhập tên người dùng và mật khẩu vào hệ thống.
  - Gửi yêu cầu xác thực thông tin đăng nhập.

- **LoginForm**:
  - Nhận thông tin đăng nhập từ người dùng.
  - Kiểm tra tính hợp lệ của tên người dùng và mật khẩu (validate username and password).
  - Phản hồi kết quả xác thực (thành công hoặc thất bại).

#### 2. Document subsystem elements

**Phần tử chính**:

- **Actor (Any User)**:
  - Vai trò: Người dùng tương tác với hệ thống.
  - Hành vi:
    - Nhập tên người dùng và mật khẩu.
    - Gửi thông tin đăng nhập đến hệ thống.

- **LoginForm**:
  - Vai trò: Giao diện và logic xử lý thông tin đăng nhập.
  - Hành vi:
    - Nhận thông tin đăng nhập.
    - Thực hiện kiểm tra tính hợp lệ của tên người dùng và mật khẩu.
    - Phản hồi kết quả đăng nhập.

#### 3. Describe subsystem dependencies

**Mô tả phụ thuộc**:

- **Any User → LoginForm**: Người dùng nhập thông tin đăng nhập và gửi yêu cầu đến LoginForm.
- **LoginForm**: Nhận thông tin từ người dùng và thực hiện xác thực thông tin đăng nhập.

**Sơ đồ phụ thuộc**:

![Diagram](https://www.planttext.com/api/plantuml/png/d50n3i8m3Dpp2gjJaU037L2xC34W40ymnAeYfKwLf4KLucKCF8alq4O9804BNYoVxJkVxzTRwJnQtpLQ73Kw1nKFUqSMpWB68FPafvgneOhbPXmv6IlpBc85xBnLNC-XZQs4p0heZPBY8YBpsjIALyOsaRj7hIHw-fl-O8mcv40cbMir3a5ZIwxJFhSXVJadMLmibcz75P05jv2q0La-PJFnclpOIqv-hPR4Slhm0m00__y30000)

## 2. Login (with security)

#### 1. Distribute subsystem behavior
Hệ thống con bao gồm các phần tử chính:

- **Employee**: Người dùng tương tác với hệ thống.
- **MainEmployeeForm**: Giao diện chính xử lý thông tin đăng nhập.
- **LoginForm**: Thành phần xử lý logic xác thực thông tin đăng nhập.
- **EmployeeSession (ISecureUser)**: Quản lý phiên làm việc của người dùng sau khi đăng nhập thành công.

**Phân phối hành vi**:

- **Employee**:
  - Bắt đầu quy trình đăng nhập.
  - Nhập tên người dùng và mật khẩu.
  - Gửi yêu cầu đăng nhập.

- **MainEmployeeForm**:
  - Mở giao diện đăng nhập.
  - Nhận thông tin từ người dùng (tên người dùng, mật khẩu).
  - Gửi yêu cầu xác thực đến LoginForm.
  - Thiết lập ngữ cảnh bảo mật (Security Context) nếu đăng nhập thành công.
  - Hiển thị các chức năng khả dụng sau khi đăng nhập.

- **LoginForm**:
  - Xác thực thông tin đăng nhập (validateUserIDPassword).
  - Trả về kết quả đăng nhập.

- **EmployeeSession (ISecureUser)**:
  - Lưu trữ thông tin phiên người dùng sau khi đăng nhập thành công.
  - Cung cấp ngữ cảnh người dùng (user context) cho các chức năng khác.

#### 2. Document subsystem elements

**Employee**:
- Vai trò: Người dùng tương tác với hệ thống.
- Hành vi:
  - `start()`: Bắt đầu quy trình đăng nhập.
  - `enterUserName()`: Nhập tên người dùng.
  - `enterPassword()`: Nhập mật khẩu.
  - `loginUser()`: Gửi yêu cầu đăng nhập.

**MainEmployeeForm**:
- Vai trò: Giao diện chính xử lý quy trình đăng nhập.
- Hành vi:
  - `open()`: Mở giao diện đăng nhập.
  - `setupSecurityContext()`: Thiết lập ngữ cảnh bảo mật.
  - `displayAvailOperations()`: Hiển thị các chức năng khả dụng.
  - `close()`: Đóng giao diện đăng nhập.

**LoginForm**:
- Vai trò: Xử lý logic xác thực thông tin đăng nhập.
- Hành vi:
  - `validateUserIDPassword()`: Kiểm tra tính hợp lệ của tên người dùng và mật khẩu.

**EmployeeSession (ISecureUser)**:
- Vai trò: Quản lý phiên làm việc của người dùng.
- Hành vi:
  - `new(UserID)`: Tạo phiên làm việc mới.
  - `getUserContext()`: Trả về ngữ cảnh người dùng.

#### 3. Describe subsystem dependencies

**Mối quan hệ giữa các phần tử**:

- **Employee → MainEmployeeForm**: Người dùng khởi tạo quy trình đăng nhập và nhập thông tin đăng nhập qua giao diện chính.
- **MainEmployeeForm → LoginForm**: Gửi thông tin đăng nhập đến LoginForm để xác thực và nhận kết quả đăng nhập từ LoginForm.
- **MainEmployeeForm → EmployeeSession (ISecureUser)**: Nếu đăng nhập thành công, MainEmployeeForm thiết lập ngữ cảnh bảo mật bằng cách tạo một phiên làm việc mới qua EmployeeSession.
- **EmployeeSession (ISecureUser)**: Lưu trữ thông tin phiên làm việc và cung cấp ngữ cảnh người dùng cho các chức năng khác.

**Sơ đồ phụ thuộc**:

![Diagram](https://www.planttext.com/api/plantuml/png/T59BQiCm4Dth5CAh59mBU15I-e52snHC3p2r1YEGDK8ZEpMb9-kYH-eLAgLEua-ZfKRlE_hv-jvo01_QneZA0BEyQvoX7b5-21dFORgwAcH7MXrkq0Rqhup-6HfSJbuYoPwycamCrTecpEdsKmnwJw3jKVEUV3FeaaCxeM0ChIknQhqE_Gr5gVUfBwNP6UYlEz1cvz13q6HvygGonBYqy9ZSZRGxC5f1m6JuuNOSw8t88DWpzEYyHEOeDn1OtA_-m8KiWzUs7hkeCQJXF4FaF7M_Nc-MnHGo6xQHpvUGpxlFnvLdOi6L1Cwn8_Ebp1Umyzp9sxyBoiGMhKhVwnS00F__0m00)
