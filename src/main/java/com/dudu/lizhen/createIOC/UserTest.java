package com.dudu.lizhen.createIOC;

/**
 * 实体类测试
 * Created by lizhen on 2018/4/2 0002.
 */
public class UserTest {
    static {
        System.out.println("静态块。。。。。。");
    }
    public static void getClassName(){
        System.out.println("静态方法。。。。。。");
    }
    public UserTest(){
        System.out.println("无参构造函数。。。。。");
    }
    private String name;
    private String age;

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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
