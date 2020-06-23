package DAO;
/**
 * @author: Toon
 * @create: 2019-12-19 18:52
 **/
import POJO.Gateway;
import POJO.Product;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Map;


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

    /*
*
*function:根据给与的参数信息生成对应的SQl语句
* 参数：int industrialGrade,double temperatureLow,double
      temperatureHigh,double currentLow,double currentHigh
* */
    public static String generateSQLExcution(int industrialGrade,double temperatureLow,double
            temperatureHigh,double currentLow,double currentHigh){
        StringBuilder  s=new StringBuilder(" from gateway where 1=1");
        if(industrialGrade>= 0 && industrialGrade<3 ){
            s.append(" and industrialGrade = "+industrialGrade);
        }
        if(temperatureLow!=0){
            s.append(" and temperatureLow > "+temperatureLow);
        }
        if(temperatureHigh!=0){
            s.append(" and temperatureHigh < "+temperatureHigh);
        }
        if(currentLow!=0){
            s.append(" and current > "+currentLow);
        }
        if (currentHigh != 0) {
            s.append(" and current <"+currentHigh);
        }
        String string=s.toString();
        return string;
    }

    public static String generateSQLExcution(Map M){
        StringBuilder  s=new StringBuilder(" from gateway where 1=1");
        if(M.get("industrialGrade")!=null ){
            int industrialGrade=(Integer)M.get("industrialGrade");
            if(industrialGrade>=0&&industrialGrade<3)
                s.append(" and industrialGrade = "+industrialGrade);
        }
        if(M.get("temperatureLow")!=null){
            s.append(" and temperatureLow > "+M.get("temperatureLow"));
        }
        if(M.get("temperatureHigh")!=null ){
            s.append(" and temperatureHigh < "+M.get("temperatureHigh"));
        }
        if(M.get("currentLow")!=null){
            s.append(" and current > "+M.get("currentLow"));
        }
        if (M.get("currentHigh")!=null) {
            s.append(" and current < "+M.get("currentHigh"));
        }

        String string=s.toString();
        return string;
    }

    public static List<Gateway> getNeededGeteway(int industrialGrade, double temperatureLow, double
            temperatureHigh, double currentLow, double currentHigh){
        List<Gateway >Gateways;
        try{
            System.out.println("querying all Gateways ");

            String hql=generateSQLExcution(industrialGrade, temperatureLow,
                    temperatureHigh, currentLow, currentHigh);
            System.out.println(hql);
            final Query query = session.createQuery(hql);

            System.out.println("executing: " + query.getQueryString());
            Gateways=query.list();
        }finally{
            session.close();
        }return Gateways;
    }

    public static List<Gateway>  getNeededGeteway(Map M){
        List<Gateway >Gateways;
        try{
            System.out.println("querying all Gateways ");

            String hql=generateSQLExcution(M);
            System.out.println(hql);
            Query query = session.createQuery(hql);

            System.out.println("executing: " + query.getQueryString());
            Gateways=query.list();
        }finally{
            //session.close();
        }return Gateways;
    }


}

