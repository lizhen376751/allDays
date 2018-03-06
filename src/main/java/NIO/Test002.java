package NIO;

import java.nio.ByteBuffer;

/**
 * Created by lizhen on 2018/3/5.
 */
public class Test002 {
    public static void main(String[] args) {
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        allocate.put("LiZhen".getBytes());
        //开启读取模式
        allocate.flip();
        byte[] bytes = new byte[allocate.limit()];
        allocate.get(bytes, 0, 2);
        System.out.println("标记前指针位置:" + allocate.position());
        System.out.println("标记前获取缓冲数据:" + new String(bytes, 0, 2));
        //标记位置
        allocate.mark();
        allocate.get(bytes, 2, 2);
        System.out.println("标记后指针位置:" + allocate.position());
        System.out.println("标记后获取缓冲数据:" + new String(bytes, 0, 2));

        //还原位置
        allocate.reset();
        System.out.println("位置还原后指针位置:" + allocate.position());
    }
}
