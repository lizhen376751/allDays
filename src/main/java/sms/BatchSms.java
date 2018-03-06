package sms;

import com.dudu.lizhen.thread.Thread1;

import java.util.ArrayList;
import java.util.List;

/**
 * 给10万个人分批发送短信
 * Created by Administrator on 2018/3/2.
 */
public class BatchSms {
    public static void main(String[] args) {
        //1.初始化数据
        ArrayList<UserEntity> list = getList();
        //2.定义每个线程跑的数据
        int num = 2;
        //3.计算线程的数量
        List<List<UserEntity>> lists = ListUtils.splitList(list, num);
        for (int i=0;i<lists.size();i++) {
            List<UserEntity> userEntities = lists.get(i);
            UserThread userThread = new UserThread(userEntities);
            Thread thread = new Thread(userThread,"线程名称:"+i);
            thread.start();

        }
        //4.分配数据

        System.out.println();
    }

    static ArrayList<UserEntity> getList() {
        ArrayList list = new ArrayList();
        for (int i = 0; i < 11; i++) {
            UserEntity userEntity = new UserEntity("id:" + i, "userName:" + i);
            list.add(userEntity);
        }
        return list;
    }


}
 class UserThread implements Runnable {
    private List<UserEntity> list;

    public UserThread(List<UserEntity> list1) {
        this.list = list1;
    }

    @Override
    public void run() {
        for (UserEntity userEntity : list) {
            System.out.println(Thread.currentThread().getName()+","+userEntity.toString());
        }
    }
}