import dao.BasicDAO;
import pojo.Freshers;
import utils.HibernateUtils;

public class Main {

    public static void main(final String[] args) {
        Freshers freshers = new Freshers();
        freshers.setName("test-1");
        System.out.println(BasicDAO.delete(freshers));
        HibernateUtils.closeSessionFactory();
    }
}