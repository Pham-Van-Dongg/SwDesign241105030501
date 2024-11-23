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

  Sơ đồ lớp hợp nhất với phân hệ:

  ![Diagram](https://www.planttext.com/api/plantuml/png/R591JiCm4Bpx5QkSWaG_q0Cg4XAgk17r0Pl492iSEuhNHHNggI_W8Rrn8WSEz2Dv0L_0BadQGlRadLtFpAxztNukB6F3hbAYnkmP2mdHQWc9I-t6igmYU1K0cK9hmUCX2L58NbdPB7NjEBwQGy8DwQ8lvcHhXPj7QPtYsFEpiqEBxrqRodtdLcp5IVFMSIarKuPCHa_hN_Oan_heI9c2T2mh93LeNKFjhxsO9ZzJJurH4lK_0tV8cAALqz9ZTP2pk9PnMC5fe11FfFDV4nuFvQCEm6c77Xj9o1iZpNrsuRt7_WumsFPFCPlTJ6za3j5zr-u9kFnwrmKmQJYy7NR-gClkOrz7Ol9U81pdz2GFrBMx2hZ1CwP8BAJE_NVv0G00__y30000)

  Giải thích:

  - UI Subsystem: Chịu trách nhiệm giao tiếp với người dùng (nhận thông tin và hiển thị kết quả).
  - Authentication Subsystem: Xử lý logic xác thực (kiểm tra thông tin đăng nhập).
  - Database Subsystem: Lưu trữ và quản lý thông tin người dùng.
