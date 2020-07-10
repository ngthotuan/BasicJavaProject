package Controllers.PojoController;

import Utils.HibernateUtils;
import Utils.Password;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pojo.User;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

public class UserController {
    public static User getUser(String username){
        User User = null;
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            User = session.get(User.class, username);
        } catch (HibernateException ex) {
        //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return User;
    }
    public static List<User> getUsers(){
        List<User> ds = null;
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            String hql = "select user from Users user";
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
    public static boolean createUser(User user){
        Session session = HibernateUtils.getSessionFactory().openSession();
        if (getUser(user.getUsername())!=null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            user.setPassword(Password.genPassword(user.getPassword()));
            session.save(user);
            transaction.commit();
        } catch (HibernateException ex) {
            //Log the exception
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }
    public static User login(String username, String password) {
        User user = getUser(username);
        if(user != null){
            boolean check = Password.checkPassword(password, user.getPassword());;
            if(!check) user = null;
        }
        return user;
    }
}
