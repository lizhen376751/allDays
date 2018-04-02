package com.dudu.lizhen.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2017/12/15.
 */
public class Thread1 {

    public static void main(String[] args) throws InterruptedException {
        ThreadTest[] threadTests = new ThreadTest[10];
        for (int i = 0; i < 10; i++) {
            threadTests[i] = new ThreadTest();
        }
        for (ThreadTest threadTest : threadTests) {
            threadTest.start();
        }


    }
}

class ThreadTest extends Thread {

    //    public static int conut = 0;
    public static AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            atomicInteger.addAndGet(1);
        }
        System.out.println(currentThread().getName() + "------conut:" + atomicInteger.get());
    }

}
