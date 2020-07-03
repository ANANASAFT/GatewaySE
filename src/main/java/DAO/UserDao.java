package DAO;

import POJO.Usr;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    final static Session session=HibernateUtil.getSession();

    /**
    *@Description 获取全部用户信息
    *@Param []
    *@Return java.util.List<POJO.Usr>
    *@Author Mr.Sun
    *@Date 2020/7/3
    *@Time 9:35
    */
    static public List<Usr> getAllUserInfo(){
           List<Usr> list=new ArrayList<>();
           String hql="from usr";
           Query query=session.createQuery(hql);
           list=query.list();
           return list;
    }

    /**
    *@Description 该函数的作用是根据用户名返回密码，用户名不正确则抛出异常
    *@Param [name]
    *@Return java.lang.String
    *@Author Mr.Sun
    *@Date 2020/7/3
    *@Time 10:11
    */
    public static String getPassword(String name) throws Exception {
          Query query=session.createQuery("from usr  u where u.name =: name")
                  .setParameter("name",name);
          List<Usr> list=query.list();
          if(list.size()==0){
              throw new Exception("用户名不正确");
          }
          Usr user=list.get(0);
        System.out.println(user.getPassword());

        return user.getPassword();
    }

    /**
    *@Description 注册新用户
    *@Param [usr]
    *@Return boolean
    *@Author Mr.Sun
    *@Date 2020/7/3
    *@Time 10:31
    */
    public static boolean insertUser(Usr usr){
        boolean success=true;
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            session.save(usr);
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
    *@Description 根据用户id删除用户信息
    *@Param [id]
    *@Return void
    *@Author Mr.Sun
    *@Date 2020/7/3
    *@Time 10:14
    */
    public static boolean deleteUsrInfo(int id){
        boolean success=true;
        System.out.println("delete usr");
        Usr user=new Usr();
        user.setId(id);
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            session.delete(user);
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

    public static boolean judgeExistByName(String name){
        Query query=session.createQuery("from usr  u where u.name =: name")
                .setParameter("name",name);
        List<Usr> list=query.list();
        if(list.size()==0){
            return false;
        }
        return true;
    }

    /**
    *@Description 修改用户的信息
    *@Param [user]
    *@Return boolean
    *@Author Mr.Sun
    *@Date 2020/7/3
    *@Time 10:40
    */
    public static boolean updateUserInfo(Usr user){
        boolean success=true;
        System.out.println("update user");
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            session.update(user);
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
