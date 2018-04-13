package com.dudu.lizhen.zookeepertest;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.concurrent.CountDownLatch;

/**
 * 继承ZKLockImplement，重写获取锁，和等待
 * Created by lizhen on 2018/4/13 0013.
 */
public class ZKLockTest extends ZKLockImplement {
    //创建节点，如果成功返回true，否则返回false。
    @Override
    Boolean tryLock() {
        try {
            zkClient.createEphemeral(PATH);
            return true;
        } catch (Exception e) {
            System.out.println(Thread.currentThread().getName()+"================================获取锁失败===========================");
            return false;
        }

    }

    //等待
    @Override
    Boolean waitLock() {
        //使用事件监听，如果监测到被删除在唤醒countDownLatch
        //如果创建节点失败，判断是否存在该节点
        if (zkClient.exists(PATH)) {
            IZkDataListener iZkDataListener = new IZkDataListener() {
                @Override
                public void handleDataChange(String s, Object o) throws Exception {

                }

                @Override
                public void handleDataDeleted(String s) throws Exception {
                    if (null != countDownLatch) {
                        countDownLatch.countDown();
                    }
                }
            };
            //注册节点监听信息
            zkClient.subscribeDataChanges(PATH, iZkDataListener);
            //如果存在该节点，那么就在次等待，知道事件通知之后，然后继续往下执行
            countDownLatch = new CountDownLatch(1);

            try {
                countDownLatch.await();
                //删除节点监听信息
                zkClient.unsubscribeDataChanges(PATH,iZkDataListener);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
