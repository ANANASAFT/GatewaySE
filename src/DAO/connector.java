package DAO;

import java.sql.*;

public class connector {
    String url = "jdbc:mysql://106.13.178.235:3306/gatewaySE";
    String user= "root";
    String passwd= "413413@@";
    Statement getState() throws SQLException, ClassNotFoundException {
        java.lang.Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, user, passwd);
        Statement state = conn.createStatement();
        return state;
    }
}
