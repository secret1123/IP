package demo.servlet;

import demo.util.Ip;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by AnLu on
 * 2017/6/10 09:36.
 * IP
 */
@WebServlet(urlPatterns = "/index")
public class AddressServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ip = req.getParameter("ip").trim();
        if (ip.length() == 0) {
            ip = req.getRemoteAddr();
        }
        req.getSession().setAttribute("geo", getGeo(ip));
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
    public static String getGeo(String ip){
        Connection connection = Ip.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
            String sql = "SELECT geo\n"+"FROM db_1702.ip\n"+"WHERE inet_aton(?) BETWEEN inet_aton(min) AND inet_aton(max)";
        try {
            if (connection != null) {
                statement = connection.prepareStatement(sql);
            }else {
                return null;
            }
            statement.setString(1, ip);
            resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getString("geo");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Ip.close(resultSet, statement, connection);
        }
        return null;
    }
}
