package com.dudu.lizhen.createIOC;

import com.dudu.lizhen.reflex.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 利用反射读取application.xml文件（我们要做的就是实现类似的这个）
 * Created by lizhen on 2018/4/2 0002.
 */
public class ReadApplicationXMl {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        User user =(User) classPathXmlApplicationContext.getBean("User");
        System.out.println(user.toString());
    }
    public void redaXml(){


    }
}
