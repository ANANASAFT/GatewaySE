package DAO;

import POJO.Usr;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    final static Session session=HibernateUtil.getSession();

    static public List<Usr> getAllUserInfo(){
           List<Usr> list=new ArrayList<>();
           return list;
    }
}
