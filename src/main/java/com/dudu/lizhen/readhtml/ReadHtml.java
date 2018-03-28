package com.dudu.lizhen.readhtml;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;


/**
 * 读取文件（html和txt。。。）转换成字符串，然后返回至浏览器端
 */
public class ReadHtml {


    public void doFilter(HttpServletRequest req, HttpServletResponse resp) {
        //适合在过滤器中使用,
        ModifyHttpServletRequestWrapper modifyHttpServletRequestWrapper = new ModifyHttpServletRequestWrapper(req);

        //获取成功登录页面地址
        HttpSession session = req.getSession();
        OutputStream os = null;
        try {
            //返回带二维码的登录页面
            //获取本类加载的路径
            String path = ReadHtml.class.getResource("").getPath();
            //获取类加载的根路径，也就是到了class文件这一层
            ReadHtml.class.getClass().getResource("/").getPath();
            String filepath = path + "\\signin.httl";
            //读取httl文件
            String content = getString(filepath);
            //获取配置文件的参数,或者将空字符串替换
            content = content.replace(" ", "");
            //设置字符集
            req.setCharacterEncoding("UTF-8");
            resp.setHeader("Content-type", "text/html;charset=UTF-8");
            resp.setContentType("text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
            //输出字符串
            os = new BufferedOutputStream(resp.getOutputStream());
            //getbytes其实就是默认转换成中国特有的字符集，加上字符集就按照你设计的字符集来操作
            os.write(content.getBytes("utf-8"));
            os.flush();
            os.close();
            modifyHttpServletRequestWrapper.putHeader("uniqueNo", "");
            //转发至成功登录页面
            String successsigninurl = "";
            req.getRequestDispatcher(successsigninurl).forward(modifyHttpServletRequestWrapper, resp);
            File file = new File(filepath);//定义一个file对象，用来初始化FileReader//定义一个file对象，用来初始化FileReader

        } catch (Exception e) {

        }


    }

    public static String getString(String filepath) {

        File file = new File(filepath);//定义一个file对象，用来初始化FileReader//定义一个file对象，用来初始化FileReader
        String content = null;
        try {
            Files.readAllBytes(file.toPath());
            content = new String(Files.readAllBytes(file.toPath()), Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(content + "===================================");
        return content;

    }

    public static void main(String[] args) {
        String path = ReadHtml.class.getResource("").getPath();
        System.out.println("=======================获取本类加载的路径："+path);
        //=======================获取本类的路径：/F:/ProjectAddress/allDays/target/classes/com/dudu/lizhen/readhtml/
        String path1 = ReadHtml.class.getClass().getResource("/").getPath();
        System.out.println("=======================获取类加载的根的路径："+path1);
        //=======================获取本类的路径：/F:/ProjectAddress/allDays/target/classes/
        String filepath = path1 + "signin.httl";
        String string = getString(filepath);
    }



}
