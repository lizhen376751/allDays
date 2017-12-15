package com.dudu.lizhen.springaop;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/12/13.
 */
public class Client {
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
        UserManager userManager = (UserManager)factory.getBean("userManager");

        //可以查找张三
        userManager.findUserById(1);

        System.out.println("=====我==是==分==割==线=====");

        try {
            // 查不到数据，会抛异常，异常会被AfterThrowingAdvice捕获
            userManager.findUserById(0);
        } catch (IllegalArgumentException e) {
        }
    }
}
