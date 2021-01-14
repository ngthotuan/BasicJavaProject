package DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.DeTai;
import pojo.DeTai;
import pojo.HibernateUtils;

public class DeTaiDAO {
    public static void xoaDeTai(DeTai dt){
        Session session = HibernateUtils.getSession();
        Transaction tx=session.beginTransaction();
        session.delete(dt);
        tx.commit();
        session.close();
    }
    public static DeTai layDeTai(String maDeTai){
        Session session = HibernateUtils.getSession();
        DeTai dt = new DeTai();
        dt= (DeTai) session.get(DeTai.class, maDeTai);
        session.close();
        return dt;
    }
    public static void themDeTai(DeTai dt)
    {
        Session session = HibernateUtils.getSession();
        Transaction tx=session.beginTransaction();
        session.save(dt);
        tx.commit();
        session.close();
    }
}
