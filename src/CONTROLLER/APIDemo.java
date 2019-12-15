package CONTROLLER;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import DAO.dbOps;
import POJO.usr;

import java.sql.SQLException;

/**
 * @author: Toon
 * @create: 2019-12-15 12:45
 **/
@RestController
@RequestMapping("/api")
public class APIDemo
{
    @RequestMapping("/get_usr")
    public usr getUsr(){
        usr P = new usr();
        P.setId(1);
        try {
            P.setName(dbOps.getNameByID(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return P;
    }
}
