package DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.GiaoVien;
import pojo.HibernateUtils;

public class GiaoVienDAO {
    public static void xoaGiaoVien(GiaoVien gv){
        Session session = HibernateUtils.getSession();
        Transaction tx=session.beginTransaction();
        session.delete(gv);
        tx.commit();
        session.close();
    }
    public static GiaoVien layGiaoVien(String maGiaoVien){
        Session session = HibernateUtils.getSession();
        GiaoVien gv = new GiaoVien();
        gv= (GiaoVien) session.get(GiaoVien.class, maGiaoVien);
        session.close();
        return gv;
    }
    public static void themGiaoVien(GiaoVien gv)
    {
        Session session = HibernateUtils.getSession();
        Transaction tx=session.beginTransaction();
        session.save(gv);
        tx.commit();
        session.close();
    }
}
