import org.hibernate.Session;
import org.hibernate.query.Query;
import resources.GiaoVien;

import java.util.List;

public class GiaoVienDAO {
    public static List<GiaoVien> layDanhSachGiaoVien(){
        List<GiaoVien> ds = null;
        String hql = "select gv from GiaoVien gv";
        Session session =  HibernateUtils.getSession();
        Query query = session.createQuery(hql);
        ds = query.list();

        return ds;

    }
}
