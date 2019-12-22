package DAO;

/**
 * @author: Toon
 * @create: 2019-12-19 20:15
 **/
import java.util.List;

import POJO.Product;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HibernateDemo {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {
            System.out.println("querying all the managed entities...");
            final Query query = session.createQuery("from product");
            System.out.println("executing: " + query.getQueryString());
            List<Product> products= query.list();
            for (Product p : products) {
                System.out.println(p.getModel());
            }
        } finally {
            session.close();
        }
    }
}