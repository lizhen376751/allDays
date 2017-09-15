package com.dudu.lizhen.test;

import java.util.Date;

/**
 * Created by Administrator on 2017/9/13.
 */
public class ConcreteWatcher implements Watcher{
    @Override
    public void update(String str)
    {
        Date date = new Date();

        System.out.println(str +"=" +date.getTime());
    }
}
