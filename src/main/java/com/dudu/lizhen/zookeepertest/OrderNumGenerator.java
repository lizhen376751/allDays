package com.dudu.lizhen.zookeepertest;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 订单生成类
 * Created by lizhen on 2018/4/13 0013.
 */
public class OrderNumGenerator {
    //全局订单id
    public static int count = 0;

    public String getNumber() {
        try {
//            Thread.sleep(200);
        } catch (Exception e) {
        }
        SimpleDateFormat simpt = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        return simpt.format(new Date()) + "-" + ++count;
    }
}
