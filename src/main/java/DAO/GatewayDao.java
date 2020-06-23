package DAO;

import POJO.Gateway;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Map;

public class GatewayDao {
    final static Session session = HibernateUtil.getSession();

    /**
    *@Description 该函数的功能是根据传来的参数动态产生一个hql查询语句实现查询功能
    *@Param [industrialGrade, temperatureLow, temperatureHigh, currentLow, currentHigh]
    *@Return java.lang.String
    *@Author Mr.Sun
    *@Date 2020/6/21
    *@Time 20:15
    */
    private static String generateSQLExcution(int industrialGrade,double temperatureLow,double
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

    /**
    *@Description 该函数的功能是根据传来的参数动态产生一个hql查询语句实现查询功能
    *@Param [M]
    *@Return java.lang.String
    *@Author Mr.Sun
    *@Date 2020/6/21
    *@Time 20:14
    */
    private static String generateSQLExcution(Map M){
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

    /**
    *@Description 查询所有符合条件的网关信息
    *@Param [industrialGrade, temperatureLow, temperatureHigh, currentLow, currentHigh]
    *@Return java.util.List<POJO.Gateway>
    *@Author Mr.Sun
    *@Date 2020/6/21
    *@Time 20:17
    */
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
            //session.close();
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

    /**
    *@Description 该函数可根据页码和记录数返回对应的第一条记录地址
    *@Param [page, size]
    *@Return int
    *@Author Mr.Sun
    *@Date 2020/6/22
    *@Time 10:48
    */
    private static int computeFirstResult(int page,int size){
        if(page<=0)return 0;
        else
            return (page-1)*size;
    }

    /**
     *@Description 该函数可根据品牌返回相应的网关信息
     *@Param []
     *@Return void
     *@Author Mr.Sun
     *@Date 2020/6/22
     *@Time 10:34
     */
    public static List<Gateway> getNeededGatewayByBrand(String brand){
        List<Gateway>gateways;
        System.out.println("quering all Gateways By brand");
        Query query=session.createQuery("from gateway g where g.brand=:brand")
                .setParameter("brand",brand);
        gateways=query.list();
        System.out.println(gateways);
        return gateways;
    }

    /**
    *@Description 上个函数的分页重载形式
    *@Param [brand, page, size]brand：品牌名；page：页码；size：每个页面大小
    *@Return java.util.List<POJO.Gateway>
    *@Author Mr.Sun
    *@Date 2020/6/22
    *@Time 10:38
    */
    public static List<Gateway> getNeededGatewayByBrandPaged(String brand,int page ,int size){
        List<Gateway>gateways;
        System.out.println("quering all Gateways By brand");
        Query query=session.createQuery("from gateway g where g.brand=:brand")
                .setParameter("brand",brand);
        int begin=computeFirstResult(page, size);

        query.setFirstResult(begin);
        query.setMaxResults(size);
        gateways=query.list();
        System.out.println(gateways);
        return gateways;
    }

    /**
    *@Description getNeededgateway的分页形式
    *@Param [M, page, size]
    *@Return java.util.List<POJO.Gateway>
    *@Author Mr.Sun
    *@Date 2020/6/22
    *@Time 10:01
    */
    public static List<Gateway>  getNeededGeteway(Map M,int page,int size){
        List<Gateway >Gateways;
        try{
            System.out.println("querying all Gateways ");

            String hql=generateSQLExcution(M);
            System.out.println(hql);
            Query query = session.createQuery(hql);
            int begin=(page-1)*size;
            query.setFirstResult(begin);
            query.setMaxResults(size);
            System.out.println("executing: " + query.getQueryString());
            Gateways=query.list();
        }finally{
            //session.close();
        }return Gateways;
    }

    /**
    *@Description 该函数可查询所有的网关并分页返回
    *@Param [page, size]page：页数；size：大小
    *@Return java.util.List<POJO.Gateway>
    *@Author Mr.Sun
    *@Date 2020/6/22
    *@Time 9:41
    */
    public static List<Gateway> queryAllGatewayPaged(int page,int size){
        String hql="from gateway";
        Query query=session.createQuery(hql);
        int begin=computeFirstResult(page,size);
        query.setFirstResult(begin);
        query.setMaxResults(size);
        List<Gateway> gateways=query.list();
        System.out.println(gateways);
        return gateways;
    }

    /**
    *@Description 根据主键id返回对应的网关信息
    *@Param []
    *@Return POJO.Gateway
    *@Author Mr.Sun
    *@Date 2020/6/21
    *@Time 21:58
    */
    public static Gateway getNeededGatewayByid(int id){
        Gateway gateway=session.get(Gateway.class,id);
        System.out.println(gateway);
        return gateway;
    }

    /**
    *@Description 向数据库中插入一条数据
    *@Param [gateway]
    *@Return boolean
    *@Author Mr.Sun
    *@Date 2020/6/21
    *@Time 21:13
    */
    public static boolean insert(Gateway gateway){
        boolean success=true;
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            session.save(gateway);
            transaction.commit();
            System.out.println("insert success");
        }catch(Exception e){
            if(transaction!=null){
                transaction.rollback();
                e.printStackTrace();
                success=false;
            }
        }
        return success;
    }

    /**
    *@Description 根据id删除指定的网关
    *@Param [id]
    *@Return boolean
    *@Author Mr.Sun
    *@Date 2020/6/21
    *@Time 20:17
    */
    public static boolean deleteGatewayInfo(int id){
        boolean success=true;
        System.out.println("delete gateway");
        Gateway gateway=new Gateway();
        gateway.setId(id);
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            session.delete(gateway);
            transaction.commit();
        }catch(Exception e){
            if(transaction!=null){
                transaction.rollback();
                e.printStackTrace();
                success=false;
            }
        }
        return success;
    }

    /**
    *@Description 根据给与的一个瞬时态对象更新数据库表的内容
    *@Param [gateway]
    *@Return boolean
    *@Author Mr.Sun
    *@Date 2020/6/22
    *@Time 9:54
    */
    public static boolean updateGatewayInfo(Gateway gateway){
        boolean success=true;
        System.out.println("update gateway");
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            session.update(gateway);
            transaction.commit();
        }catch(Exception e ){
            if(transaction!=null){
                transaction.rollback();
                e.printStackTrace();
                success=false;
            }
        }
        return success;
    }

}
