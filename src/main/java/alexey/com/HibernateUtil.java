package alexey.com;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private SessionFactory sessionFactory;
    private static HibernateUtil instance = new HibernateUtil();

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public static HibernateUtil getInstance() {
        return instance;
    }

    private HibernateUtil() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }


}
