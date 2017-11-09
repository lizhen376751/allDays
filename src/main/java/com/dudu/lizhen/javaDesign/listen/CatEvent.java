package com.dudu.lizhen.javaDesign.listen;

/**
 * CatEvent(事件，在其内部可拿到事件源对象)
 * Created by lizhen on 2017/10/25.
 */
public class CatEvent {

    /**
     * 属性猫
     */
    private Cat cat;

    /**
     * 构造函数
     * @param cat
     */
    public CatEvent(Cat cat) {
        super();
        this.cat = cat;
    }

    /**
     * 事件
     * @return
     */
    public Object getSource(){
        return cat;
    }

}
