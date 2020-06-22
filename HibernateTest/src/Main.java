import DAO.DanhMucDAO;
import pojo.DeTai;
import pojo.ThamGiaDeTai;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        //Set<Sach>set=DAO.DanhMucDAO.layThongTinDanhMuc("DMMD").getSachSet();
        //DanhMuc danhMuc=new DanhMuc("123");
//        System.out.println(DanhMucDAO.layDanhSachSach("DM1"));

        DeTai dt = new DeTai();
        dt.setMaDeTai("DT1");
        dt.setTenDeTai("De tai so 1");
        dt.setThamGiaDeTaisByMaDeTai(new HashSet<ThamGiaDeTai>());
    }
}