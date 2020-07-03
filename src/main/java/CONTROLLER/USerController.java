package CONTROLLER;


import POJO.Usr;
import SERVICE.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class USerController {
         @Autowired
        private UserService userService;

         /**
         *@Description 登录
         *@Param [username, password]
         *@Return boolean
         *@Author Mr.Sun
         *@Date 2020/7/3
         *@Time 11:16
         */
         public boolean login(String username,String password){
             boolean success = false;
             try {
                 String pass=userService.getPassword(username);
                 if(pass.equals(password))
                     success=true;
             } catch (Exception e) {
                 e.printStackTrace();
             }
             return success;
         }

         /**
         *@Description 将前端传过来的信息抽取生成sr对象
         *@Param [M]
         *@Return POJO.Usr
         *@Author Mr.Sun
         *@Date 2020/7/3
         *@Time 12:10
         */
         public Usr extractMapToUsr(Map M){
             Usr user=new Usr();
             if(M.get("username")!=null)
                 user.setName((String)M.get("username"));
             if(M.get("password")!=null)
                 user.setPassword((String)M.get("password"));
             if(M.get("e_mail")!=null)
                 user.setE_mail((String)M.get("e_mail"));
             return user;
         }

         /**
         *@Description 注册
         *@Param [M]
         *@Return boolean
         *@Author Mr.Sun
         *@Date 2020/7/3
         *@Time 11:16
         */
         public boolean Register(Map M){
                Usr user=extractMapToUsr(M);
                return userService.insertUser(user);
         }

         /**
         *@Description 修改用户相关信息
         *@Param [M]
         *@Return boolean
         *@Author Mr.Sun
         *@Date 2020/7/3
         *@Time 12:12
         */
         public boolean unpdate(Map M){
             Usr user=extractMapToUsr(M);
             return userService.updateUserInfo(user);
         }

         public boolean deleteUserInfo(int id){
             return userService.deleteUsrInfo(id);
         }
}
