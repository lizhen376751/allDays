package NIO;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 *
 * Created by lizhen on 2018/3/6.
 */
public class Test003 {

    /**
     * 直接缓冲区
     * @throws IOException
     */
    @Test
    public void test002() throws IOException {
        long currentTimeMillis = System.currentTimeMillis();
        //创建管道
        FileChannel inputChannel = FileChannel.open(Paths.get("F:\\1.MP4"), StandardOpenOption.READ);
        FileChannel outputChannel = FileChannel.open(Paths.get("F:\\2.MP4"), StandardOpenOption.READ,StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        //定义映射文件
        MappedByteBuffer inputmap = inputChannel.map(FileChannel.MapMode.READ_ONLY, 0, inputChannel.size());
        MappedByteBuffer outmap = outputChannel.map(FileChannel.MapMode.READ_WRITE, 0, inputChannel.size());
        //直接对缓冲区进行操作
        byte[] bytes = new byte[inputmap.limit()];
        inputmap.get(bytes);
        outmap.put(bytes);
        inputChannel.close();
        outputChannel.close();
        long currentTimeMillis1 = System.currentTimeMillis();
        long l = currentTimeMillis1 - currentTimeMillis;
        System.out.println("操作直接缓冲区成功!!!!操作时间:"+l);
    }

    /**
     * 非直接缓冲区,读写操作
     * @throws IOException
     */
    @Test
    public void test001() throws IOException {
        long currentTimeMillis = System.currentTimeMillis();
        //读入流
        FileInputStream fileInputStream = new FileInputStream("F:\\1.MP4");
        //写入流
        FileOutputStream fileOutputStream = new FileOutputStream("F:\\2.MP4");
        //创建通道
        FileChannel inputchannel = fileInputStream.getChannel();
        FileChannel outputchannel = fileOutputStream.getChannel();
        //分配制定大小缓冲区
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        while (inputchannel.read(allocate) != -1) {
            //开启读取模式
            allocate.flip();
            //将数据写入到通道中
            outputchannel.write(allocate);
            //清空缓冲区
            allocate.clear();
        }
        //关闭通道,关闭流
        inputchannel.close();
        outputchannel.close();
        fileInputStream.close();
        fileOutputStream.close();
        long currentTimeMillis1 = System.currentTimeMillis();
        long l = currentTimeMillis1 - currentTimeMillis;
        System.out.println("操作非直接缓冲区成功!!!!操作时间"+l);
    }

}
