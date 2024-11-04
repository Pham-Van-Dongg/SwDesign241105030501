# Phân tích tất cả các ca sử dụng còn lại trong hệ thống Payroll System

## 1. Create Employee:

  Lớp NhânViên (Employee) : đại diện cho mỗi nhân viên trong hệ thống, lưu trữ thông tin cơ bản của nhân viên như mã nhân viên, tên, chức vụ, và các thông tin cá nhân khác cần thiết cho quá trình tính lương và quản lý.

    Thuộc tính:

    - maNhanVien: Mã số định danh cho mỗi nhân viên.
    - tenNhanVien: Tên đầy đủ của nhân viên.
    - chucVu: Chức vụ hiện tại của nhân viên trong công ty.
    - ngaySinh: Ngày sinh của nhân viên.
    - diaChi: Địa chỉ liên lạc của nhân viên.

  Lớp DịchVụQuảnLýNhânViên (EmployeeManagementService)

    Phương thức:
    
    - taoNhanVien(thongTinNhanVien): Tạo hồ sơ nhân viên mới với các thông tin chi tiết như tên, chức vụ, ngày sinh, và địa chỉ.
    - capNhatThongTinNhanVien(maNhanVien, thongTinMoi): Cập nhật thông tin của nhân viên dựa trên mã nhân viên và thông tin mới được cung cấp.
    - xoaNhanVien(maNhanVien): Xóa nhân viên khỏi hệ thống dựa trên mã nhân viên.

  Lớp KhoDuLieuNhanVien (EmployeeRepository)

    Phương thức:

    - luuThongTinNhanVien(thongTinNhanVien): Lưu hồ sơ nhân viên mới vào cơ sở dữ liệu.
    - layThongTinNhanVien(maNhanVien): Lấy thông tin chi tiết của nhân viên dựa trên mã nhân viên.
    - xoaThongTinNhanVien(maNhanVien): Xóa thông tin nhân viên khỏi cơ sở dữ liệu.

## 2. Maintain Purchase Order

  Lớp DonDatHang (PurchaseOrder) : đại diện cho mỗi đơn đặt hàng trong hệ thống. Thông tin của đơn đặt hàng có thể được sử dụng để tính toán hoa hồng cho nhân viên.

    Thuộc tính:

    - maDonHang: Mã số của đơn đặt hàng.
    - soLuongHang: Số lượng hàng hóa trong đơn đặt hàng.
    - giaTriDonHang: Tổng giá trị của đơn đặt hàng.

  Lớp DịchVụQuanLyDonHang (OrderManagementService) : cung cấp các dịch vụ quản lý đơn đặt hàng, cho phép tạo mới, cập nhật, và xóa đơn đặt hàng trong hệ thống.

    Phương thức:

    - taoDonHang(thongTinDonHang): Tạo một đơn đặt hàng mới với các thông tin về số lượng hàng và giá trị đơn hàng.
    - capNhatDonHang(maDonHang, thongTinMoi): Cập nhật thông tin của một đơn đặt hàng đã có dựa trên mã đơn hàng.
    - xoaDonHang(maDonHang): Xóa đơn đặt hàng khỏi hệ thống dựa trên mã đơn hàng.

  Lớp KhoDuLieuDonHang (OrderRepository) : quản lý việc lưu trữ và truy xuất thông tin đơn đặt hàng từ cơ sở dữ liệu. Nó chịu trách nhiệm lưu trữ các thông tin cần thiết cho mỗi đơn đặt hàng.

    Phương thức:

    - luuThongTinDonHang(thongTinDonHang): Lưu thông tin của đơn đặt hàng vào cơ sở dữ liệu.
    - layThongTinDonHang(maDonHang): Lấy thông tin đơn đặt hàng từ cơ sở dữ liệu dựa trên mã đơn hàng.

