## Báo cáo phân tích kiến trúc và ca sử dụng hệ thống "Payroll System"

#### 1. Phân tích kiến trúc

##### 1.1. Đề xuất kiến trúc

- **Kiến trúc Client-server**
  - **Client:** Ứng dụng desktop cài trên máy của nhân viên, họ có thể nhập thông tin về timecard, đơn hàng, và thay đổi phương thức thanh toán.
  - **Server:** Chứa logic xử lý nghiệp vụ và quản lý cơ sở dữ liệu liên quan đến nhân viên, thời gian làm việc, thanh toán và báo cáo.

- **Giải thích:**
  - Kiến trúc này cho phép phân chia rõ ràng giữa các thành phần xử lý trên client và server. Điều này tối ưu cho việc xử lý nhiều yêu cầu từ 5000 nhân viên trên toàn cầu.
- **Package:**
  - Các package chính gồm:
  - Gói giao diện: Giao diện nhập liệu trên client.
  - Gói xử lý nghiệp vụ: Xử lý nghiệp vụ chính như tính toán lương, quản lý nhân viên.
  - Gói truy cập dữ liệu: Giao tiếp với cơ sở dữ liệu và hệ thống DB2.
  - Gói tích hợp: Tích hợp với DB2 Project Management Database.
**Biểu đồ Package:**
![Diagram](https://www.planttext.com/api/plantuml/png/d9GnIyD068Rt_8gFJ3eKmT51IbkeOYaAiRWUQSWTffUGD4AHJWuE8kZWu5XB5o5OSCiX3f7-Z_i5_WNlMjeclOIctlgztyFxtht9B_kk1dtazyEUetd8l4Qs1Ve9P_TWOCwUgGtdQE2xZgF3hGRYh4JDv9D0ao0N6aJeAUnTdkulLVAO3Wg2kM8XQEFaZNP8yavJec6X_2BayPWQFcSFYdwevNYvuYo2Ll85RHjBWWSTpYQgeuOWcbZEZ2IYk3MRpaOYPx6dzKAf22a-wLacyhlbn1XHRBZ9I6NdnZNyS01r7aUUX7n0IsOErRXds9NpnRXKWCn6YGnP_QunaiZ481etzbJlDSvUwpWSS7P7VvuuUo6Dsc4HDxTfbSfnqOCVWHx8odJ5WDhw1YDTlnqX1T8ifItkgKCiAWasPuzaXztLc_ndT_q-sUqDnCgVN2_ga20uisbuq9TTlE7nX2fEbbOLJ3h4DiZQiuh9v550soucls62D8UOylFIDL6mgaMxyX_v1m00__y30000)
