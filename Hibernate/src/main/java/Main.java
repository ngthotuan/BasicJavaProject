import dao.BasicDAO;
import pojo.Freshers;
import utils.HibernateUtils;

public class Main {

    public static void main(final String[] args) {
        Freshers gv = (Freshers) BasicDAO.get(1, Freshers.class);
        System.out.println(gv.getName());
        HibernateUtils.closeSessionFactory();
    }
}