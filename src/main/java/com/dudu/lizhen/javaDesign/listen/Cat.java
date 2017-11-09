package com.dudu.lizhen.javaDesign.listen;

/**
 * 监听者模式
 * Cat（事件源，被观察者）
 * Created by lizhen on 2017/10/25.
 */
public class Cat {

    private String name;
    private CatListener cl;

    /**
     * 构造函数
     * @param name
     */
    public Cat(String name) {
        super();
        this.name = name;
    }


    public String getName() {
        return name;
    }


    /**
     * 具体的事件
     */
    public void climb(){
        System.out.println(name+" is climb...");
        if(cl!=null){
            cl.help(new CatEvent(this));
        }
    }

    /**
     * 添加监听者
     * @param cl
     */
    public void addCatListener(CatListener cl){
        this.cl = cl;
    }
}
