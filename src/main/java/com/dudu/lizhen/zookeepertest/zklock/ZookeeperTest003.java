package com.dudu.lizhen.zookeepertest.zklock;

/**
 * 主要用于测试分布式锁
 * Created by lizhen on 2018/4/13 0013.
 */
public class ZookeeperTest003 implements Runnable {
    private OrderNumGenerator orderNumGenerator = new OrderNumGenerator();
    private ZKLock lock = new ZKLockTest();
    public void run() {
        getNumber();
    }
    public void getNumber() {
        try {
            lock.getlock();
            String number = orderNumGenerator.getNumber();
            System.out.println(Thread.currentThread().getName() + ",生成订单ID:" + number);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unLock();
        }
    }
    public static void main(String[] args) {
        System.out.println("####生成唯一订单号###");
//		OrderService orderService = new OrderService();
        for (int i = 0; i < 100; i++) {
            new Thread( new ZookeeperTest003()).start();
        }
    }
}
