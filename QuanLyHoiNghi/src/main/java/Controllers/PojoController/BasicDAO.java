package Controllers.PojoController;

import Model.Pojo.DAO;
import Utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public abstract class BasicDAO {

    public static DAO get(String id, Class<? extends DAO> daoClass){
        DAO dao = null;
        Session session = HibernateUtils.getSessionFactory().openSession();
        try{
            dao = session.get(daoClass, id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return dao;
    }
    public static DAO get(int id, Class<? extends DAO> daoClass){
        DAO dao = null;
        Session session = HibernateUtils.getSessionFactory().openSession();
        try{
            dao = session.get(daoClass, id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return dao;
    }
    public static List<? extends DAO> getAll(String table){
        List<? extends DAO> ds = null;
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            String hql = String.format("from %s", table);
            Query query = session.createQuery(hql);
            ds = query.list();
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }
    public static boolean create(DAO dao){
        boolean result = true;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(dao);
            transaction.commit();
        } catch (HibernateException ex) {
            //Log the exception
            transaction.rollback();
            System.err.println(ex);
            result = false;
        } finally {
            session.close();
        }
        return result;
    }
    public static boolean update(DAO dao){
        boolean result = true;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(dao);
            transaction.commit();
        } catch (HibernateException ex) {
            //Log the exception
            transaction.rollback();
            System.err.println(ex);
            result = false;
        } finally {
            session.close();
        }
        return result;
    }

}
