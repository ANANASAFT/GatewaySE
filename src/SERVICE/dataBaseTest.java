package SERVICE;

import DAO.dbOps;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "dataBaseTest",urlPatterns = "/dbTest")
public class dataBaseTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try {
            String name = dbOps.getNameByID(1);
            response.getWriter().println(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
