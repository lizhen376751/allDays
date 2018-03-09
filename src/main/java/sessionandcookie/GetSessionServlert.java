package sessionandcookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Administrator on 2018/3/9.
 */
@WebServlet("/getSession")
public class GetSessionServlert extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        Object lizhen = session.getAttribute("lizhen");
        System.out.println(lizhen);
        resp.getWriter().write(lizhen.toString());
    }
}
