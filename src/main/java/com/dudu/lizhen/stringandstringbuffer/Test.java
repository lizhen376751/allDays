package com.dudu.lizhen.stringandstringbuffer;

/**
 * 主要用于测试String和StringBuffer的区别
 * Created by lizhen on 2017/12/11.
 */
public class Test {

    public static void main(String args[]) {

        String str = "abc";
        StringBuffer sb = new StringBuffer("abc");
        Runtime runtime = Runtime.getRuntime();
        long start = System.currentTimeMillis();
        long startFreememory = runtime.freeMemory();
        for (int i = 0; i < 10000; i++) {
            str += i;
            //测试StringBuffer时候把注释打开
//            sb.append(i);
        }
        long endFreememory = runtime.freeMemory();
        long end = System.currentTimeMillis();
        System.out.println("操作耗时:" + (end - start) + "ms," + "内存消耗:"
                + (startFreememory - endFreememory)/1024 + "KB");

        /**
         * 使用String做10000次向一字符串后添加字符串
         * 操作耗时:1872ms,内存消耗:1301KB
         *
         * 使用StringBuffer做10000次向一字符串后添加字符串
         * 操作耗时:15ms,内存消耗:162KB
         */
    }

}
