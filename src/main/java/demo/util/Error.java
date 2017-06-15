package demo.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by AnLu on
 * 2017/6/14 16:30.
 * JavaEE_1702
 */
public class Error {
    public static void showErrorMessage(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException{
        req.setAttribute("message", "出现问题");
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
