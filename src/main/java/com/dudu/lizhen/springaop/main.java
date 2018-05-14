package com.dudu.lizhen.springaop;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by Administrator on 2017/12/13.
 */
public class main {
    public static void  main(String[] args){
        //这里之所以会报错，是因为它读取的话，默认就是读取classes下面的，而web-inf显然和它并不是一个包，所以会报错，以后写的时候尽量放在resource里面这样就能和classes在一块了。
        //如果前面加上了classpath，那么他就一定会在classes里面去寻找。而classpath*：不仅包含class路径，还包括jar文件中(class路径)进行查找.

        ClassPathXmlApplicationContext beanFactory = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ClassPathXmlApplicationContext beanFactory = new ClassPathXmlApplicationContext("/src/main/webapp/WEB-INF/applicationContext.xml");
        //如果路径一定会在classes下面，那么就可以用下面这种方法也可以解决
//        ApplicationContext beanFactory =  new FileSystemXmlApplicationContext("/src/main/webapp/WEB-INF/applicationContext.xml");


        BServiceImpl BServiceImpl = (BServiceImpl)beanFactory.getBean("bService");
        AServiceImpl aService = (AServiceImpl)beanFactory.getBean("aService");
        aService.barA();
        aService.fooA("Spring的Aop测试");

        BServiceImpl bService = new BServiceImpl();
        bService.fooB();
        bService.barB("1223",2);

    }
}
