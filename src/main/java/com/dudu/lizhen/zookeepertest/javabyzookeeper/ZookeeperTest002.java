package com.dudu.lizhen.zookeepertest.javabyzookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * java 封装zookeeper连接
 * Created by lizhen on 2018/4/13 0013.
 */
public class ZookeeperTest002 implements Watcher {
    //zk连接地址
    private static String ADDRESS = "127.0.0.1:2181";
    //zk回话超时时间
    private static int SESSION_OUT = 2000;

    //创建信号量，保证建立zk连接之后，然后操作zk
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    ZooKeeper zooKeeper;


    //创建zk连接
    public void createZKConnection() {
        try {
            zooKeeper = new ZooKeeper(ADDRESS, SESSION_OUT, this);
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //创建持久化节点
    public boolean createChiJiuNode(String path, String value) {
        try {
            setWatch(path, true);
            String s = zooKeeper.create(path, value.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * <p>读取指定节点数据内容,byte[] getData(path<节点路径>, watcher<监视器>, stat<数据版本号>)</p>
     *
     * @param path zNode节点路径
     * @return 节点存储的值, 有值返回, 无值返回null
     */
    public String readData(String path) {
        String data = null;
        try {
            data = new String(zooKeeper.getData(path, false, null));
            System.out.println("========================读取节点信息："+data);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * <p>更新指定节点数据内容, Stat setData(path<节点路径>, data[]<节点内容>, stat<数据版本号>)</p>
     * <pre>
     *     设置某个znode上的数据时如果为-1，跳过版本检查
     * </pre>
     *
     * @param path zNode节点路径
     * @param data zNode数据内容
     * @return 更新成功返回true, 返回返回false
     */
    public boolean updateZNodeData(String path, String data) {
        try {
            setWatch(path,true);
            Stat stat = zooKeeper.setData(path, data.getBytes(), -1);
            System.out.println("==========================更新节点成功");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * <p>删除一个zMode节点, void delete(path<节点路径>, stat<数据版本号>)</p><br/>
     * <pre>
     *     说明
     *     1、版本号不一致,无法进行数据删除操作.
     *     2、如果版本号与znode的版本号不一致,将无法删除,是一种乐观加锁机制;如果将版本号设置为-1,不会去检测版本,直接删除.
     * </pre>
     *
     * @param path zNode节点路径
     * @return 删除成功返回true, 反之返回false.
     */
    public boolean deteleZNode(String path) {
        try {
            setWatch(path,true);
            zooKeeper.delete(path, -1);
            System.out.println("==========================删除节点成功");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    /**
     * <p>获取某个节点下的所有子节点,List getChildren(path<节点路径>, watcher<监视器>)该方法有多个重载</p>
     * @param path zNode节点路径
     * @return 子节点路径集合 说明,这里返回的值为节点名
     * <pre>
     *     eg.
     *     /node
     *     /node/child1
     *     /node/child2
     *     getChild( "node" )户的集合中的值为["child1","child2"]
     * </pre>
     * @throws KeeperException
     * @throws InterruptedException
     */
    public List<String> getChild( String path ){
        try{
            List<String> list=zooKeeper.getChildren( path, false );
            if(list.isEmpty()){
                System.out.println( "中没有节点" + path );
            }
            return list;
        }catch (KeeperException e) {
            System.out.println( "读取子节点数据失败,发生KeeperException! path: " + path + ", errMsg:" + e.getMessage() );
        } catch (InterruptedException e) {
            System.out.println( "读取子节点数据失败,发生InterruptedException! path: " + path
                    + ", errMsg:" + e.getMessage());
        }
        return null;
    }
    //事件通知
    @Override
    public void process(WatchedEvent watchedEvent) {
        //获取事件状态
        Event.KeeperState state = watchedEvent.getState();
        //获取到节点路径
        String path = watchedEvent.getPath();
        //获取监听事件的类型
        Event.EventType type = watchedEvent.getType();
        System.out.println("事件状态：" + state + ",节点路径：" + path + ",事件类型：" + type);
        //判断为连接状态
        if (Event.KeeperState.SyncConnected == state) {
            //
            if (Event.EventType.None == type) {
                System.out.println("=============zk启动连接事件===========");
                countDownLatch.countDown();
            }
            if (Event.EventType.NodeCreated == type) {
                System.out.println("=============zk节点创建事件===========");
            }
            if (Event.EventType.NodeDeleted == type) {
                System.out.println("=============zk节点删除事件===========");
            }
            if (Event.EventType.NodeDataChanged == type) {
                System.out.println("=============zk节点改变事件===========");
            }
            if (Event.EventType.NodeChildrenChanged == type) {
                System.out.println("=============zk子节点改变事件===========");
            }
        }

    }

    //设置监听事件
    public Stat setWatch(String path, boolean b) {
        try {
            Stat exists = zooKeeper.exists(path, b);
            return exists;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //关闭zk连接
    public void closeZkConnection() {
        if (null != zooKeeper) {
            try {
                zooKeeper.close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ZookeeperTest002 zookeeperTest002 = new ZookeeperTest002();
        zookeeperTest002.createZKConnection();
        String path = "/lizhen5";
        zookeeperTest002.createChiJiuNode(path, "lizhen5");
        zookeeperTest002.readData(path);
        zookeeperTest002.updateZNodeData(path,"lizhen5.5");
        zookeeperTest002.deteleZNode(path);
        zookeeperTest002.closeZkConnection();
    }
}
