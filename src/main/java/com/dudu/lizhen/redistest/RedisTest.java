package com.dudu.lizhen.redistest;

import redis.clients.jedis.Jedis;

import java.util.HashMap;

/**
 * java对redis的操作
 * Created by lizhen on 2018/4/1.
 */
public class RedisTest {
    private static Jedis jedis = null;

    public static void main(String[] args) {
        jedis = new Jedis("192.168.52.128", 6379);
        jedis.auth("admin");
        setString();
        setMap();
    }

    public static void setString() {
        jedis.set("name","lizhen");
    }

    public static  void setMap(){
        HashMap hashMap = new HashMap();
        hashMap.put("lizhen","15000");
        hashMap.put("lizhen2","13000");
        jedis.hmset("lizhen666",hashMap);
    }
}
