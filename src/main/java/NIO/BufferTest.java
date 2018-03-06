package NIO;


import org.junit.Test;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * 缓冲区可以理解为存储数据的文件,它是和IO一起联合使用的
 * 主要类型有以下几种
 * Buffer
 * ByteBuffer
 * LongBuffer
 * FloatBuffer
 * DubboBuffer
 * 唯一没有的数据类型是Boolean类型
 * Created by lizhen on 2018/3/5.
 */

public class BufferTest {
    @Test
    public void test001() {
        /**
         * 核心参数
         * private int position = 0;  缓冲区正在操作的位置 默认从0开始
         * private int limit; 缓冲区的可用大小,并不是剩余大小
         * private int capacity; 缓冲区的最大容量,一旦声明不能改变
         *
         * 核心方法
         * put() 往buffer存放数据
         * get() 获取数据
         */
        try {
            //初始化butebuffer的大小
            ByteBuffer allocate = ByteBuffer.allocate(1024);

            //将核心参数打印出来
            System.out.println("操作位置:" + allocate.position());
            System.out.println("可用大小:" + allocate.limit());
            System.out.println("最大容量" + allocate.capacity());
            allocate.put("lizhen".getBytes());
            //将核心参数打印出来
            System.out.println("操作位置:" + allocate.position());
            System.out.println("可用大小:" + allocate.limit());
            System.out.println("最大容量" + allocate.capacity());
            System.out.println("test001");
            /**
             * 开启读模式
             * 如果开启会将指针移动到0,就是重头开始读
             * 如果不开启,直接从指针6的位置开始读取,这样读取1024个字节时就会,越界
             */
            allocate.flip();
            byte[] bytes = new byte[allocate.limit()];
            ByteBuffer byteBuffer = allocate.get(bytes);
            String s = new String(bytes, 0, bytes.length);
            System.out.println("读取的数据:" + s);

            /**
             * 如果需要重复读取的话需要调用这个方法
             * 将指针也还原到0
             */
            allocate.rewind();
            byte[] bytes2 = new byte[allocate.limit()];
            ByteBuffer byteBuffer2 = allocate.get(bytes2);
            String s2 = new String(bytes2, 0, bytes2.length);
            System.out.println("读取的数据2:" + s2);

            /**
             * 调用清空缓冲数据被遗忘
             */
            allocate.clear();
            System.out.println("接着去读取" + (char) allocate.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test002() {
        System.out.println("test002");
    }

}
