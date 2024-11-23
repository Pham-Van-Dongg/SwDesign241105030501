# Phân tích ca sử dụng trong hệ thống Pay roll

## 1. Thiết kế ca sử dụng Login

### 1.1 Describe interaction among design objects

  Mục tiêu: Mô tả sự tương tác giữa các đối tượng thiết kế chính trong Use Case.

  Các đối tượng chính bao gồm:

  - User (Người dùng): Gửi thông tin đăng nhập.
  - Authentication System (Hệ thống xác thực): Xử lý logic xác thực.
  - Database (Cơ sở dữ liệu): Lưu trữ thông tin tài khoản và kiểm tra thông tin đăng nhập.

  Sơ đồ tuần tự (Sequence Diagram):

  ![Diagram](https://www.planttext.com/api/plantuml/png/T90nJWCn44Lxd-8hLI8HqM-1mceb2XeabWCuni9MOcTPpo8eKKw0k02hY88Y1HBLRf5YSn6VW2imZb0a2ZhF_F_V7_cxtyq2oPeQjnHIqQh6JT2rg7XbbQsa9upE6pBQyop9hZokdm9fDu8CICfVRo59pcNG1xd8XKWuJCyErWmNiTzQa1c-_1t8UknVzcj-UXExROMnTj8kJ-1u8Ynu-T5CH8ecH95dkBInNpjGBV-bY2B7zDXOrh7Ru27sprZ4RaUuRzBYSMWL4sB_gNxvd4YtPhXYoiQ3jLS-bUDjQZ53Qp4kpV3c3LHgFYtP-4wOiyDEn4pxM_x57m000F__0m00)

  Giải thích:

  - Người dùng gửi thông tin đăng nhập (email và mật khẩu) đến hệ thống xác thực.
  - Hệ thống xác thực gửi yêu cầu kiểm tra thông tin đến cơ sở dữ liệu.
  - Cơ sở dữ liệu trả về kết quả xác thực (hợp lệ hoặc không hợp lệ).
  - Hệ thống xác thực phản hồi người dùng với trạng thái đăng nhập (thành công hoặc thất bại).
  
  ### 1.2. Simplify sequence diagrams using subsystems

  Mục tiêu: Đơn giản hóa sơ đồ tuần tự bằng cách sử dụng các phân hệ (subsystems).

  Trong Use Case Login:

  - Nhóm các chức năng liên quan đến giao diện người dùng vào UI Subsystem.
  - Nhóm các chức năng xử lý xác thực vào Authentication Subsystem.
  - Nhóm các chức năng lưu trữ dữ liệu vào Database Subsystem.

  Sơ đồ tuần tự với phân hệ (Subsystems):

  ![Diagram](https://www.planttext.com/api/plantuml/png/T94nQWCn44LxdUBZtXVO8ZZBGc828U3i0UIro8favRKq6v8ok4mLV8B5jOj0gbNXOdqHdI1NoCYO49kuasRU_F-7-VRRaIDfgQcUX2neRf4xPKND9LteMXh281zZqapTgoDL3I0Tyl4nSDbGgGp_9UcvEO5ZynZF9CcfTEe4p58XeZc65-oGuBOCtQO6bVsNUG1fWzt7RibFisy8ZiLab4zm5Vn6dqSZ5E4iJN2ZWrzM82lFyrcAuQ_slGtT6i_1l-4nT5l2eec5bxujM27up-AWVyXznnfh0-wiE18Fjz6Zx5lzpm9nXdTES1rZcRtW-ryVCL9cnjVv0G00__y30000)

  Giải thích:

  - UI Subsystem: Nhận thông tin từ người dùng và hiển thị kết quả.
  - Authentication Subsystem: Xử lý logic xác thực.
  - Database Subsystem: Lưu trữ và kiểm tra thông tin tài khoản.

  ### 1.3. Describe persistence-related behavior

  Mục tiêu: Mô tả hành vi liên quan đến lưu trữ dữ liệu.

  Trong Use Case Login:

  - Hệ thống cần lưu trữ thông tin tài khoản người dùng (email và mật khẩu) trong cơ sở dữ liệu.
  - Khi người dùng đăng nhập, hệ thống xác thực cần truy vấn cơ sở dữ liệu để kiểm tra thông tin.

  Sơ đồ lớp liên quan đến lưu trữ:

  ![Diagram](https://www.planttext.com/api/plantuml/png/UhzxlqDnIM9HIMbk3bToJc9niK9eSMgHGZMN0X1afbWfPEQLWDcfkOcPELOAmIL5cNdfO942eEho_A8Kk60j5zG8byIInAJ4ubIeCSM9PQaQ86CrhHJAyZDJm89fcNaf6c13WQ8WIP1siDswkdO84wmKb7oERIXLACaul2KlNQ4aCq-XvF22J8NiZFo7knRdAN4vfEQb01qF0000__y30000)

  Giải thích:

  - Lớp User đại diện cho thông tin tài khoản người dùng, bao gồm id, email, và password.
  - Lớp Database cung cấp các phương thức để lưu trữ (save) và truy xuất (find) thông tin tài khoản.

  ### 1.4. Refine the flow of events description
  
  Mục tiêu: Làm rõ luồng sự kiện, bao gồm cả các trường hợp đặc biệt (luồng thay thế).

  Trong Use Case Login:

  - Luồng chính: Người dùng gửi thông tin đăng nhập, thông tin được xác thực và phản hồi trạng thái đăng nhập.
  - Luồng thay thế: Nếu thông tin không hợp lệ, hệ thống trả về thông báo lỗi.

  Sơ đồ tuần tự với luồng thay thế:

  ![Diagram](https://www.planttext.com/api/plantuml/png/b94nJWCn44Lxd-8hVIwm1GhHIXIKX0DC5YksikjTx5aaIfI25YfQejJfgDP5Ykn5V0AkW9qWI10fqbZZcV_dVMa-_MRac2otLIceuDhYraahcjZIXMx8C0QNBIjfufzOrmOtZuvbDG0vfCcnDYUcAJcv6-TZ8T8w32zsqWnNmQyrM6q_p0oi3VhNVX5BeqAtRaGI9N4-pd2jWrzKO4kdzLGo9hz35VogGHdyiq3SWU4FTs93jy93y4-OXsx3k6zJuyYmXqTBYfoXVpaWfGZlHg58B25B9m-vytrvDlu_tvyKtvJfTbadnPiMqjo9KNpYnRu0003__mC0)

  Giải thích:

  Sử dụng khối alt để mô tả hai luồng sự kiện:

  - Luồng chính: Thông tin hợp lệ, người dùng được đăng nhập.
  - Luồng thay thế: Thông tin không hợp lệ, người dùng nhận thông báo lỗi.

  ### 1.5. Unify classes and subsystems

  Mục tiêu: Hợp nhất các lớp và phân hệ để xây dựng một hệ thống hoàn chỉnh.

  Trong Use Case Login:

  - Hệ thống bao gồm các lớp và phân hệ được kết nối với nhau để xử lý toàn bộ Use Case.

  Sơ đồ lớp tích hợp:

  ![Diagram](https://www.planttext.com/api/plantuml/png/R591JiCm4Bpx5QkSWaG_q0Cg4XAgk17r0Pl492iSEuhNHHNggI_W8Rrn8WSEz2Dv0L_0BadQGlRadLtFpAxztNukB6F3hbAYnkmP2mdHQWc9I-t6igmYU1K0cK9hmUCX2L58NbdPB7NjEBwQGy8DwQ8lvcHhXPj7QPtYsFEpiqEBxrqRodtdLcp5IVFMSIarKuPCHa_hN_Oan_heI9c2T2mh93LeNKFjhxsO9ZzJJurH4lK_0tV8cAALqz9ZTP2pk9PnMC5fe11FfFDV4nuFvQCEm6c77Xj9o1iZpNrsuRt7_WumsFPFCPlTJ6za3j5zr-u9kFnwrmKmQJYy7NR-gClkOrz7Ol9U81pdz2GFrBMx2hZ1CwP8BAJE_NVv0G00__y30000)

  Giải thích:

  - UI Subsystem: Chịu trách nhiệm giao tiếp với người dùng (nhận thông tin và hiển thị kết quả).
  - Authentication Subsystem: Xử lý logic xác thực (kiểm tra thông tin đăng nhập).
  - Database Subsystem: Lưu trữ và quản lý thông tin người dùng.

## 2. Thiết kế ca sử dụng Maintain Timecard

  ### 2.1. Describe interaction among design objects

  Mục tiêu: Mô tả sự tương tác giữa các đối tượng thiết kế chính trong Use Case.

  Trong Use Case Maintain Timecard:

    Các đối tượng chính bao gồm:

    - (Nhân viên): Nhập, sửa đổi hoặc xóa thông tin chấm công.
    - Timecard System (Hệ thống quản lý chấm công): Xử lý logic liên quan đến chấm công (thêm, sửa, xóa).
    - Database (Cơ sở dữ liệu): Lưu trữ và quản lý thông tin chấm công.

  Sơ đồ tuần tự (Sequence Diagram):

![Diagram](https://www.planttext.com/api/plantuml/png/T92nJiCm54LtVyLLftQeicT0LHG40mCI-G7NjR15xORuHQ8p8oC_G8LOa2AGO8g73f7u3ty1lu0Jb8eEhFVTU-vxxzll5uvuHRLPCoveK-7KbElDLafMHbaBNN9Bc1JQIC6h5QwsZgIPW3kCsh4pvyINtCd1acSCR2HYVdB8f3WBlj4WrNtQQv2s42gqBmPY4APny6eI5qqykUi--8mTLeYOF4jnyVLUWwhWtn8HsgQ4ZO261lT_N9Pdc1-jSHcdpnOg-4VTqzfT7rFTJlyfZ8dnY1JdElXx6pt1F-0cj7l2RHqXc1QgUxBgjoaf-bh2CXBrZ2saNSKV_m000F__0m00)

  Giải thích:

  - Nhân viên gửi yêu cầu (thêm, sửa, hoặc xóa) thông tin chấm công đến hệ thống quản lý chấm công.
  - Hệ thống gửi yêu cầu đến cơ sở dữ liệu để lưu trữ, cập nhật hoặc xóa thông tin.
  - Cơ sở dữ liệu phản hồi trạng thái (thành công hoặc thất bại) cho hệ thống.
  - Hệ thống phản hồi kết quả cho nhân viên.
 
  ### 2.2. Simplify sequence diagrams using subsystems

  Mục tiêu: Đơn giản hóa sơ đồ tuần tự bằng cách sử dụng các phân hệ (subsystems).

  Trong Use Case Maintain Timecard:

  - Nhóm các chức năng liên quan đến giao diện người dùng vào UI Subsystem.
  - Nhóm các chức năng xử lý logic chấm công vào Timecard Management Subsystem.
  - Nhóm các chức năng lưu trữ dữ liệu vào Database Subsystem.

  Sơ đồ tuần tự với phân hệ (Subsystems):

  ![Diagram](https://www.planttext.com/api/plantuml/png/T96nIWD154Nx-Of7-f1-2mdBYWPK19CFU9aCsS7CPDrv2qbjQPal2C4oA6YrKwHOy3_c2_m5tuQiE4BQE-VU-oxpxGz3HrXIPHO29IrBk3J5OhbMIXGiQwaBj0IzoGWUggbRErAc1-XWCeg1iJPAOZc3MxGuLqQn63iw8lPbI3X5f_x1MIf4TmdqBxWkWRiyrFi2A6y-xHn8Mv2il1gGhI3uH0QxbWIkWj_hi_JllUp9qWHkljuhe3Buju4yrjYsZGQhvWFFXcGfzAFEUtxTMSY3t-WshTwsjhpPwZ-5fpaH-nZg0y5JnT9n23FT_0IkTV3FbdE2Vud8eR8p_haV0000__y30000)

  Giải thích:

  - UI Subsystem: Nhận thông tin từ nhân viên và hiển thị kết quả.
  - Timecard Management Subsystem: Xử lý logic liên quan đến chấm công.
  - Database Subsystem: Lưu trữ và quản lý thông tin chấm công.

  ### 2.3. Describe persistence-related behavior

  Mục tiêu: Mô tả hành vi liên quan đến lưu trữ dữ liệu.

  Trong Use Case Maintain Timecard:

  - Hệ thống cần lưu trữ thông tin chấm công (ngày làm việc, số giờ làm việc, mã dự án, v.v.) trong cơ sở dữ liệu.
  - Khi nhân viên sửa hoặc xóa thông tin, hệ thống cần cập nhật hoặc xóa dữ liệu trong cơ sở dữ liệu.

  Sơ đồ lớp liên quan đến lưu trữ:

  ![Diagram](https://www.planttext.com/api/plantuml/png/R53DQW8n4BxdAGPF2le2YuZqvo1ugz3pD1bhscoo9BDI4H-fA7WewC63qFVO9-WhTDoksa9pc6JoVPFl-_ArFmmJO-GoTqexJ0acDYUDqS1IWInhCh2UwpFbXGiBej6lEuDC6Tn9hTjPA6Dw3F6LX3Dr0NzOHGmlfFas624_SBJ-MQrKeoZ3-8I96iM4SsgVNNGoc0ThQg0iJcB_GeOS2SGDDFe3JgqtDulxndpxca98OvkuVtvnSF9qoT_h3QxMCcYDFpSbSApswoxeQlTUW9_9nbq9NUq-DBmTjzXIG_96VlCR003__mC0)

  Giải thích:

  - Lớp Timecard đại diện cho thông tin chấm công, bao gồm id, employeeId, date, hoursWorked, và projectCode.
  - Lớp Database cung cấp các phương thức để lưu trữ (save), cập nhật (update), xóa (delete), và truy vấn (findByEmployee) thông tin chấm công.

  ### 2.4. Refine the flow of events description

  Mục tiêu: Làm rõ luồng sự kiện, bao gồm cả các trường hợp đặc biệt (luồng thay thế).

  Trong Use Case Maintain Timecard:

  - Luồng chính (thêm): Nhân viên nhập thông tin chấm công, thông tin được lưu vào cơ sở dữ liệu.
  - Luồng thay thế (sửa): Nhân viên chỉnh sửa thông tin chấm công, hệ thống cập nhật thông tin trong cơ sở dữ liệu.
  - Luồng thay thế (xóa): Nhân viên xóa thông tin chấm công, hệ thống xóa thông tin khỏi cơ sở dữ liệu.

  Sơ đồ tuần tự với luồng thay thế:

  ![Diagram](https://www.planttext.com/api/plantuml/png/h9AnIWD154Nx-OfBAYr2-Yqah2jQM0X9OVlS3ExWpcJDp8AfBQr4h6m4iH4M1ArsYXGH_sE-m5_8syMD16ANzhvxptsFcH-_65f7CrVgN53gfZCSwIAVpgKK1SigLGKPXzvOQPdIR8BHt3gfUo2BJjjq9kJeWgniBKaiH0T4_s0TYN0SVANWikMdkOHJ1caMwbUDj1NsUF2c1vPDDBXPVj2-eDnXtAZGmJyfWJMi0ITnXDFlz_8_8jkJ6FsD5Svu_cAG1V_GRl9iib-ppAt4g2d7rttmZzlQ3aDT5J3CgDmEMy_vs2rjZRoZ5ZCHVtGETUyJuKG5VslO7lmThaAzSBWkcIE67E8ViW800F__0m00)

  Giải thích:

  - Sử dụng khối alt để mô tả ba luồng sự kiện chính: thêm, sửa, và xóa.

  ### 2.5. Unify classes and subsystems

  Mục tiêu: Hợp nhất các lớp và phân hệ để xây dựng một hệ thống hoàn chỉnh.

  Trong Use Case Maintain Timecard:

  - Hệ thống bao gồm các lớp và phân hệ được kết nối với nhau để xử lý toàn bộ Use Case.

  Sơ đồ lớp tích hợp:

  ![Diagram](https://www.planttext.com/api/plantuml/png/b5DBQiCm4Dtx58DNBgGNC2M4VYY1TDCqTAr84qUDBHbh76fAZjDbQA65GhBe8j1x-0IzGcN7TfmqNTGhQTvxe_T6ylVwisU89PH6eHCpFcC1WZlgmp0TcymGHYuyEG0yPCQ0hHURuWkGHWQJlefJyavy658YLL21GfeuPDajcZGap_QdrDGKovrhAInpuIoStPbtCaBE4W4tJDb2X8gEcwY9mn9f334XQiIZQk4tP7lgMEiGcQheQImOuNyK0aCyekXRZLIqHzzFTic8ZPd1ut4Qj0vYs1ozbejgMZlJVu1RVorV-_14Ad6UNKLng3D43wj5IHj8GsTrrsuP0E3Nm1k7SXkvskqwjQk5KRy8XrLXgjF4tEjaXfOt2JMhcN6Y7v3JXHROUaRb2ErxEptj7jwu3-vrlbvAeEdcNGL0KW6Vvgld27XHS9q3GT6Z6RDL3xvUKw0aNxzqWEUhPGpAofVKiIRprGU7nyqRSvqUAc5_Yny0003__mC0)

  Giải thích:

  - UI Subsystem: Chịu trách nhiệm giao tiếp với nhân viên (nhận thông tin và hiển thị kết quả).
  - Timecard Management Subsystem: Xử lý logic liên quan đến chấm công (thêm, sửa, xóa).
  - Database Subsystem: Lưu trữ và quản lý thông tin chấm công.

## 3. Thiết kế ca sử dụng Run payroll

  ### 3.1. Describe Interaction Among Design Objects
  
  Mục tiêu:
  
  - Mô tả cách các đối tượng trong hệ thống tương tác với nhau để thực hiện quy trình chạy bảng lương.

  Các đối tượng thiết kế:

  - SystemClock: Kiểm tra thời gian hiện tại để xác định ngày trả lương.
  - PayrollController: Điều phối toàn bộ quy trình tính toán và thanh toán lương.
  - Employee: Đại diện cho nhân viên, cung cấp thông tin cần thiết để tính lương.
  - Timecard: Lưu trữ thông tin chấm công của nhân viên (đối với nhân viên tính lương theo giờ).
  - PurchaseOrder: Lưu trữ thông tin hóa đơn bán hàng (đối với nhân viên hoa hồng).
  - Paycheck: Đối tượng lưu thông tin về phiếu lương được tạo ra.
  - PrinterInterface: In phiếu lương (cho nhân viên nhận lương qua thư hoặc trực tiếp).
  - BankSystem: Xử lý giao dịch ngân hàng cho nhân viên nhận lương qua chuyển khoản.

  Tương tác chính:

  - SystemClock kiểm tra xem hôm nay có phải là ngày trả lương không.
  - PayrollController khởi chạy quy trình tính toán lương.
  - Employee cung cấp thông tin lương (chấm công, hóa đơn bán hàng, phương thức thanh toán).
  - PayrollController tính toán lương và tạo đối tượng Paycheck.

  Tùy theo phương thức thanh toán:

  - Nếu nhận lương qua thư hoặc trực tiếp: PrinterInterface in phiếu lương.
  - Nếu nhận lương qua ngân hàng: BankSystem xử lý giao dịch.
  
  ### 3.2. Simplify Sequence Diagrams Using Subsystems

  Phân chia subsystem:
  
  + Control Subsystem:
    - PayrollController: Điều phối toàn bộ quy trình.
  + Entity Subsystem:
  
    - Employee, Timecard, PurchaseOrder, Paycheck: Lưu trữ dữ liệu liên quan đến nhân viên và phiếu lương.
  
  + External Subsystem:

    - SystemClock, PrinterInterface, BankSystem: Tương tác với hệ thống bên ngoài.

  Sơ đồ tuần tự với subsystem:

  ![Diagram](https://www.planttext.com/api/plantuml/png/b5B1IiD04BtdAuRU_O4Uf515nDABudsRXkp2TZOc6p5dZtw22AtYHIbK4CJieOU5_CT-WR_WR3MnZK5mO7UMcVVcpGpxOTQ3JBDKvpCPi52h5CPnjNBcJXpOTuo3X78Y50b33RsXGfqg2QVv92io7Srwm3BuZieetKKVeXQwQ86_WYtWbOvIPEswTJW8Tbg2lVqjoJuCkIiN1KnS-K19MQsg1VNzW_3ukbGVJeGprpFGAGECxRoW5n4R6fCQHdRUcGCogLG2vyxS2j3EF9CWSdkFS2di4suGtbhYcv7xC7Bb8zNazfLeMk0_g6TsYNod4M--sJ5DlyGw1HSv8uLg1LovyYtq4vWNSiALwwGXTWWr2pf6IBY7vx_q8fb5NOAqB9g3s_aMzY-98sUM0cB154oTkGbvPuK8fq7j_HdGHR_q4m00__y30000)

  ### 3.3. Describe persistence-related behavior

  Các lớp lưu trữ:

  + Employee:

    - Lưu trữ thông tin nhân viên (tên, mã nhân viên, phương thức thanh toán).

  + Timecard:

    - Lưu thông tin chấm công của nhân viên (giờ làm việc, ngày làm việc).

  + PurchaseOrder:

    - Lưu thông tin hóa đơn bán hàng (đối với nhân viên hoa hồng).

  + Paycheck:

    - Lưu thông tin phiếu lương (số tiền, phương thức thanh toán, ngày trả lương).

  + Hành vi lưu trữ:

    - PayrollController truy vấn thông tin từ Employee, Timecard, và PurchaseOrder để tính lương.
    - Sau khi tính toán, PayrollController tạo một đối tượng Paycheck để lưu thông tin lương.
    - Paycheck được sử dụng để in phiếu lương hoặc gửi thông tin cho ngân hàng.

  Sơ đồ lớp liên quan đến lưu trữ:

  ![Diagram](https://www.planttext.com/api/plantuml/png/X94v3i8m44Lxdy8Nu08fK8eWA2A1X4K_ieVO8l54Nee8SJ8AZiGLI21obWQNVyPVxzdlvolt0Lo8JSra3TxpNTFMr27oE-FVOrJ6py4PMur1GBjAMXt9La97AJHOBGYcZGSRYuLfK89JgTXMq9NGN0pAZ1SGSCmzxGtrWumR6wRxf-Ya1ez7fz2b4ay7WeBMH8e63XqpVgq9vYtGIOtoDYiGPX3wxKrama4vM2tG_eYcjzjijibtcIuiLgCHZULeLVyX7m000F__0m00)

  ### 3.4. Refine the flow of events description

  Luồng chính:

  - SystemClock kiểm tra ngày trả lương.  
  - PayrollController khởi chạy quy trình chạy lương.

  Với mỗi nhân viên:
  
  - Lấy thông tin chấm công (Timecard) hoặc hóa đơn bán hàng (PurchaseOrder).
  - Tính toán lương và tạo đối tượng Paycheck.

  Tùy theo phương thức thanh toán:

  - In phiếu lương (PrinterInterface) nếu nhận lương qua thư hoặc trực tiếp.
  - Gửi giao dịch ngân hàng (BankSystem) nếu nhận lương qua chuyển khoản.

  Luồng thay thế:

  - Không phải ngày trả lương: Hệ thống không thực hiện bất kỳ hành động nào.
  - Lỗi khi truy vấn thông tin nhân viên: Hệ thống ghi nhận lỗi và bỏ qua nhân viên đó.
  - Lỗi khi in phiếu lương hoặc gửi giao dịch ngân hàng: Hệ thống ghi nhận lỗi và thông báo cho quản trị viên.

  Sơ đồ tuần tự chi tiết:

  ![Diagram](https://www.planttext.com/api/plantuml/png/f5EnJiCm4Dtp5ITsn9u1LHI4gg8A2SHkZAcjEdP8NQJC30nCp0Yf1R60AXM1X8W7Xg3-Xx-0N-2SDAM1TiA3xVEzk-TxPt_PZqRVaCGC8XaGQdG2dUvqukojsCxVLJU8qIUeY8aoi7QGzWsBcbBJtXgGFXIxEcIVf8cMigcLyIjBIk3ShADtebZgbB42L1b_4bBEPeILyGkI26LOqlBJAQ5bjjbX7Rb5LAyiei1uCmXg1SFwvi9jGsXoburIE7RPFJhbT38TeIe_Y0BlPGYXBPozYC0a15Gt7wQumwXv3946zlBXKX_Wa5h7SEJiZG3Zx1EoAPxVAJWN-QCg47xKcIl9GjXpsGDcvVah1XgX_XTCiUg72AW_sE3v2u7FQxpeYaHLLq8uHB4qn5oux6DGgyuFhq07CuzLvOAp0K7UwGIuTjaRzRBOPrnyWdWUk8Iox6u8BRMIZia-MyQ73K1bU3vSmFvby6yZX5rdnmAwWcWuSVQAygNHJ9q4rLgmjaifOoI_5oixlaY8ZBLt65Ov32yKmHhjfGeyGmCd_AxV0000__y30000)

  ### 3.5. Unify classes and subsystems

  Sơ đồ lớp tích hợp:

  ![Diagram](https://www.planttext.com/api/plantuml/png/X9DBQiCm48RtFeNeAbda0bwKq2IaXT06OhgVo1DBMDOOFQ2cv6HTz4YzGkMy_8fRBRIOaR_vzUltpzVtt3empXSgAe7da25xM91sXXJR-RsjhCFYWNr6B2okm5gsXIfqrUMKGdFfdXSNK3s1pZQUT3QPdZh7w1Wr-9LsqbLZz5LHAgeGEr2PncpdZDHPg-XGtwcMeXwS2CyJ0Lea1DrJGKapB945SZ1fPvZEeDf0yIwHnsm93bizIsj9eHapgTsGj_KctD_YcqbxjbXw9bZIFSKfrJg5Zzb14ToZGiK5yhm7J6HjGFDDepunSB9_8Fz_SpeFzU7GQ1WDmkvKMoZgISib5a72Qql9P1gpFP52q7Vk5-Q7II_rTW3UUtgz5HBzcL9Ud8Xldao7k92-_2oj0ygyN4kWfUJY3quW3VCzcptUSXdT0bfNhm7gLZin6E5T1u-qMzwE0NgkZHnht8ZcgDFme_y2003__mC0)

## 4. THiết kế ca sử dụng Backsystem Subsystem

  ### 4.1. Describe Interaction Among Design Objects

  Mục tiêu: Mô tả sự tương tác giữa các đối tượng thiết kế chính trong Use Case.

  Trong Use Case này, các đối tượng chính bao gồm:

  - User (Người dùng): Người gửi yêu cầu giao dịch.
  - BankSystem Subsystem: Xử lý logic giao dịch ngân hàng.
  - Account Database (Cơ sở dữ liệu tài khoản): Lưu trữ và kiểm tra thông tin tài khoản.
  - Transaction Logs (Nhật ký giao dịch): Lưu trữ thông tin giao dịch.

  Sequence Diagram (Sơ đồ tuần tự):
  ![Diagram](https://www.planttext.com/api/plantuml/png/Z9AnJiCm48PtFyMf4vNe2tH09Oh4068XFC35jM8hYLF5bw4ZOc1Wv0MAAeI4r8qf5cB8a_W9U0Nij4LDXH0UhBlJT__zP_dBViuCOKrDMJ3aLDLmQqJD5hwak5gW9XX5gFERfI5HZW0DX7G8d7DUDJw8aJ158teiZePGKgCsVeIgD5nLcUcX430MHiBah5UUmeMp6mNBxgq1xjhN1hA-GChPEmqdk1rstPIfg4y1ov2DMUWD6d4qXKkFtfT0DG9rAmMvh5oxFkuTCom8aaD0EhjUGE7i0mD_uWWcFxOIsRthpDlGGz6ZdhsFi9dVHIhGqhKRWhpxW4nX1NDd7xayW3qTNc2_-MvHajrAI-1XAXE54KEh-TREduv_uSdP9w_jscVr3mUkVI58UrZeEPlvot-KRm000F__0m00)

  Giải thích:

  - Người dùng gửi yêu cầu gửi tiền đến BankSystem Subsystem.
  - BankSystem kiểm tra tính hợp lệ của tài khoản qua Account Database.
  - Nếu tài khoản hợp lệ, giao dịch được ghi vào Transaction Logs và phản hồi lại người dùng. Nếu không hợp lệ, hệ thống trả về thông báo lỗi.

  ### 4.2. Simplify Sequence Diagrams Using Subsystems
  
  Mục tiêu: Đơn giản hóa sơ đồ tuần tự bằng cách nhóm các thành phần liên quan thành các phân hệ (Subsystems).

  Trong Use Case này:
  
  - Nhóm các chức năng giao diện người dùng vào UI Subsystem.
  - Nhóm các chức năng xử lý giao dịch vào BankSystem Subsystem.
  - Nhóm các chức năng lưu trữ vào Database Subsystem.

  Sequence Diagram với Subsystems:

  ![Diagram](https://www.planttext.com/api/plantuml/png/X98nQiCm58PtdU8dUoxWeGHZI4EXI-83o8w9X6tPjP-7ZAL3XuozG4eeXKAsJXObWq-Y4_GAbToInA6q6ZJyx-Fz_tlIfpvCQk8LDNd6U4n5XR1EAbPQISQov8em2cUODr6zhYd9H-0rmjaGyBbAvttv0dI58HfmuX6lamimy1bpnXXVsUuUReLfzoL8TEzg1P8AAyaBB8tUn8BPG9PppJrCZTvBhBkt1h5fNnkiUe6aqVUAESQnWU_XnaeFEQZYe6uhaOh2j3l5U4POd0aGHkzAP4O_CjWJ-1WVxHQdH1VOkTLKI2Wt0Y7jFWRPJ-ZFgDDJqSsxLGAnys19PjSq29P-c_-PxnUUZ7vIzcwVvN_sfdqXH3sPg6M_QCVPb_5mxVQd7AGtI4rx8DmrreTDB6h_pnS0003__mC0)


  Giải thích:

  - UI Subsystem: Nhận thông tin giao dịch từ người dùng và hiển thị kết quả.
  - BankSystem Subsystem: Xử lý logic giao dịch.
  - Database Subsystem: Lưu trữ và kiểm tra thông tin tài khoản, ghi nhật ký giao dịch.

  ### 4.3. Describe Persistence-Related Behavior

  Mục tiêu: Mô tả hành vi liên quan đến lưu trữ dữ liệu.

  Trong Use Case này:

  - Account Database lưu thông tin tài khoản (số tài khoản, số dư).
  - Transaction Logs lưu trữ thông tin giao dịch (ID giao dịch, số tài khoản, số tiền, trạng thái).

  Class Diagram liên quan đến lưu trữ:
  ![Diagram](https://www.planttext.com/api/plantuml/png/Z98nJiGm44LxdsAKAXHx0HTeGTiWhMZW0XFREDOczYeURuCu0PT0eaPGK6s4A29nZvo0As1OPpS4X73d-L_ptupzthxEFM53eQwOgD1xE1721KjmpU3huEv-7kf2DHmkg35M9wt02grG7AGBHQLILIiwtGdvqKGAQuca1XNhpyw39NetpaXsmnB9POFMeo3ZxDBfFH0TocSB3iRIFqY_HwLYd9o2dpZ9r2eAzPh38hAcQkNq22V_mHgjMA1NUyehOsLQPVuhM6oHz846DsgS4IFvP0UZsE6PPhFZGpY7RFds5EAA-lOHgEoUhOu3MQ3kpi2gTFtstcPiijW_MjYotpuGhBeNq0OToBwz5MN6vihA-6K-0000__y30000)

  Giải thích:

  - Account: Lưu thông tin tài khoản và số dư.
  - TransactionLog: Lưu thông tin giao dịch, bao gồm trạng thái và thời gian.
  - Database: Chịu trách nhiệm lưu trữ và truy xuất thông tin tài khoản và giao dịch.

  ### 4.4. Refine the Flow of Events Description

  Mục tiêu: Làm rõ luồng sự kiện, bao gồm cả các trường hợp đặc biệt (luồng thay thế).

  Trong Use Case này:

  - Luồng chính: Người dùng gửi yêu cầu gửi tiền, tài khoản hợp lệ, giao dịch thành công.
  - Luồng thay thế: Tài khoản không hợp lệ, giao dịch thất bại.

  Sequence Diagram với luồng thay thế:
  ![Diagram](https://www.planttext.com/api/plantuml/png/Z9AnJiCm48PtFyMf4vNe2tH09Oh4068XFC35jM8hYLF5bw4ZOc1Wv0MAAeI4r8qf5cB8a_W9U0Nij4LDXH0UhBlJT__zP_dBViuCOKrDMJ3aLDLmQqJD5hwak5gW9XX5gFERfI5HZW0DX7G8d7DUDJw8aJ158teiZePGKgCsVeIgD5nLcUcX430MHiBah5UUmeMp6mNBxgq1xjhN1hA-GChPEmqdk1rstPIfg4y1ov2DMUWD6d4qXKkFtfT0DG9rAmMvh5oxFkuTCom8aaD0EhjUGE7i0mD_uWWcFxOIsRthpDlGGz6ZdhsFi9dVHIhGqhKRWhpxW4nX1NDd7xayW3qTNc2_-MvHajrAI-1XAXE54KEh-TREduv_uSdP9w_jscVr3mUkVI58UrZeEPlvot-KRm000F__0m00)

  Giải thích:

  - Sử dụng khối alt để mô tả hai luồng sự kiện:
  - Luồng chính: Tài khoản hợp lệ, giao dịch thành công.
  - Luồng thay thế: Tài khoản không hợp lệ, giao dịch thất bại.

  ### 4.5. Unify Classes and Subsystems

  Mục tiêu: Hợp nhất các lớp và phân hệ để tạo thành một hệ thống hoàn chỉnh.

  Trong Use Case này:

  - Hệ thống bao gồm các lớp và phân hệ được kết nối với nhau để xử lý toàn bộ Use Case.

  Unified Class Diagram với Subsystems:

  ![Diagram](https://www.planttext.com/api/plantuml/png/b5HDIiD06Dtd51zPLT0BP26r5AGeBcnxW2_9c0n9PaBccsAHBiIbbn141A4xLotYeYV92Ro2axPf9_qHd4KWyzxBUzyF-Pb_jnLXGJfBdHo312C6xh07VUshiIAMkV3WW3b1Yag1GLQlgnCn6YfMz4IkgNNYGPyABYAB47ALfpY-PKgdr39Ef5LDC_oHvE6IFN4cpjQ_WoBfBzsFvR0OTfwGvL9nQc4GI2teHcS-Asg_Ky2iklKWbDfFMJDlCq4N2NrKx9Z_nSgWONxGrC9zJ544hBPljh6p0gicxi4w3v5OpTWhmcfYzRHI3WeK2WFYKbpBg16Mjb2lwm4Nz8zAcX4ie3bWsuvdp81Pxe5fhIr9PMJ5RFrPpsOgTYLtN8JhSHoUk_da6hUJueZPlYQ6jzEllVqqotzsTcxldWVkPJcVSXWlFZG4vUnTGxIy85xE7uNhMEHAkwd0AAyCvIch9W6qUE6GnBASlHhDXbGfwaqpWa6Xnt2lozaR0SMBJn4P6x4ZtZ7SMO4gSCn1nELiIf0ilY3YA24ivyz1x3fj9aBp9_W5003__mC0)

  Giải thích:

  - UI Subsystem: Nhận thông tin từ người dùng và hiển thị kết quả.
  - BankSystem Subsystem: Xử lý logic giao dịch.
  - Database Subsystem: Lưu trữ thông tin tài khoản và giao dịch.

## 5. Thiết kế ca sử dụng PrintService Subsystem

  ### 5.1. Describe Interaction Among Design Objects

  Mục tiêu: Phân tích và mô tả các đối tượng chính trong subsystem, cách chúng tương tác để thực hiện Use Case.

  Trong PrintService Subsystem, các đối tượng chính bao gồm:

  - PayrollController: Điều phối quy trình in bảng lương.
  - IPrintService: Giao diện định nghĩa chức năng in bảng lương.
  - PrintService: Proxy thực hiện logic in bảng lương.
  - Paycheck: Thực thể chứa thông tin bảng lương cần in.
  - Printer: Máy in thực hiện in bảng lương (được chỉ định qua tham số onPrinter).

  Sequence Diagram mô tả sự tương tác:

![Diagram](https://www.planttext.com/api/plantuml/png/V58zIiH05Exd58-jLd2nJo4B5hBO18o5vJYEcM6pBt4o4QmjhAoyW45440GBgwJO8h3tc1Du1USjmsuIn6h-lh_tCJ_jUbvQRcoroXWNDZTmKKh32d-bXIuuMfZ4_DxaMNQIewLLcWdm4lR78NeH6utsN9exBUGMkK0hpGqNSYGxneNz7oXloHW5WzbnppY2o-wZ0k6QzmeqmfLhNZ65RFErgJ5bUo3HTYaYA4XpolrSGacnF8GSWyq1sy684n95SEhQ9mtMQDS-82mLr_-A11v9XBkjnAU6pBMFg7nO5XvWrlT9Z6jyTB2ggpMDD4rKz-89ell6z2XHhdcpD6UjUowZKc95FO1oxJDb7YeEMl54QZM2CzUiBTnMdaYOkSHh_oD-0G00__y30000)

  Giải thích:

  - Người dùng gửi yêu cầu in bảng lương đến PayrollController.
  - PayrollController gọi phương thức print() từ IPrintService.
  - IPrintService được triển khai bởi PrintService, nơi xử lý logic in và gửi lệnh in đến máy in.

  ### 5.2. Simplify Sequence Diagrams Using Subsystems

  Mục tiêu: Gom nhóm các thành phần liên quan thành các subsystem để đơn giản hóa thiết kế.

  Trong PrintService Subsystem:

  - Gom nhóm các chức năng điều khiển vào Control Subsystem (PayrollController).
  - Gom nhóm các chức năng in vào PrintService Subsystem (IPrintService và PrintService).
  - Gom nhóm các thực thể dữ liệu vào Entity Subsystem (Paycheck).

  Sequence Diagram với Subsystems:

  ![Diagram](https://www.planttext.com/api/plantuml/png/R94nQiCm58PtdUBXAOM6x1vAe4E7BeOuGqT55PQe8hlIKo4dw05wWPfI2eL2XqxoaC6GU-W4lK8bS8dZTjJJ-zxtF-cxsoyjKeDkgmXbM1jOMsv84qkIoOPgXEoorcXg1IktiJkBV9i1jJ1KrRIxC5BZYfi7oVW46L_z0t6J4PBqCByOZS_Xfdztm89_So0rR89_qHMem-UXrHKvDYPihCYXIQSPBUYE2Sxkpg7MW-cCdEJy9PFjAdGV4bJe7hM8FZ9SmFpF-D847oC0YhwLATgi5Frpf5Z_fQj5AO9_nPItbLFVPCD2fAL0XEv90ax6dgmOmVH4ELm7lqUuTn5CQhBa-ZR-uWy0003__mC0)

  Giải thích:

  - Control Subsystem: Điều phối quy trình in bảng lương.
  - PrintService Subsystem: Xử lý logic in bảng lương, bao gồm việc làm việc với thực thể Paycheck.
  - Printer: Thực hiện in bảng lương.
    
  ### 5.3. Describe Persistence-Related Behavior

  Mục tiêu: Xác định các lớp liên quan đến lưu trữ dữ liệu và cách chúng được sử dụng trong quy trình.
  
  - Trong PrintService Subsystem, lớp liên quan đến lưu trữ là Paycheck:
  - Chứa thông tin bảng lương cần in (tên nhân viên, số tiền, ngày tháng, v.v.).
  - Được truyền từ PayrollController đến PrintService.

  Class Diagram liên quan đến lưu trữ:
  
  ![Diagram](https://www.planttext.com/api/plantuml/png/h95D2i8m48NtEKMMBLWF44GAkd4ZXPuWfgC6yrFIf53KaxdmI5x1f3JLuDOi4cRUp9jloElnB3jBZNLI82Per-6A3kmCx8Al28y7P2lq0B2d4WYkhU7gD4bKQgSimOrs1m5Jig7MrstzZUxeOsgq41kjR7Z1pEx6gKdCyb3FbGLpf0pmhlAJR0scvpwAzMr8PZHIafbtWRKQEy14ofpWNlFc2-EFZhyh5SKwXKRf2glRSfaWe4GExN4qAa4r_a_U0000__y30000)


Giải thích:

- Paycheck là thực thể chính được sử dụng trong quá trình in.
- PayrollController truyền đối tượng Paycheck đến PrintService thông qua giao diện IPrintService

  ### 5.4. Refine the Flow of Events Description

  Mục tiêu: Làm rõ luồng sự kiện chính và các trường hợp thay thế (nếu có lỗi xảy ra).

  Luồng chính:

  - Người dùng yêu cầu in bảng lương.
  - PayrollController gọi IPrintService để thực hiện in.
  - PrintService xử lý logic in và gửi lệnh đến máy in.
  - Máy in thực hiện in và trả về trạng thái (thành công/thất bại).
  - PayrollController nhận phản hồi và thông báo kết quả cho người dùng.
  
  Luồng thay thế:

  + Trường hợp lỗi:
    
    - Trường hợp 1: Máy in không phản hồi → Hệ thống thông báo lỗi in.
    - Trường hợp 2: Dữ liệu bảng lương không hợp lệ → Hệ thống từ chối in.

  Sequence Diagram với luồng thay thế:
  ![Diagram](https://www.planttext.com/api/plantuml/png/b5E_IWCn6D_p51-T5EmBt2051Iak1UlWcCROXCRScSi9pWvEJWwk7aK4GNHmkXiw7FGzyWHz1VDTGtiUHz4ibtpy_drVSgjoCKWjDJQxLeGo6niuJxaXYIz99XEgBVH6zCx4IXt5skANcnxG5BR7t-ZXo4XjpxYvbOpNoA6st5nHnbkoRLpOTw2y9I4O3Fg73UC8Bght39WhtZAG6YQkcEifgENNCjTJiWKYRPCYWWGrzwZlYmdEPWSGws2pJwYoSEpAJr3IbGyP25VE4r1-Jy2lZGfAXi0HdBZoKO8rddAlOIQetEc1Ge6BCg5Uotp8saiBtq-Dmpn33LPKBxx8gc_V68GLYD1lPXaRL_ZkaP7BRjx6kpNDaS01OijF7KokKhwEuefNYyFEvV-YTF3-6AN5vFgIr76QDpKJ67N7XRKinclyfCfZX3zBWhBDH-C9-EWYE7N5mi9DvZFXlGmyqFymFm000F__0m00)


  ### 5.5. Unify Classes and Subsystems

  Mục tiêu: Hợp nhất các lớp và subsystems để tạo thành một hệ thống hoàn chỉnh.

  Unified Class Diagram:
  ![Diagram](https://www.planttext.com/api/plantuml/png/h59BQWCn3Dtx52Ah19eSO0Wbq7QHJGdC2HIFcWxnPx3bmD3aP5tqIBr2bUaCiGbqLIsCy7lIavxz_VcrYOo1apMgGtt40y7ioJiEta2Tzh6FJ7O67meajC4OOOUze6Pa6GeZ-XiXkP4mNmpN5tLHjzwxq3gkAPnQJVS2Wb5uGu6s1J4NwAx074L4lvC-LZ1b3-3TK4MXWfebEomgEFcs6UV8LlZ_vlcIBuvRxl_mRsXP29FjZE-9Nj7I9931Q7roN47ZqzvG1ZJ8md-MypR7_GCjbu-bewhqTtrUhGfJL05VowUfrOPS8z_b1m00__y30000)


  Giải thích:

  - Control Subsystem: Chứa PayrollController để điều phối quy trình.
  - PrintService Subsystem: Chứa IPrintService và PrintService để xử lý logic in.
  - Entity Subsystem: Chứa Paycheck để lưu trữ thông tin bảng lương.
    
## 6. Thiết kế ca sử dụng ProjectManagementDatabase Subsystem

  ### 6.1. Describe Interaction Among Design Objects
  
  Mục tiêu:
  
  - Xác định các đối tượng chính trong hệ thống và mô tả cách chúng tương tác để thực hiện Use Case.

  Các đối tượng thiết kế:

  - TimecardController: Điều phối yêu cầu từ người dùng.
  - Giao diện ProjectManagementDatabase: Định nghĩa phương thức layDanhSachMaChiPhi(tieuChi: String) để lấy danh sách mã chi phí.
  - ProjectManagementDatabaseProxy: Thực hiện logic truy vấn cơ sở dữ liệu và trả về danh sách mã chi phí.
  - DanhSachMaChiPhi: Lớp lưu trữ danh sách mã chi phí được trả về.

  Tương tác giữa các đối tượng:

  - Người dùng yêu cầu danh sách mã chi phí từ TimecardController.
  - TimecardController gọi phương thức layDanhSachMaChiPhi(tieuChi) từ giao diện ProjectManagementDatabase.
  - Giao diện chuyển yêu cầu đến lớp proxy ProjectManagementDatabaseProxy.
  - Proxy xử lý yêu cầu, truy vấn cơ sở dữ liệu, và trả về danh sách mã chi phí (DanhSachMaChiPhi).
  - TimecardController nhận danh sách và hiển thị cho người dùng.
    
  ### 6.2. Simplify Sequence Diagrams Using Subsystems
  
  Mục tiêu:

  - Nhóm các đối tượng liên quan thành các subsystem để đơn giản hóa sơ đồ tuần tự.

  Phân chia Subsystem:

  - Control Subsystem: Chứa TimecardController, chịu trách nhiệm tiếp nhận và điều phối yêu cầu từ người dùng.
  - ProjectManagementDatabase Subsystem: Chứa giao diện ProjectManagementDatabase và lớp proxy ProjectManagementDatabaseProxy, xử lý logic liên quan đến cơ sở dữ liệu.
  - Entity Subsystem: Chứa DanhSachMaChiPhi, lưu trữ danh sách mã chi phí.

  Sơ đồ tuần tự với các Subsystem:

  ![Diagram](https://www.planttext.com/api/plantuml/png/V9BDIWCn58NtUOfBLxhe2yn22Xt1JQNGRbpUfc4IcSaCoKrXbkBIPn2K8e8Wk7LcuIBWU-G9V0KZ_PqHkajEpfTxJiXF-pMoX8PSaJFaL1guphu_GlkeKl-fCrR5CyLLXPfWC2urcJA7cLlOsf8e1e0MjcekJDSzDUMju3H1ZPaeXAOK2HTeHO_VoLtwKfEYkcVTY8nrCiBmuYX30ZV-pG4FpQk39Me9rZzp2OLV0vSAAkdVsS7-1-y2991ZdKPaXbnES2pLLAepKiB5vJdRnu_89aW2S-DgM8NcHSFAFm6PqApZlhs3_ZriMsZO6JW_0HpczGgUWewRHQppK0bSgT3UQo0PseV_x4ZePVm7lm000F__0m00)

  ### 6.3. Describe Persistence-Related Behavior

  Mục tiêu:

  - Mô tả cách dữ liệu được lưu trữ và sử dụng trong hệ thống.

  Các lớp liên quan đến lưu trữ:

  + DanhSachMaChiPhi:
  
    - Lưu trữ danh sách mã chi phí được truy vấn từ cơ sở dữ liệu.
    - Được sử dụng bởi ProjectManagementDatabaseProxy để trả kết quả cho TimecardController.

  + Hành vi lưu trữ:

    - Khi ProjectManagementDatabaseProxy nhận yêu cầu từ TimecardController, nó truy vấn cơ sở dữ liệu và tạo một đối tượng DanhSachMaChiPhi để lưu danh sách mã chi phí.
    - Đối tượng DanhSachMaChiPhi chứa danh sách mã chi phí dưới dạng một thuộc tính (danhSachMa).

  Sơ đồ lớp liên quan đến lưu trữ:
![Diagram](https://www.planttext.com/api/plantuml/png/UhzxlqDnIM9HIMbk3bToJc9niO9BObv6S69oXc-YSqPcG4QcGZMN0XYam2Mi57moYqjiWakAClFIxRXgkQ1Q0uhoirAJItmJynBJKtDJyqfS4aiIanABKu4I5PLmWt8IAz4jqIZ9J2q5CgqK88PgMc6u0sGD0GjqTUqmjJcavgK0VGS0003__mC0)

  Giải thích:

  - DanhSachMaChiPhi là lớp lưu trữ dữ liệu được truy vấn từ cơ sở dữ liệu.
  - ProjectManagementDatabaseProxy sử dụng DanhSachMaChiPhi để trả kết quả cho TimecardController.

  ### 6.4. Refine the Flow of Events Description

  Mục tiêu:
  
  - Mô tả chi tiết hơn luồng sự kiện chính và các luồng thay thế.

  Luồng chính:

  - Người dùng yêu cầu danh sách mã chi phí từ giao diện.
  - TimecardController gọi phương thức layDanhSachMaChiPhi(tieuChi) từ giao diện ProjectManagementDatabase.
  - ProjectManagementDatabaseProxy xử lý yêu cầu và truy vấn cơ sở dữ liệu.
  - Danh sách mã chi phí phù hợp (DanhSachMaChiPhi) được trả về cho TimecardController.
  - TimecardController hiển thị kết quả cho người dùng.

  Luồng thay thế:
    
    + Trường hợp lỗi:

      - Không tìm thấy mã chi phí: Hệ thống trả về danh sách rỗng.
      - Lỗi kết nối cơ sở dữ liệu: Hệ thống thông báo lỗi cho người dùng.
      - Sơ đồ tuần tự cho luồng chính và luồng thay thế:

  ![Diagram](https://www.planttext.com/api/plantuml/png/b9DFIWCn5CRtESMZArruWIwaq8Awg1ISZSlNJ6oYcSoGoOXTYWiN7i2LI2aY2A8BGPnPT37GU-G4Ni7CL3f_HAfP30dpVj_xtXVocIrwiK5jaa0If2RKS3XPljhiJWpo3pKXaVidg8XG6UXu8c0KjTyFbT6Xb4nt06EeZitoFO4X-C9crmf6EZnbr0nHuOG5J9a16XnZp4g50sMOFa7AcW8EkfXkGCkQ9ZP0nO-GyY7skHXnqI6aCHJixDOyT-4uVqg0slGn0T-X4ESpoY78vq2vW8ZdpwGgB-2rtIv8dBRRRHd14hVT9YWDUA9KToB0RJQFGBey2BYrLYaaop4so1NGAf8Ay7GoXNERFYYWond4Dhi7tsOl88lSaphJDEvfcyuTcLr2ksFRNIkkJMGzAuSsek_2llDrfS2uC6v-yap6h1xP6S_Vt8LLoG4FRVfEY_sj-7taFxclNRPsSaMVclX_Pp4hg-Dy5duBCEMJdlkuj_K5003__mC0)

  ### 6.5. Unify Classes and Subsystems
  
  Mục tiêu:

  - Tích hợp các lớp và subsystem vào một thiết kế thống nhất.
  
  Sơ đồ lớp tích hợp:

![Diagram](https://www.planttext.com/api/plantuml/png/h9B1Ri8m38RlUGghft7e2rHLXGIxWLIfUm6J6XgMfbFYIgisdco7FHAlGA0L7NGH5tnozDlvx3yv_lpE7QFbjjRY0-KxxWYYHMFODXgATkCwnrH7y2N0XzJe7BofcYJQSYZJP0Uv3utT4arLeApMkAXKNgcNsKK_Y8COARbjzYHvZSOVQpAyHCODEffobM6oMvG4uQP78x2YrgS956oLsSqIk2yPPXmN3SAyyDazZ_ZNbLV3YhkGzVSNtCnGNiK4LifnsdEpaVBFoyLn5jvJXErEl-FuWK7Xxjw_CthYo9nCwJ_Z2G00__y30000)

  Giải thích:

  - Control Subsystem: Chứa TimecardController để điều phối luồng xử lý.
  - ProjectManagementDatabase Subsystem: Chứa giao diện ProjectManagementDatabase và lớp triển khai ProjectManagementDatabaseProxy.
  - Entity Subsystem: Chứa DanhSachMaChiPhi để lưu trữ danh sách mã chi phí.
