package com.dudu.lizhen.zookeepertest;

import org.apache.zookeeper.*;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * java 操作 zookeeper
 * Created by lizhen on 2018/4/13 0013.
 */
public class ZookeeperTest001 {
    //zk连接地址
    private static String ADDRESS = "127.0.0.1:2181";
    //zk回话超时时间
    private static int SESSION_OUT = 2000;

    //创建信号量，保证建立zk连接之后，然后操作zk
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper(ADDRESS, SESSION_OUT, new Watcher() {
            //监听事件通知
            @Override
            public void process(WatchedEvent watchedEvent) {
                //获取事件状态
                Event.KeeperState state = watchedEvent.getState();
                //判断为连接状态
                if (Event.KeeperState.SyncConnected == state) {
                    //获取事件类型
                    Event.EventType type = watchedEvent.getType();
                    if (Event.EventType.None == type) {
                        System.out.println("=============zk启动连接===========");
                        countDownLatch.countDown();
                    }
                }

            }
        });
        countDownLatch.await();
        //1.创建节点，2.节点内容，3.设置权限,4.节点类型(持久节点)
//        String s = zooKeeper.create("/lizhen", "lizhen work".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        //1.创建节点，2.节点内容，3.设置权限,4.节点类型(临时节点) ZOO_EPHEMERAL
        String s = zooKeeper.create("/lizhen2", "lizhen work2".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println("======================新增节点信息：" + s);
    }
}
