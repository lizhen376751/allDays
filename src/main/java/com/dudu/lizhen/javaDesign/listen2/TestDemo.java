package com.dudu.lizhen.javaDesign.listen2;

/**
 * 测试代码
 * Created by lizhen on 2017/10/25.
 */
public class TestDemo {
    /**
     * 监听者模式的思路
     * 1.一个被监听者,一个(或者多个)监听者
     * 2.被监听者添加监听者(监听者是一个接口,具体的实现可以多种方法)
     * 3.原因:(1.解耦)(2.传入的参数相同,可以进行不同的实现,如果确定只做一件事情,可以不用接口,直接去实现)
     * 4.监听者实现的时候需要将事件源传入进来,
     */

    DemoSource ds;
    public TestDemo(){
        try{
            ds = new DemoSource();
            //将监听器在事件源对象中登记：
            DemoListener1 listener1 = new DemoListener1();
            ds.addDemoListener(listener1);
            ds.addDemoListener(new DemoListener() {
                public void handleEvent(DemoEvent event) {
                    System.out.println("创建监听者接口类,并且重写里面的方法");
                }
            });
            ds.notifyDemoEvent();//触发事件、通知监听器
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new TestDemo();
    }
}
