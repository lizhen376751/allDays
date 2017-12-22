package com.dudu.lizhen.test;

/**
 * Created by Administrator on 2017/9/13.
 */
public class Test {
    public static void main(String[] args)
    {
        Watched girl = new ConcreteWatched();   //被观察者

        Watcher watcher1 = new ConcreteWatcher(); //观察者1
        Watcher watcher2 = new ConcreteWatcher(); //观察者 2
        Watcher watcher3 = new ConcreteWatcher(); //观察者 3

        girl.addWatcher(watcher1); // 添加观察者,最后是加入了一个list集合
        girl.addWatcher(watcher2);
        girl.addWatcher(watcher3);

        girl.notifyWatchers("开心");


    }

}
