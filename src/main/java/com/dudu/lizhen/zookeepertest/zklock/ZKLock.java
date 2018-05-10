package com.dudu.lizhen.zookeepertest.zklock;

/**
 * 分布式锁
 * Created by lizhen on 2018/4/13 0013.
 */
public interface ZKLock {
    //获取锁
    void getlock();
    //释放锁
    void unLock();
}
