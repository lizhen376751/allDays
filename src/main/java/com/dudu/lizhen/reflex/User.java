package com.dudu.lizhen.reflex;

/**
 * 实体类测试
 * Created by lizhen on 2018/4/2 0002.
 */
public class User {
    static {
        System.out.println("静态块。。。。。。");
    }
    public static void getClassName(){
        System.out.println("静态方法。。。。。。");
    }
    public User(){
        System.out.println("无参构造函数。。。。。");
    }
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
