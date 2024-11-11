# Phân tích các ca sử dụng còn lại

## 1. Xác định các lớp phân tích cho ca sử dụng "Create Employee"

Lớp NhânViên (Employee): Đại diện cho mỗi nhân viên được tạo mới trong hệ thống. Lớp này lưu trữ thông tin cơ bản về nhân viên, bao gồm mã nhân viên, tên, phương thức thanh toán và loại nhân viên.

**Thuộc tính:**
  -	maNhanVien
  -	tenNhanVien
  -	phuongThucThanhToan
  -	loaiNhanVien

Lớp DịchVụNhanViên (EmployeeService): Xử lý các nghiệp vụ liên quan đến việc tạo nhân viên mới. Lớp này chịu trách nhiệm xác minh và lưu thông tin nhân viên vào cơ sở dữ liệu.

**Phương thức:**

  - taoNhanVien(nhanVien)
   
Lớp KhoDuLieuNhanVien (EmployeeRepository): Quản lý việc lưu trữ và truy xuất thông tin nhân viên từ cơ sở dữ liệu.

**Phương thức:**

  -	luuThongTinNhanVien(nhanVien)
  -	layThongTinNhanVien(maNhanVien)
    
### 2. Biểu đồ Sequence cho ca sử dụng "Create Employee"

