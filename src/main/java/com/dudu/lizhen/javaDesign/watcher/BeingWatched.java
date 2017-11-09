package com.dudu.lizhen.javaDesign.watcher;

/**
 * 被观察者模式
 * 被观察者
 * Created by lizhen on 2017/10/25.
 */
public class BeingWatched extends java.util.Observable {
    void counter(int period) {
        for(; period>=0; period-- ) {
            setChanged();
            notifyObservers(new Integer(period));
            try {
                Thread.sleep(100);
            } catch( InterruptedException e) {
                System.out.println("Sleep interrupeted" );
            }
        }
    }
};
