package com.dudu.lizhen.javaDesign.listen2;

/**
 * 监听器实现类
 * Created by lizhen on 2017/10/25.
 */
public class DemoListener1 implements DemoListener {
    /**
     * 将封装的参数的类传入进来
     * @param de
     */
    public void handleEvent(DemoEvent de) {
        System.out.println("监听器实现类中实现......");
        de.say();//回调
    }
}