![Diagram](https://www.planttext.com/api/plantuml/png/UhzxlqDnIM9HIMbk3bTYSab-aO9ZIcvcda9YiK90OcLHVauEcCzL05IJcPnPa9XNek3oS7TtSaROmzrB_J8Iyy8oKr6blJFoNKfzCbDBuR9So4OfwDfXCK71IY7oyAfIXUI7kvQNAfGytBKmNo4lu_2YF8MopCEhyXHo7-wUdSc5HH_GD0mBWORv7Di0D2RZy9QyT8KIeAL8Pk4m1SMDLWeHXnSc0tKztBKs3ujpW2OloCjGI0QPpyNba9gN0Wf000000F__0m00)

### 3. Xác định nhiệm vụ của từng lớp phân tích

- Lớp NhânViên: Cung cấp thông tin nhân viên mới cho lớp dịch vụ.
- Lớp DịchVụNhanViên: Thực hiện nghiệp vụ xác thực thông tin và lưu trữ thông tin nhân viên mới.
- Lớp KhoDuLieuNhanVien: Quản lý việc lưu trữ và truy xuất thông tin nhân viên trong cơ sở dữ liệu.

### 4. Biểu đồ lớp (Class Diagram) mô tả các lớp phân tích:
   
![Diagram](https://www.planttext.com/api/plantuml/png/Z94z2i9048NxFSMKMkG2ASGYdM9Zi5_Ma5bOPyNi22AUm5i8QQmih4nX4V0UEO5NC87uWnl1hNRVpFjuCtilhiFCoPNZXH7Ao2o32KgQwOHWAw0-0IpaImfXwbQQqhRY4lfLMY9RIcDa5TST65lfjHWhjM_VYJP7L1LxXREgoByI0JXfdrgFteIdrg_lQwldRzO8RSHZdR27CimnDaar_OLiNNBZkJhMrFyWD65U3K4mw9el1CMKWgek-H8SbkVwuJG1ONaWMEloIAB3rj3y2KCmjnF_meXXGlFcqny0003__mC0)

**Quan hệ giữa các lớp:**

-	EmployeeService liên kết với EmployeeRepository để lưu thông tin nhân viên.
-	Employee chứa các thuộc tính cơ bản của nhân viên và được xử lý bởi EmployeeService.
  
**Nhiệm vụ của các lớp:**

-	Employee chứa dữ liệu nhân viên.
-	EmployeeService xử lý logic nghiệp vụ cho quá trình tạo nhân viên.
-	EmployeeRepository lưu trữ thông tin nhân viên vào cơ sở dữ liệu.

## 2. Phân tích ca sử dụng "Login"

### 1. Xác định các lớp phân tích cho ca sử dụng "Login"

Lớp TàiKhoan (Account): Đại diện cho tài khoản người dùng trong hệ thống, bao gồm tên đăng nhập và mật khẩu.

**Thuộc tính:**

-	tenDangNhap
-	matKhau
  
Lớp DịchVụXacThuc (AuthenticationService): Xử lý quá trình xác thực khi người dùng đăng nhập vào hệ thống.

**Phương thức:**

-	xacThuc(tenDangNhap, matKhau)

Lớp KhoDuLieuTaiKhoan (AccountRepository): Lưu trữ và truy xuất thông tin tài khoản từ cơ sở dữ liệu.
  
**Phương thức:**

- layTaiKhoan(tenDangNhap)
  
### 2. Biểu đồ Sequence cho ca sử dụng "Login"

![Diagram](https://www.planttext.com/api/plantuml/png/UhzxlqDnIM9HIMbk3bTYSab-aO9VUcb-fajfNZfN0L0yCpcp836lHC7buUxkv8omXxkNkYJcfVjb91QWI7jdvBkK-cIcbY9qSy6P2hfsMFGhM2duPJpSjRP0eIJZy1QWgfBCF8KZ4uyq0vbvO0akB9g0Hc7Q1JJAv-6kfPN89kMb7zlmSFVSJ8MKmpk1hi6YIHUNiqAA7kvQh53sS7SZ7WEnkmtPIH675oP3V8BcBv2f2_8o5991PkkN0CMMbYWaFTorC9EBoo4rBmKK5m00003__mC0)

### 3. Xác định nhiệm vụ của từng lớp phân tích
   
-	Lớp TàiKhoan: Lưu trữ thông tin đăng nhập.
-	Lớp DịchVụXacThuc: Xử lý xác thực dựa trên tên đăng nhập và mật khẩu.
-	Lớp KhoDuLieuTaiKhoan: Lưu trữ và truy xuất thông tin tài khoản.
  
### 4. Biểu đồ lớp (Class Diagram) mô tả các lớp phân tích

![Diagram](https://www.planttext.com/api/plantuml/png/TD6nRi8m40RWtKzn8mnvWGmLgh9HiJJgVZAHRScS4R4b469YPEe3TEZ0YDHANOg73a6yXv-0Ly0HA8bGwids-Rxx9L_ytwYqkB1kfXdNM9Om4Swep960DOEu4h05PKXY8d4EARpQXI9nBytGZYMwzdh3xamM_8xBj-3tJU_D0rWYpwNZ0secfUtKOJmy6wCBf1ORIvEv5rMunt006bUvD2HoHKrnq9Tus9rIqwsL94zzULCGmHyKM5dzn5TM4PpUJzku9HcEXpdhwQcfdhGfw73ShxeKYVDNy1yAfjLl3FIFrIMMrIUFGl3Vl0CnDYfeMl_V5G00__y30000)

**Quan hệ giữa các lớp:**

- AuthenticationService liên kết với AccountRepository để lấy thông tin tài khoản.
  
**Nhiệm vụ của các lớp:**

- Account chứa dữ liệu tài khoản.
- AuthenticationService xử lý xác thực.
-	AccountRepository lưu trữ và truy xuất thông tin tài khoản.


## 3. Phân tích ca sử dụng "Run Payroll":

### 1. Xác định các lớp phân tích cho ca sử dụng "Run Payroll"

Lớp DịchVụTinhLuong (PayrollService): Xử lý quá trình tính lương cho tất cả nhân viên.

**Phương thức:**

-	tinhToanLuongTatCa()
-	Lớp KhoDuLieuNhanVien (EmployeeRepository): Lấy thông tin về từng nhân viên để tính lương.

**Phương thức:**

-	layTatCaNhanVien()

Lớp KhoDuLieuThanhToan (PaymentRepository): Lưu trữ thông tin thanh toán cho từng nhân viên.

**Phương thức:**

- luuThongTinThanhToan(thongTinThanhToan)

### 2. Biểu đồ Sequence cho ca sử dụng "Run Payroll"
   
![Diagram](https://www.planttext.com/api/plantuml/png/T94nJiCm58Ptd-9TW0jqG9NeW4J4WjNTSYDiaJw7vBbIHcQcdW02we90wi1K3moMSW-VW2lm0a9ArMIn9V_-_-_tytVucjUaAlBhGYXDheARfgPyVL4uVITALgosfKA2HGgFsYnJs4cB9lCERu_qA-CMFhEv7vUlZSAbpV7eK1g-nlSbYqOwXK8Cy71sFaQ56RDIUBAWJJgq3Tpx1gYAxsY0uWUlHRVlMkQFcJdplme7PUcmOxE9dooHHK0JNn0sDhxXbFsaDEV8Nowvs2BKAMmvAuK7X98RlbfknzjKtkdW-cBTtWzxKG_x0qpb32StWqiNdzd6xwF1W8IOvxZgF_i7003__mC0)

### 3. Xác định nhiệm vụ của từng lớp phân tích

-	Lớp DịchVụTinhLuong: Xử lý quá trình tính lương và lưu trữ thông tin thanh toán.
-	Lớp KhoDuLieuNhanVien: Cung cấp thông tin nhân viên để tính lương.
-	Lớp KhoDuLieuThanhToan: Lưu thông tin thanh toán.

### 4. Biểu đồ lớp (Class Diagram) mô tả các lớp phân tích
   
![Diagram](https://www.planttext.com/api/plantuml/png/T9AnJiCm48PtFyMDPSWBP40Tib6nO7KtZfMpv9vHuqEg43C3Jz614GaaDWyCaVeUUG9U0QUaRP1RJ_RTVz_T_V9F_9wtGQq3hvpGJhKjL7ryrRZiuvkqX0lsrC2JWFtHg3RxoEmAIdZqjXRFOgoxHKLBQsWK5x1Inr09Ts5jgHap3pWm9BAMIO7Iguda29GuY2oTD0Tow-KVjVPyxymOfKPjfhnA1NEYtQ2lU64DvrivvgpNB6JTotoYgGldV2kAQvYO4BftGWY-snAutSTkczQzL7Pctd8eOWZOVQLNi9IkwW2y2CfjJ8DW7pyreEtZot-Ac1kgXy_m2m00__y30000)

**Quan hệ giữa các lớp:**

- PayrollService liên kết với EmployeeRepository và PaymentRepository để lấy thông tin và lưu trữ kết quả.
  
**Nhiệm vụ của các lớp:**

-	PayrollService xử lý tính toán lương.
-	EmployeeRepository cung cấp dữ liệu nhân viên.
-	PaymentRepository lưu trữ dữ liệu thanh toán.

## 4. Phân tích ca sử dụng "Maintain Purchase Order"

### 1. Xác định các lớp phân tích cho ca sử dụng "Maintain Purchase Order"
   
Lớp ĐơnHang (PurchaseOrder): Đại diện cho đơn hàng, lưu trữ các thông tin về sản phẩm, số lượng và giá.

**Thuộc tính:**

-	maDonHang
-	tenSanPham
-	soLuong
-	gia
  
Lớp DịchVụDonHang (PurchaseOrderService): Xử lý việc tạo mới, cập nhật, hoặc xóa đơn hàng.

**Phương thức:**

-	taoDonHang(donHang)
-	capNhatDonHang(donHang)
-	xoaDonHang(donHang)
  
Lớp KhoDuLieuDonHang (PurchaseOrderRepository): Lưu trữ và truy xuất thông tin đơn hàng từ cơ sở dữ liệu.

**Phương thức:**

-	luuDonHang(donHang)
-	layDonHang(maDonHang)
  
### 2. Biểu đồ Sequence cho ca sử dụng "Maintain Purchase Order"

![Diagram](https://www.planttext.com/api/plantuml/png/ZD0n2i9040NGFgUO2qZw528OGL0iHSjXNTn0CXlCBEWPhBo1AKGG146hfB1OyHuvWLTmWqq2AQnsc1aUV_PJFWSPuuPD4dieM6zWff3caIJ038OwIKP96kkTb5xgrY8HfKWCOLNkXPfNvIdK52AFaTQjXOdIePb6qZJcNfE3NhzJWG2Mzc90LCNP05T5hdrNNrCWvHxsj_QEy3gySm9bZuxjL9pU4S7Xq_VD_6-q4WUmiBduvI1WXHguRd1jA13sKHyvaBIgV_CB003__mC0)

### 3. Xác định nhiệm vụ của từng lớp phân tích

-	Lớp ĐơnHang: Lưu trữ thông tin về đơn hàng.
-	Lớp DịchVụDonHang: Xử lý các nghiệp vụ liên quan đến đơn hàng.
-	Lớp KhoDuLieuDonHang: Lưu trữ và truy xuất thông tin đơn hàng.
  
### 4. Biểu đồ lớp (Class Diagram) mô tả các lớp phân tích

![Diagram](https://www.planttext.com/api/plantuml/png/UhzxlqDnIM9HIMbk3bToJc9niO9BVfvBOeb7ObwwGZMN0X3eAXJd0mN18bOAmIL5cNdfK8cyzCHAc68h1I0h5IfHaf-N7fmVafcQ1nHFoIzDoadbgkM2sV1mTtToHjZ3tKinx59GA4c4MQQH0hSKeKuJo2lBpqo1gavEBF3BI2mXGKT5VY9Hgk6kzSx8TodroKmjnUBOdD9Iygp6355aYv5iqjMrmnfUN5W34QGQYtkvk1nIyr90KGm0003__mC0)

**Quan hệ giữa các lớp:**

- PurchaseOrderService liên kết với PurchaseOrderRepository để lưu hoặc cập nhật đơn hàng.
    
**Nhiệm vụ của các lớp:**

- PurchaseOrder chứa dữ liệu đơn hàng.
-	PurchaseOrderService xử lý logic nghiệp vụ.
-	PurchaseOrderRepository lưu trữ thông tin đơn hàng.

## 5. Phân tích ca sử dụng "Create Administrative Report"

### 1. Xác định các lớp phân tích cho ca sử dụng "Create Administrative Report"

Lớp BaoCao (Report): Đại diện cho báo cáo hành chính.

**Thuộc tính:**

-	loaiBaoCao
-	ngayBaoCao
-	noiDungBaoCao

Lớp DịchVụBaoCao (ReportService): Xử lý việc tạo báo cáo mới.

**Phương thức:**

- taoBaoCao(baoCao)
  
Lớp KhoDuLieuBaoCao (ReportRepository): Lưu trữ và truy xuất thông tin báo cáo từ cơ sở dữ liệu.

**Phương thức:**

- luuBaoCao(baoCao)
  
### 2. Biểu đồ Sequence cho ca sử dụng "Create Administrative Report"
   
![Diagram](https://www.planttext.com/api/plantuml/png/UhzxlqDnIM9HIMbk3bTYSab-aO9ZIcvcda9YiK90OcLHVauEcCzL05IJcPnPa9XNek3oS7TtSaROmzrBdHBpdHFpKIIzC_9TIdqoKqkXSbp8nYZesc7eLh1IY3oygbGX-U6kvQKA9GztBSnNI3eC99A111U6Qg09Q5O03V0vjg4KeKcXxF028ElOGeNYXxldAwGytBrU8IVpuUxsKgp6eJZGIY6awE6knGfb3tSt8fbuPEBXnH2tSN4vfEQbW88B0000__y30000)

### 3. Xác định nhiệm vụ của từng lớp phân tích

- Lớp BaoCao: Lưu trữ thông tin về báo cáo.
-	Lớp DịchVụBaoCao: Xử lý tạo báo cáo.
-	Lớp KhoDuLieuBaoCao: Lưu trữ thông tin báo cáo.
  
### 4. Biểu đồ lớp (Class Diagram) mô tả các lớp phân tích

![Diagram](https://www.planttext.com/api/plantuml/png/UhzxlqDnIM9HIMbk3bToJc9niO9JOhvpOhv2DPS24EWgv2P21QmKWakAClFIeU9v-PakfNdf6CBfYPKXODKkYIMfNBLSK5DT7kxkJiu8UxXxAOhv2WebYVaG4GrDe2O84ofLKPfO0fLBWha1mWSfBSlFJ46OxvsHxrBgavbQYcPyJcafOIEWUdHrxJ3SoONXS90gDDkuk1nIyr90GGW0003__mC0)

**Quan hệ giữa các lớp:**

- ReportService liên kết với ReportRepository để lưu trữ báo cáo.
  
**Nhiệm vụ của các lớp:**

-	Report chứa dữ liệu báo cáo.
-	ReportService xử lý tạo báo cáo.
-	ReportRepository lưu trữ thông tin báo cáo.

