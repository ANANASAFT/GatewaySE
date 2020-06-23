package DAO;


import POJO.Sensor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SensorDao {
    final static Session session = HibernateUtil.getSession();


    /**
    *@Description 该函数的功能是根据传来的参数动态产生一个hql查询语句实现查询功能
    *@Param [M]
    *@Return java.lang.String
    *@Author Mr.Sun
    *@Date 2020/6/23
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
        if(M.get("frequencyHigh")!=null){
            s.append(" and frequencyHigh < "+M.get("frequencyHigh"));
        }
        if(M.get("frequencyLow")!=null){
            s.append(" and frequencyLow > "+M.get("frequencyLow"));
        }
        if(M.get("voltageHigh")!=null){
            s.append(" and voltageHigh < "+M.get("voltageHigh"));
        }
        if(M.get("voltageLow")!=null){
            s.append(" and voltageLow > "+M.get("voltageLow"));
        }


        String string=s.toString();
        return string;
    }

    public static List<Sensor>  getNeededSensor(Map M){
        List<Sensor >sensors;
        try{
            System.out.println("querying all sensors ");

            String hql=generateSQLExcution(M);
            System.out.println(hql);
            Query query = session.createQuery(hql);

            System.out.println("executing: " + query.getQueryString());
            sensors=query.list();
        }finally{
            //session.close();
        }return sensors;
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
    *@Description 该函数可根据品牌返回相应的传感器信息
    *@Param [brand]
    *@Return java.util.List<POJO.Sensor>
    *@Author Mr.Sun
    *@Date 2020/6/23
    *@Time 20:08
    */
    public static List<Sensor> getNeededSensorByBrand(String brand){
        List<Sensor>sensors;
        System.out.println("quering all sensors By brand");
        Query query=session.createQuery("from sensor s where s.brand=:brand")
                .setParameter("brand",brand);
        sensors=query.list();
        System.out.println(sensors);
        return sensors;
    }

    /**
    *@Description 上个函数的分页重载形式
    *@Param [brand, page, size]
    *@Return java.util.List<POJO.Sensor>
    *@Author Mr.Sun
    *@Date 2020/6/23
    *@Time 20:11
    */
    public static List<Sensor> getNeededSensorByBrandPaged(String brand,int page ,int size){
        List<Sensor>sensors;
        System.out.println("quering all sensors By brand");
        Query query=session.createQuery("from sensor s where s.brand=:brand")
                .setParameter("brand",brand);
        int begin=computeFirstResult(page, size);

        query.setFirstResult(begin);
        query.setMaxResults(size);
        sensors=query.list();
        System.out.println(sensors);
        return sensors;
    }

    /**
    *@Description getNeededSensor的分页形式
    *@Param [M, page, size]
    *@Return java.util.List<POJO.Sensor>
    *@Author Mr.Sun
    *@Date 2020/6/23
    *@Time 20:04
    */
    public static List<Sensor>  getNeededSensor(Map M,int page,int size){
        List<Sensor>sensors;
        try{
            System.out.println("querying all sensors ");

            String hql=generateSQLExcution(M);
            System.out.println(hql);
            Query query = session.createQuery(hql);
            int begin=computeFirstResult(page,size);
            query.setFirstResult(begin);
            query.setMaxResults(size);
            System.out.println("executing: " + query.getQueryString());
            sensors=query.list();
        }finally{
            //session.close();
        }return sensors;
    }

    /**
    *@Description 该函数可查询所有的传感器并分页返回
    *@Param [page, size]
    *@Return java.util.List<POJO.Sensor>
    *@Author Mr.Sun
    *@Date 2020/6/23
    *@Time 19:52
    */
    public static List<Sensor> queryAllSensorPaged(int page,int size){
        String hql="from sensor ";
        Query query=session.createQuery(hql);
        int begin=computeFirstResult(page,size);
        query.setFirstResult(begin);
        query.setMaxResults(size);
        List<Sensor> sensors=query.list();
        System.out.println(sensors);
        return sensors;
    }

    /**
    *@Description 根据主键id返回对应的传感器信息
    *@Param [id]
    *@Return POJO.Sensor
    *@Author Mr.Sun
    *@Date 2020/6/23
    *@Time 19:49
    */
    public static Sensor getNeededSensorByid(int id){
        Sensor sensor=session.get(Sensor.class,id);
        System.out.println(sensor);
        return sensor;
    }

   /**
   *@Description 该函数的作用插入一条新的传感器数据
   *@Param [sensor]
   *@Return boolean
   *@Author Mr.Sun
   *@Date 2020/6/23
   *@Time 19:43
   */
    public static boolean insert(Sensor sensor){
        boolean success=true;
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            session.save(sensor);
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
    *@Description 根据id删除指定的传感器信息
    *@Param [id]
    *@Return boolean
    *@Author Mr.Sun
    *@Date 2020/6/23
    *@Time 19:46
    */
    public static boolean deleteSensorInfo(int id){
        boolean success=true;
        System.out.println("delete sensor");
        Sensor sensor=new Sensor();
        sensor.setId(id);
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            session.delete(sensor);
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
    *@Description 该函数的功能是更新一条传感器的数据信息
    *@Param [sensor]
    *@Return boolean
    *@Author Mr.Sun
    *@Date 2020/6/23
    *@Time 19:45
    */
    public static boolean updateSensorInfo(Sensor sensor){
        boolean success=true;
        System.out.println("update sensor");
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            session.update(sensor);
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
