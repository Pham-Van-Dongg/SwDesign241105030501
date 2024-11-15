# Lab 3. Identify design elements

## 1. Subsystem context diagrams

### 1.1. Biểu đồ ngữ cảnh của hệ thống con ProjectManagementDatabase subsystems

![Diagram](https://www.planttext.com/api/plantuml/png/b5F1JeGm4BttA-Qc7lW1GiWQkUp1nApeVMHdeQOCf1qIYVfb7lmaVy5IaDM3BDjBspVpvhtEf5yVdnidQAMhZRg0Z0wQ2Uviyqo5t29ZIJMnP2ZuX8vk6XRR64CMq052CTzLOT2vLSmaETBI55uL-2Mswn-Hi-wQBsiSDeX1irpvRRYfTtNqj_rN9jZYWKZsW0Mf-RH46YqOxFEguJBNAssSSa4lNflHWEkTK7sgHRunFuovBMTx2k59daLBFwa6t0i4R2x_kzmu1k89kHUhkGnWKUbSa_mD1D4T6HJTiAjqwzIQuKTHkZI961uSERMGaRn5qK8FOzZMhGdOUaFJotOadMK7xKY3lSzM6-Bzy3c-0G00__y30000)

  ##### 1.1.1 Các thành phần và vai trò:
    a. ProjectManagementDatabaseController

      Loại: Controller

      Mô tả: Xử lý các yêu cầu từ các hệ thống bên ngoài (như hệ thống quản lý lương) và truy vấn thông tin dự án từ ProjectManagementDatabase.

      Phương thức:

        - truyVanDuAn(maDuAn: int): DuAn: Truy vấn thông tin dự án từ ProjectManagementDatabase dựa trên mã dự án.

    b. IProjectManagementDatabase

      Loại: Interface

      Mô tả: Định nghĩa giao diện của hệ thống ProjectManagementDatabase.

      Phương thức:

        - layThongTinDuAn(maDuAn: int): DuAn: Lấy thông tin về dự án từ cơ sở dữ liệu.
    
    c. ProjectManagementDatabase

      Loại: External system

      Mô tả: Hệ thống bên ngoài chứa dữ liệu về các dự án, bao gồm mã dự án, tên dự án, và các chi tiết về dự án.

      Phương thức:

        - layThongTinDuAn(maDuAn: int): DuAn: Trả về thông tin chi tiết về dự án theo mã dự án.
    
    d. DuAn

      Loại: Entity

      Thuộc tính:
  
        - maDuAn: int: Mã dự án.
        - tenDuAn: String: Tên dự án.
        - chiTietDuAn: String: Chi tiết về dự án.

  ##### 1.1.2 Các mối quan hệ

    ProjectManagementDatabaseController --> IProjectManagementDatabase:
  
      - ProjectManagementDatabaseController sử dụng IProjectManagementDatabase để truy vấn thông tin dự án từ ProjectManagementDatabase.

    IProjectManagementDatabase <|-- ProjectManagementDatabase:

      - ProjectManagementDatabase triển khai giao diện IProjectManagementDatabase, cung cấp chức năng truy vấn thông tin dự án.

    ProjectManagementDatabaseController --> DuAn:

      - ProjectManagementDatabaseController trả về đối tượng DuAn khi nhận yêu cầu truy vấn thông tin dự án từ hệ thống bên ngoài.

  ##### 1.1.3 Vai trò và chức năng

    Hệ thống con ProjectManagementDatabaseController:

      Vai trò: Xử lý các yêu cầu từ hệ thống bên ngoài và truy vấn thông tin dự án từ ProjectManagementDatabase.

      Chức năng:

        - Truy vấn thông tin về dự án theo mã dự án từ ProjectManagementDatabase.
    
    Hệ thống con IProjectManagementDatabase:

      Vai trò: Định nghĩa giao diện để truy xuất thông tin về dự án từ ProjectManagementDatabase.

      Chức năng:
  
        - Đảm bảo ProjectManagementDatabase cung cấp phương thức truy vấn thông tin về dự án.

    Hệ thống con ProjectManagementDatabase:

      Vai trò: Cung cấp dữ liệu về các dự án cho ProjectManagementDatabaseController.

      Chức năng:

        - Lưu trữ và cung cấp thông tin dự án khi có yêu cầu từ ProjectManagementDatabaseController.

    Hệ thống bên ngoài DuAn:

      Vai trò: Đại diện cho thông tin dự án trong hệ thống quản lý dự án.

      Chức năng:

        - Lưu trữ các thuộc tính của dự án như mã dự án, tên dự án và chi tiết dự án.

### 1.2. Biểu đồ ngữ cảnh của hệ thống con PrintService
![Diagram](https://www.planttext.com/api/plantuml/png/j5J1JiCm3BtdAtm33lk1gPe632GaGB0Dxbxdha5fKYKfMWLy6GS-YLyWJTVIT1kWIVIIndxsUtQSVBv_Z8r5ROjCi2EOKC8bmHsMMWanAusb3D00WYaMnczPBD2O7YIAMlze12yCt6THdQ4wHtLTABawFWcDjodAHqxoECFc5uR0fUtXxWkKSyrT-1lh2DJgYM9xWn9Nb96q4xIuG4DUh0HQMz8I1OIQzqP5KHFHoXTOpbCdVCxbf3YjT5RBHgDRgbseQTCHqiyy_aL82FsPlMxVLflSuZs1Xeii5wgabbrQRiiDQUjpTDxUalLproT0icETMSrxNBuTEtYyVGV7T_kQ_1lBZjo-ibt9QyVVAZ1gxWnrn10IeT261RZJloGRfwHxCmwvLkksdWwiC-Srvf03EsYwhgQKAst3wN9WqWd6nDg_Fl0Vx-AK15gkf4bvRbYFDteT3C97WeLFnc0m2bexX0T3XdLD5QHtLORWdM1Ge2wTnaJfpAlOZjnxsviaUOs0fNCmDYQvh5x1Bm000F__0m00)

  ##### 1.2.1 Các thành phần và vai trò

    a. PayrollSystem
      Loại: Subsystem (hệ thống con)

      Mô tả: PayrollSystem chịu trách nhiệm xử lý các báo cáo liên quan đến lương và nhân viên trong hệ thống trả lương.

      Cung cấp các phương thức:

      - taoBaoCaoLuong(): Tạo báo cáo về lương của toàn bộ nhân viên.
      - taoBaoCaoNhanVien(maNhanVien: int): Tạo báo cáo chi tiết cho một nhân viên cụ thể.
      - taoBaoCaoQuanTri(): Tạo báo cáo quản trị cho hệ thống.

    b. DataFetcher
      Loại: Subsystem proxy (hệ thống con proxy)

      Mô tả: DataFetcher đóng vai trò trung gian để truy xuất dữ liệu từ các hệ thống bên ngoài như PayrollService và ProjectManagementDatabase.

      Cung cấp các phương thức:

      - layThongTinLuong(maNhanVien: int): Lấy thông tin lương của nhân viên từ PayrollService.
      - layThongTinDuAn(maDuAn: int): Lấy thông tin dự án từ ProjectManagementDatabase.

    c. IReportService
      Loại: Interface

      Mô tả: IReportService định nghĩa giao diện mà các hệ thống con phải tuân theo để tạo báo cáo. Đây là giao diện chung cho các hệ thống như PayrollSystem.

      Cung cấp các phương thức:

      - taoBaoCaoLuong()
      - taoBaoCaoNhanVien(maNhanVien: int)
      - taoBaoCaoQuanTri()

    d. PayrollService
      Loại: External system (hệ thống bên ngoài)

      Mô tả: PayrollService chứa dữ liệu lương của nhân viên và cung cấp thông tin lương cho các hệ thống bên ngoài.

      Cung cấp phương thức:

      - layThongTinLuong(maNhanVien: int): Trả về thông tin lương của nhân viên.

    e. ProjectManagementDatabase
      Loại: External system (hệ thống bên ngoài)

      Mô tả: ProjectManagementDatabase lưu trữ dữ liệu về các dự án và mã chi phí của công ty.

      Cung cấp phương thức:

      - layThongTinDuAn(maDuAn: int): Trả về thông tin dự án và mã chi phí tương ứng.

    f. Luong
      Loại: Entity (thực thể)

      Mô tả: Luong đại diện cho thông tin lương của nhân viên, bao gồm các thuộc tính như số tiền lương.

    g. DuAn

      Loại: Entity (thực thể)

      Mô tả: DuAn đại diện cho thông tin về các dự án và mã chi phí của công ty, bao gồm tên dự án và mã chi phí.

  ##### 1.2.2 Các mối quan hệ

    IReportService <|-- PayrollSystem:
      
      - PayrollSystem triển khai giao diện IReportService, có nghĩa là PayrollSystem cung cấp chức năng được định nghĩa trong giao diện này.
    
    PayrollSystem --> DataFetcher:

      - PayrollSystem sử dụng DataFetcher để lấy dữ liệu cần thiết từ các hệ thống bên ngoài như PayrollService và ProjectManagementDatabase.
    
    DataFetcher --> PayrollService:

      - DataFetcher gửi yêu cầu tới PayrollService để lấy thông tin lương của nhân viên.
    
    DataFetcher --> ProjectManagementDatabase:
    
      - DataFetcher gửi yêu cầu tới ProjectManagementDatabase để lấy thông tin về các dự án và mã chi phí.

  ##### 1.2.3 Vai trò và chức năng

  Hệ thống con PayrollSystem:

    Vai trò: Chịu trách nhiệm xử lý và tạo báo cáo về lương và nhân viên.

    Chức năng:

      - Tạo báo cáo về lương, nhân viên, và các báo cáo quản trị.
      - Dùng DataFetcher để truy xuất dữ liệu từ PayrollService và ProjectManagementDatabase.

  Hệ thống con DataFetcher:

    Vai trò: Đảm nhiệm việc lấy dữ liệu từ các hệ thống bên ngoài để cung cấp thông tin cho PayrollSystem.

    Chức năng:

      - Truy xuất thông tin lương từ PayrollService.
      - Truy xuất thông tin dự án từ ProjectManagementDatabase.

  Hệ thống bên ngoài PayrollService và ProjectManagementDatabase:

    Vai trò:

      - PayrollService: Cung cấp thông tin lương cho hệ thống trả lương.
      - ProjectManagementDatabase: Cung cấp thông tin về các dự án và mã chi phí cho hệ thống trả lương.

  Thực thể Luong và DuAn:

      - Luong: Đại diện cho thông tin lương của nhân viên trong hệ thống trả lương.
      - DuAn: Đại diện cho thông tin dự án trong cơ sở dữ liệu quản lý dự án.
## 2.  Analysis class to design element map:

| **Analysis Class**                    | **Design Element**                                                                 |
|---------------------------------------|------------------------------------------------------------------------------------|
| **PrintService**                      | **PrintServiceController**                                                         |
| **IReportService**                    | **IReportService**                                                                 |
| **ReportGenerator**                   | **ReportGenerator**                                                                |
| **Luong**                             | **Luong**                                                                          |
| **DuAn**                              | **DuAn**                                                                           |
| **PayrollSystem**                     | **PayrollSystem**                                                                  |
| **ProjectManagementDatabase**         | **ProjectManagementDatabase**                                                      |
| **PrintServiceController**            | **PrintServiceController**                                                        |
| **DataFetcher**                       | **DataFetcher**                                                                    |
| **ReportService**                     | **ReportService**                                                                  |
| **PayrollService**                    | **PayrollService**                                                                 |
| **ProjectManagementDatabaseController**| **ProjectManagementDatabaseController**                                            |

## 3. Design element to owning package map

| **Design Element**                    | **Owning Package**                       |
|---------------------------------------|------------------------------------------|
| **PrintServiceController**            | **applications::Payroll**                |
| **IReportService**                    | **core::Reporting**                      |
| **ReportGenerator**                   | **core::Reporting**                      |
| **Luong**                             | **core::Entity**                         |
| **DuAn**                              | **core::Entity**                         |
| **PayrollSystem**                     | **applications::Payroll**                |
| **ProjectManagementDatabase**         | **core::Database**                       |
| **PrintServiceController**            | **applications::Payroll**                |
| **DataFetcher**                       | **middleware::Data**                     |
| **ReportService**                     | **applications::Payroll**                |
| **PayrollService**                    | **business::Payroll**                    |
| **ProjectManagementDatabaseController**| **applications::Payroll**                |

