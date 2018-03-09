package sessionandcookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * Created by lizhen on 2018/3/9.
 */
@WebServlet("/addCookie")
public class AddCookieServlert extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("lizhen","goodgood");
        resp.addCookie(cookie);
        resp.getWriter().write("success");
        System.out.println("cookie添加成功!!!!");
    }
}
