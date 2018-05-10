package com.dudu.lizhen.zookeepertest.zklock;

import org.I0Itec.zkclient.ZkClient;

import java.util.concurrent.CountDownLatch;

/**
 * 重构ZKLock，将重复代码
 * Created by lizhen on 2018/4/13 0013.
 */
public abstract class ZKLockImplement implements ZKLock {
    //ZK连接地址
    public static final String CONNECTADDRESS = "127.0.0.1:2181";

    //创建ZK连接
    public  ZkClient zkClient = new ZkClient(CONNECTADDRESS);

    //zk创建的节点
    public static final String PATH = "/pathlock";

    //信号量
    public static CountDownLatch countDownLatch = null;

    //是否获取锁成功，如果成功返回true，失败的话返回false
    abstract Boolean tryLock();

    //等待获取锁
    abstract Boolean waitLock();

    @Override
    public void getlock() {
        if (tryLock()) {
            System.out.println(Thread.currentThread().getName()+"========================获取锁成功=================================");
        } else {
            //等待
            waitLock();
            //重新获取锁
            getlock();
        }
    }

    //释放锁
    @Override
    public void unLock() {
        //关闭连接时首先判断zkclient是否为空，不为空的话在关闭
        if (null != zkClient) {
            zkClient.close();
            System.out.println(Thread.currentThread().getName()+"========================释放锁资源===========================");
            System.out.println();
        }
    }
}
