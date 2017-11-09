package com.dudu.lizhen.javaDesign.watcher;

/**
 * 观察者模式
 * 观察者
 * Created by lizhen on 2017/10/25.
 */
public class Watcher implements java.util.Observer {
    public void update(java.util.Observable obj, Object arg) {
        System.out.println("Update() called, count is "
                + ((Integer) arg).intValue());
    }


}
