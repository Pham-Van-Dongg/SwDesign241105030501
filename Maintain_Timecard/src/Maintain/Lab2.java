package Maintain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Lớp Employee đại diện cho mỗi nhân viên
class Employee {
    private String maNhanVien;
    private String tenNhanVien;
    private List<Timecard> danhSachTimecard;

    public Employee(String maNhanVien, String tenNhanVien) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.danhSachTimecard = new ArrayList<>();
    }

    public void themTimecard(Timecard timecard) {
        danhSachTimecard.add(timecard);
    }

    public List<Timecard> getDanhSachTimecard() {
        return danhSachTimecard;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }
}

// Lớp Timecard chứa thông tin về giờ làm việc và mã dự án
class Timecard {
    private String ngay;
    private int soGioLamViec;
    private String maDuAn;

    public Timecard(String ngay, int soGioLamViec, String maDuAn) {
        this.ngay = ngay;
        this.soGioLamViec = soGioLamViec;
        this.maDuAn = maDuAn;
    }

    public String getNgay() {
        return ngay;
    }

    public int getSoGioLamViec() {
        return soGioLamViec;
    }

    public String getMaDuAn() {
        return maDuAn;
    }
}

// Lớp TimecardRepository quản lý lưu trữ và truy vấn dữ liệu Timecard
class TimecardRepository {
    private Map<String, List<Timecard>> database = new HashMap<>();

    public void luuTimecard(String maNhanVien, Timecard timecard) {
        database.computeIfAbsent(maNhanVien, k -> new ArrayList<>()).add(timecard);
        System.out.println("Timecard đã được lưu cho nhân viên: " + maNhanVien +
                " | Ngày: " + timecard.getNgay() +
                " | Số giờ làm việc: " + timecard.getSoGioLamViec() +
                " | Mã dự án: " + timecard.getMaDuAn());
    }

    public List<Timecard> layTimecard(String maNhanVien) {
        return database.getOrDefault(maNhanVien, new ArrayList<>());
    }

    public void xoaTimecard(String maNhanVien, Timecard timecard) {
        if (database.containsKey(maNhanVien)) {
            database.get(maNhanVien).remove(timecard);
            System.out.println("Timecard đã được xóa cho nhân viên: " + maNhanVien +
                    " | Ngày: " + timecard.getNgay() +
                    " | Số giờ làm việc: " + timecard.getSoGioLamViec() +
                    " | Mã dự án: " + timecard.getMaDuAn());
        }
    }
}

// Lớp TimecardService chịu trách nhiệm xử lý logic nghiệp vụ liên quan đến Timecard
class TimecardService {
    private TimecardRepository repository;

    public TimecardService(TimecardRepository repository) {
        this.repository = repository;
    }

    public void taoTimecard(Employee employee, Timecard timecard) {
        employee.themTimecard(timecard);
        repository.luuTimecard(employee.getMaNhanVien(), timecard);
    }

    public void capNhatTimecard(Employee employee, Timecard oldTimecard, Timecard newTimecard) {
        employee.getDanhSachTimecard().remove(oldTimecard);
        employee.themTimecard(newTimecard);
        repository.xoaTimecard(employee.getMaNhanVien(), oldTimecard);
        repository.luuTimecard(employee.getMaNhanVien(), newTimecard);
    }

    public void xoaTimecard(Employee employee, Timecard timecard) {
        employee.getDanhSachTimecard().remove(timecard);
        repository.xoaTimecard(employee.getMaNhanVien(), timecard);
    }
}

// Lớp Lab2 để kiểm tra và chạy mã
public class Lab2 {
    public static void main(String[] args) {
        TimecardRepository repository = new TimecardRepository();
        TimecardService service = new TimecardService(repository);

        Employee employee = new Employee("NV01", "Nguyen Van A");
        Timecard timecard1 = new Timecard("2024-11-10", 8, "DA001");
        Timecard timecard2 = new Timecard("2024-11-11", 7, "DA002");

        // Tạo Timecard mới
        service.taoTimecard(employee, timecard1);
        service.taoTimecard(employee, timecard2);

        // Cập nhật Timecard
        Timecard newTimecard = new Timecard("2024-11-10", 9, "DA001");
        service.capNhatTimecard(employee, timecard1, newTimecard);

        // Xóa Timecard
        service.xoaTimecard(employee, newTimecard);
    }
}
