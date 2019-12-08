package DAO;
import java.sql.*;
import DAO.connector;

public class dbOps {
    Statement state = new connector().getState();
    public dbOps() throws SQLException, ClassNotFoundException {
    }
    public String getNameByID(int ID) throws SQLException {
        String S = String.format("select name from person where ID = %d",ID);
        ResultSet rs = state.executeQuery(S);
        String name = "none";
        while (rs.next()){
            name = rs.getString("name");
        }
        return name;
    }
}
