package com.dudu.lizhen.timetask;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时任务====TimeTask
 * Created by lizhen on 2018/4/9 0009.
 */
public class TimeTask002 {
    public static int i= 0;
    public static void main(String[] args) {
        //执行任务代码
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("我是定时任务："+ ++i);
            }
        };
        Timer timer = new Timer();
        //天数
        long day = 0;
        //秒数
        long mili = 1000;
        timer.schedule(timerTask,day,mili);
    }
}
