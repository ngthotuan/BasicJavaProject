package DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.HibernateUtils;
import pojo.DanhMuc;
import pojo.Sach;

import java.util.Collection;

public class DanhMucDAO {
    static final Session session = HibernateUtils.getSession();

    public static DanhMuc layThongTinDanhMuc(String maDanhMuc){
        return session.get(DanhMuc.class, maDanhMuc);
    }

    public static void xoaDanhMuc(String maDanhMuc) {
        //DanhMuc dm = new DanhMuc(maDanhMuc);

        Transaction transaction = session.beginTransaction();
        session.delete(new DanhMuc(maDanhMuc));
        transaction.commit();

    }

    public static void updataDanhMuc(DanhMuc dm){
        Transaction transaction = session.beginTransaction();
        dm.setMaDanhMuc(dm.getTenDanhMuc()+"update");
        session.update(dm);
        transaction.commit();
    }
    public static void themDanhMuc(DanhMuc dm){
        Transaction tx=session.beginTransaction();
        session.save(dm);
        tx.commit();

    }

    public static Collection<Sach> layDanhSachSach(String maDanhMuc){
        return layThongTinDanhMuc(maDanhMuc).getSachesByMaDanhMuc();
    }

}

