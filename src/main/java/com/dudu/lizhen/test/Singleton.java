package com.dudu.lizhen.test;

import java.util.Arrays;

/**
 *
 * 单例模式测试
 * Created by lizhen on 2017/9/13.
 */
public class Singleton {
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    private Singleton (){}
    public static final Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static void main(String[] args){

            int[] A = { 1 , 3 , -1 ,0 , 2 , 1 , -4 , 2 , 0 ,1,333,2,0,-30,-89};
            int start = 0;
            int end = A.length - 1;
            while(start < end){
                if(A[start] <= 0 && A[end] > 0 ){
                    int t = A[start];
                    A[start] = A[end];
                    A[end] = t;
                }
                if(A[start] > 0){
                    start++;
                }
                if(A[end] <=0){
                    end--;
                }

            }
            System.out.println(Arrays.toString(A));
        }

}

