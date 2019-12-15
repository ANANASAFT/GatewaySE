package DAO;
import java.sql.*;
import DAO.connector;

public class dbOps {
    static Statement state;

    static {
        try {
            state = new connector().getState();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public dbOps() throws SQLException, ClassNotFoundException {
    }
    public static String getNameByID(int ID) throws SQLException {
        String S = String.format("select name from usr where id = %d",ID);
        ResultSet rs = state.executeQuery(S);
        String name = "none";
        while (rs.next()){
            name = rs.getString("name");
        }
        return name;
    }
}
