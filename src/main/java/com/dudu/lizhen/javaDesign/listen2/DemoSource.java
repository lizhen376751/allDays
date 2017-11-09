package com.dudu.lizhen.javaDesign.listen2;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 1.首要定义事件源对象
 * （事件源相当于单击按钮事件当中的按钮对象、属于被监听者）：
 * Created by lizhen on 2017/10/25.
 */
public class DemoSource {
    private Vector repository = new Vector();//监听自己的监听器队列
    public DemoSource(){}

    /**
     * 添加监听者
     * @param dl
     */
    public void addDemoListener(DemoListener dl) {
        repository.addElement(dl);
    }

    /**
     * 通知所有的监听器
     */
    public void notifyDemoEvent() {
        Enumeration enum1 = repository.elements();
        while(enum1.hasMoreElements()) {
            DemoListener dl = (DemoListener)enum1.nextElement();
            dl.handleEvent(new DemoEvent(this));
        }
    }


}
