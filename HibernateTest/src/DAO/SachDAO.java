package DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.HibernateUtils;
import pojo.Sach;

public class SachDAO {
    static final Session session = HibernateUtils.getSession();
    public static void xoaSach(Sach sach){
        Transaction tx=session.beginTransaction();
        session.delete(sach);
        tx.commit();
    }
    public static Sach getSaches(){
        Sach saches = new Sach();

        saches= (Sach) session.get(Sach.class, "S02");
       // System.out.println(saches);
        return saches;
    }
    public static void LuuSach(Sach sv)
    {
        Transaction tx=session.beginTransaction();
        session.save(sv);
        tx.commit();
    }
}
