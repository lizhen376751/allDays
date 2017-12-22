package com.dudu.lizhen.exception;

/**
 * 自定义异常
 * Created by lizhen on 2017/12/22.
 */
public  class  ExceptionTest{
    public static void main(String[] args) {
        try {
            throw new MyException("你长得好丑!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
 class MyException extends Exception {
    public  MyException(String msg){
        super(msg);
    }
}
