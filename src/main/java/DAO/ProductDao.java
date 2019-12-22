package DAO;
/**
 * @author: Toon
 * @create: 2019-12-19 18:52
 **/
import POJO.Product;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;


public class ProductDao {
    final static Session session = HibernateUtil.getSession();
    static public List<Product> getProductListByBrand(String brand) {
        List<Product> products;
        try {
            System.out.println("querying all the products by brand "+ brand);
            final Query query = session.createQuery("from product p where p.brand = ?1");
            query.setParameter(1,brand);
            System.out.println("executing: " + query.getQueryString());
            products = query.list();
        }finally {
//            session.close();
        }
        return products;
    }

    public static List<Product> getAllProducts() {
        List<Product> products;
        try {
            System.out.println("querying all the products");
            final Query query = session.createQuery("from product");
            System.out.println("executing: " + query.getQueryString());
            products = query.list();
        }finally {
//            session.close();
        }
        return products;
    }
}

