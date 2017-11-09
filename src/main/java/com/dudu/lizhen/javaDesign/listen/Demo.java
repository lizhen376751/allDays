package com.dudu.lizhen.javaDesign.listen;

/**
 * Cat（事件源，被观察者）
 * CatListener(监听者)
 * CatEvent(事件，在其内部可拿到事件源对象)
 * Created by lizhen on 2017/10/25.
 */
public class Demo {
    //监听者模式整体的设计思路

    //1.cat做为被监听者
    //2.CatListener作为被监听者
    //3.cat添加监听者
    //4.cat做某些事情,然后调用CatListener(接口)做某些事情
    //5.借助中介CatEvent,获取监听者的某些数据

    public static void main(String[] args) {
        Cat cat = new Cat("小黑");
        Cat cat2 = new Cat("小白");

        CatListener cl = new CatListener() {
            @Override
            public void help(CatEvent ce) {
                Cat cat2 = (Cat) ce.getSource();
                if(cat2.getName().equals("小黑")){
                    System.out.println("你好啊...");
                }
            }
        };

        cat.addCatListener(cl);
        cat2.addCatListener(cl);
        cat.climb(); //输入猫的姓名
        System.out.println("--------------");
        cat2.climb();
    }
}
