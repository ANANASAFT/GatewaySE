package CONTROLLER;

import org.springframework.web.bind.annotation.*;
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
    @ResponseBody
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