## 3. Login
    
  Lớp TaiKhoan (Account) : đại diện cho tài khoản đăng nhập của người dùng. Nó lưu trữ thông tin cần thiết để xác thực người dùng trong hệ thống.

    Thuộc tính:
  
    - tenDangNhap: Tên đăng nhập của người dùng.
    - matKhau: Mật khẩu đăng nhập của người dùng.

  Lớp DịchVụDangNhap (LoginService)

    Phương thức:

    - dangNhap(tenDangNhap, matKhau): Xác thực người dùng dựa trên tên đăng nhập và mật khẩu.
    - kiemTraQuyen(truyCap): Kiểm tra quyền truy cập của người dùng sau khi đăng nhập.

  Lớp KhoDuLieuTaiKhoan (AccountRepository)

    Phương thức:

    - layThongTinTaiKhoan(tenDangNhap): Truy xuất thông tin tài khoản từ cơ sở dữ liệu dựa trên tên đăng nhập.

## 4. Create Administrative Report

  Lớp BaoCaoQuanTri (AdministrativeReport) :  đại diện cho các báo cáo quản trị được tạo ra trong hệ thống, bao gồm thông tin liên quan đến lương, chấm công, và quản lý nhân sự.

    Thuộc tính:

    - loaiBaoCao: Loại báo cáo quản trị (ví dụ: báo cáo lương, báo cáo chấm công).
    - ngayBaoCao: Ngày báo cáo được tạo.

  Lớp DịchVụBaoCao (ReportService)

    Phương thức:

    - taoBaoCao(loaiBaoCao, thoiGian): Tạo báo cáo quản trị dựa trên loại báo cáo và thời gian cần báo cáo.
  
  Lớp KhoDuLieuBaoCao (ReportRepository)

    Phương thức:

    - luuBaoCao(baoCao): Lưu trữ báo cáo vào cơ sở dữ liệu để tham chiếu sau này.

## 5. Maintain Employee Info

  Lớp NhânViên (Employee)

    Thuộc tính:

## Các thuộc tính tương tự như đã đề cập trong lớp Employee ở ca sử dụng "Create Employee".
  
  Lớp DịchVụCapNhatThongTin (UpdateService)

    Phương thức:

    - capNhatThongTin(nhanVien, thongTinMoi): Cập nhật thông tin cá nhân của nhân viên trong hệ thống dựa trên thông tin mới được cung cấp.

## 6. Run Payroll
  
  Lớp BangLuong (Payroll) : đại diện cho mỗi bảng lương của nhân viên, bao gồm thông tin chi tiết về số tiền lương và ngày thanh toán.

    Thuộc tính:

    - maNhanVien: Mã số nhân viên nhận lương.
    - soTien: Số tiền lương được thanh toán.
    - ngayThanhToan: Ngày thực hiện thanh toán.

  Lớp DịchVụTinhLuong (PayrollService)

    Phương thức:

    - tinhToanLuong(nhanVien): Tính toán lương dựa trên thông tin làm việc của nhân viên.
    - thucHienThanhToan(nhanVien): Tiến hành chuyển khoản hoặc phát hành lương cho nhân viên.

  Lớp KhoDuLieuLuong (PayrollRepository)

    Phương thức:

    - luuThongTinLuong(chiTietLuong): Lưu thông tin thanh toán lương vào cơ sở dữ liệu.
    - layThongTinLuong(maNhanVien): Lấy thông tin lương của nhân viên từ cơ sở dữ liệu.

## 7. Printer

  Lớp MayIn (Printer) :  đại diện cho máy in, sử dụng để in phiếu lương hoặc báo cáo khi cần.

    Phương thức:

    - in(baoCao): In báo cáo hoặc phiếu lương dựa trên thông tin được cung cấp.

## 8. Bank System

  Lớp HeThongNganHang (BankSystem) :đại diện cho hệ thống ngân hàng, giúp thực hiện chuyển khoản tiền lương vào tài khoản của nhân viên.

    Phương thức:

    - chuyenKhoan(soTien, taiKhoanNhanVien): Thực hiện chuyển khoản số tiền lương vào tài khoản ngân hàng của nhân viên.

## 9. Project Database

  Lớp CoSoDuLieuDuAn (ProjectDatabase) : lưu trữ dữ liệu vào database

    Phương thức:

    - luuDuLieu(nhanVien): Lưu thông tin nhân viên vào cơ sở dữ liệu dự án.
    - layDuLieu(maNhanVien): Truy xuất dữ liệu nhân viên từ cơ sở dữ liệu dựa trên mã nhân viên.
