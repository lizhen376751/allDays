package com.dudu.lizhen.timetask;

/**
 * 定时任务----Thread
 * Created by lizhen on 2018/4/9 0009.
 */
public class TimeTask001 {
    public static int i = 0;
    public static void main(String[] args) {

        new Thread(new Runnable() {

            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("我是定时任务："+ ++i);
                }

            }
        }).start();
    }
}
