package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtils;

import java.io.Serializable;
import java.util.List;

public abstract class BasicDAO {

    public static Object get(Object id, Class<?> clazz){
        Object result = null;
        Session session = HibernateUtils.getSession();
        try{
            result = session.get(clazz, (Serializable) id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    public static List<?> getAll(String entityName){
        List<?> ds = null;
        try (Session session = HibernateUtils.getSession()) {
            String hql = String.format("from %s", entityName);
            Query query = session.createQuery(hql);
            ds = query.list();
        } catch (HibernateException ex) {
            //Log the exception
            ex.printStackTrace();
        }
        return ds;
    }
    public static boolean create(Object obj){
        boolean result = true;
        try (Session session = HibernateUtils.getSession()) {
            Transaction transaction = null;
            transaction = session.beginTransaction();
            session.save(obj);
            transaction.commit();
        } catch (HibernateException ex) {
            //Log the exception
            ex.printStackTrace();
            result = false;
        }
        return result;
    }
    public static boolean update(Object obj){
        boolean result = true;
        try (Session session = HibernateUtils.getSession()) {
            Transaction transaction = null;
            transaction = session.beginTransaction();
            session.update(obj);
            transaction.commit();
        } catch (HibernateException ex) {
            //Log the exception
            ex.printStackTrace();
            result = false;
        }
        return result;
    }

}