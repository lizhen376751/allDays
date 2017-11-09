package com.dudu.lizhen.javaDesign.watcher;

/**
 * 测试
 * Created by lizhen on 2017/10/25.
 */
public class ObserverDemo {
    /**
     * 观察者模式的思路剖析
     * 1.Watcher 作为观察者
     * 2.BeingWatched 作为被观察者
     * 3.BeingWatched进入方法,两者都继承了一个什么东西,然后将BeingWatched的相关参数传入
     * 4.Watcher有一个固定的方法用来进行变化
     */

    public static void main(String[] args) {
        BeingWatched beingWatched = new BeingWatched();//被观查者
        Watcher watcher = new Watcher();//观察者
        beingWatched.addObserver(watcher);
        beingWatched.counter(10);
    }
}
