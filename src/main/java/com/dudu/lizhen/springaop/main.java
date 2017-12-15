package com.dudu.lizhen.springaop;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/12/13.
 */
public class main {
    public static void  main(String[] args){
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
        AServiceImpl aService = (AServiceImpl)beanFactory.getBean("aService");
        aService.barA();
        aService.fooA("Spring的Aop测试");

        BServiceImpl bService = new BServiceImpl();
        bService.fooB();
        bService.barB("1223",2);

    }
}
