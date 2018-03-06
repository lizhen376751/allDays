package NIO;


import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by lizhen on 2018/3/6.
 */
public class Test004 {
    public static void main(String[] args) throws IOException {
        //随机访问
        RandomAccessFile randomAccessFile = new RandomAccessFile("test.txt", "rw");
        //获取通道
        FileChannel channel = randomAccessFile.getChannel();
        //分配大小,指定缓冲区
        ByteBuffer allocate = ByteBuffer.allocate(100);
        ByteBuffer allocate1 = ByteBuffer.allocate(1024);
        //分散读取
        ByteBuffer[] byteBuffers = {allocate,allocate1};
        channel.read(byteBuffers);
        for (ByteBuffer byteBuffer :byteBuffers){
            //切换成读写模式
            byteBuffer.flip();
        }
        System.out.println(new String(byteBuffers[0].array(),0,byteBuffers[0].limit()));
        System.out.println("*******************************************");
        System.out.println(new String(byteBuffers[1].array(),0,byteBuffers[1].limit()));
        System.out.println("--------------聚集读写----------");
        RandomAccessFile rw = new RandomAccessFile("test2.txt", "rw");
        FileChannel channel1 = rw.getChannel();
        channel1.write(byteBuffers);
        channel.close();
        channel1.close();
    }
}
