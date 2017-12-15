package com.dudu.lizhen.thiread;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程测试
 * Created by lizhen on 2017/12/15.
 */
public class TestThread {
    private static MyThread myThread = new MyThread("线程1");
    private static Thread thread = new Thread(myThread);

    public void sss() {
        Thread.State state = thread.getState();
        System.out.println("当前线程状态:" + state.toString());

        if (state.toString().equals("TERMINATED")) {
            myThread = new MyThread("线程2");
            thread = new Thread(myThread);
            state = thread.getState();
            System.out.println("当前线程2状态:" + state.toString());
            thread.start();
            state = thread.getState();
            System.out.println("当前线程2状态:" + state.toString());
        } else if (!state.toString().equals("RUNNABLE")) {
            thread.start();
        } else {
            System.out.println("当前运行状态不可操作....");
        }

    }

    public static void main(String[] arg) {
        TestThread testThread1 = new TestThread();
        //创建定时器对象
        Timer t = new Timer();
        testThread1.sss();
        testThread1.sss();
        //在3秒后执行MyTask类中的run方法
        t.schedule(new MyTask(testThread1), 3000);
        ThreadPoolExecutorTest.threadPool();
    }


}

/**
 * 定时器
 */
class MyTask extends TimerTask {
    private static TestThread testThread1;

    public MyTask(TestThread testThread1) {
        this.testThread1 = testThread1;
    }

    @Override
    public void run() {
        testThread1.sss();
    }
}

/**
 * 线程池
 */
class ThreadPoolExecutorTest {
    public static void threadPool() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
