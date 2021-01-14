import resources.GiaoVien;

import java.util.List;

public class Main {


    public static void main(final String[] args) {
        List<GiaoVien> dsgv = GiaoVienDAO.layDanhSachGiaoVien();
    }
}