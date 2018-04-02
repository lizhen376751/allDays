package com.dudu.lizhen.reflex;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射测试
 * Created by lizhen on 2018/4/2 0002.
 */
public class ReflexTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<?> aClass = Class.forName("com.dudu.lizhen.reflex.User");

        //获取类所有的属性
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field:declaredFields){
            System.out.println(field.getName());
        }
        //获取类所有的方法
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod:declaredMethods){
            System.out.println(declaredMethod.getName());
        }
        User user = (User)aClass.newInstance();
        Field name = aClass.getDeclaredField("name");
        //允许反射操作私有属性
        name.setAccessible(true);
        //为哪个类的这个属性赋值。
        name.set(user,"lizhen");
        Field age = aClass.getDeclaredField("age");
        age.setAccessible(true);
        age.set(user,18);
        System.out.println(user.toString());

    }
}
