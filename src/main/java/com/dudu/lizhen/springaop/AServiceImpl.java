package com.dudu.lizhen.springaop;

// 使用jdk动态代理
public class AServiceImpl{

    public void barA() {
        System.out.println("AServiceImpl.barA()");
    }

    public void fooA(String _msg) {
        System.out.println("AServiceImpl.fooA(msg:" + _msg + ")");
    }
}