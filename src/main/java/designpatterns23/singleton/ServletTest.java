package designpatterns23.singleton;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2018/3/1.
 */
@WebServlet("/getServlet")
public class ServletTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 创建请求
         */
        CloseableHttpClient aDefault = HttpClients.createDefault();
        /**
         * 创建get请求
         */
        HttpGet httpGet = new HttpGet("http://127.0.0.1/app.ZMTManage/?m=zmtmanage&c=index&a=init");
        /**
         * 执行请求
         */
        CloseableHttpResponse execute = aDefault.execute(httpGet);
        /**
         * 获取状态
         */
        int statusCode = execute.getStatusLine().getStatusCode();
        if (200==statusCode){
            /**
             * 解析请求头
             */
            String entity = EntityUtils.toString(execute.getEntity());
            /**
             * 写入response
             */
            resp.getWriter().print(entity);
            /**
             * 关闭请求
             */
            execute.close();
            aDefault.close();

        }
    }
}
