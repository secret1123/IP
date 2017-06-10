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
        String ip = req.getParameter("ip");

        Connection connection = Ip.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String sql = "SELECT * FROM db_1702.ip WHERE inet_aton(?) BETWEEN inet_aton(min) AND inet_aton(max)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, ip);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                req.setAttribute("message", resultSet.getString("geo"));
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Ip.close(resultSet, statement, connection);
        }
    }
}
