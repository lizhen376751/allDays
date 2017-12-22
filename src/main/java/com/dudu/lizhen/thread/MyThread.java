package com.dudu.lizhen.thread;

/**
 * Created by Administrator on 2017/12/15.
 */
public class MyThread implements Runnable {
    private String threadName;

    public MyThread(String threadName){
        this.threadName = threadName;
    }
    @Override
    public void run() {
        System.out.println("我正在执行同步方法"+threadName);
    }
}
