package NIO;

import com.sun.org.apache.bcel.internal.generic.Select;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.*;
import java.nio.channels.*;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 * nio 客户端 自己写的没有测试
 * Created by lizhen on 2018/3/6.
 */
public class NioClient {
    public static void main(String[] args) throws IOException {
        System.out.println("socket客户端启动了............................");
        //1.创建socket通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8080));
        //2.切换异步非阻塞  jdk1.7以上才可以用
        socketChannel.configureBlocking(false);
        //3.指定缓冲区大小
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //4.切换到读取模式
        byteBuffer.flip();
        //5.向缓冲区里面存放数据
        byteBuffer.put("lizhen".getBytes());
        //6.将缓冲区里面的数据写入到管道里面
        socketChannel.write(byteBuffer);
        //7.清空缓冲区
        byteBuffer.clear();
        //8.关闭通道
        socketChannel.close();
    }

}

/**
 * NIO 服务器端,这是我自己写的,但是中间有错误
 */
class NioServer {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器端已启动.........");
        //1.创建通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //2.切换异步非阻塞  jdk1.7以上才可以用
        serverSocketChannel.configureBlocking(false);
        //3.绑定链接
        serverSocketChannel.bind(new InetSocketAddress(8080));
        //4.获取选择器
        Selector selector = Selector.open();
        //5.将通道注册到选择器中,并且监听已经接受的事件
        SelectionKey bind = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //6.轮训获取已经准备就绪的事件
        while (selector.select() > 0) {
            //7.获取当前注册到选择器的事件
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                //8.获取准备就绪事件
                SelectionKey next = iterator.next();
                //9.判断事件准备就绪,如果没有建立连接,就会先建立连接,如果已经有数据发送过来,就是真正的就绪状态
                boolean acceptable = next.isAcceptable();
                if (acceptable) {
                    //10.如果接受就绪,获取客户端链接
                    SocketChannel socketChannel = SocketChannel.open();
                    //11.设置为异步非阻塞
                    socketChannel.configureBlocking(false);
                    //12.将选择器到服务器上面
                    serverSocketChannel.register(selector, SelectionKey.OP_READ);
                } else if (next.isReadable()) {
                    //13.获取当前选择器"就绪状态"的通道
                    SocketChannel channel = (SocketChannel) next.channel();
                    //指定缓区大小
                    int len = 0;
                    ByteBuffer allocate = ByteBuffer.allocate(1024);
                    while((len = channel.read(allocate))>0){
                        //切换读取模式
                        allocate.flip();
                        System.out.println(new String(allocate.array(),0,allocate.limit()));
                        allocate.clear();
                    }

                }
            }
            iterator.remove();
        }

    }
}



//nio   异步非阻塞 一测试通过
class Client {

    public static void main(String[] args) throws IOException {
        System.out.println("客户端已经启动....");
        // 1.创建通道
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8080));
        // 2.切换异步非阻塞
        sChannel.configureBlocking(false);
        // 3.指定缓冲区大小
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        Scanner scanner=  new Scanner(System.in);
        while (scanner.hasNext()) {
            String str=scanner.next();
            byteBuffer.put((new Date().toString()+"\n"+str).getBytes());
            // 4.切换读取模式
            byteBuffer.flip();
            sChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        sChannel.close();
    }

}

// nio 服务端,已测试通过
class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器端已经启动....");
        // 1.创建通道
        ServerSocketChannel sChannel = ServerSocketChannel.open();
        // 2.切换读取模式
        sChannel.configureBlocking(false);
        // 3.绑定连接
        sChannel.bind(new InetSocketAddress(8080));
        // 4.获取选择器
        Selector selector = Selector.open();
        // 5.将通道注册到选择器 "并且指定监听接受事件"
        sChannel.register(selector, SelectionKey.OP_ACCEPT);
        // 6. 轮训式 获取选择 "已经准备就绪"的事件
        while (selector.select() > 0) {
            // 7.获取当前选择器所有注册的"选择键(已经就绪的监听事件)"
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()) {
                // 8.获取准备就绪的事件
                SelectionKey sk = it.next();
                // 9.判断具体是什么事件准备就绪
                if (sk.isAcceptable()) {
                    // 10.若"接受就绪",获取客户端连接
                    SocketChannel socketChannel = sChannel.accept();
                    // 11.设置阻塞模式
                    socketChannel.configureBlocking(false);
                    // 12.将该通道注册到服务器上
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (sk.isReadable()) {
                    // 13.获取当前选择器"就绪" 状态的通道
                    SocketChannel socketChannel = (SocketChannel) sk.channel();
                    // 14.读取数据
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    int len = 0;
                    while ((len = socketChannel.read(buf)) > 0) {
                        buf.flip();
                        System.out.println(new String(buf.array(), 0, len));
                        buf.clear();
                    }
                }
                it.remove();
            }
        }

    }
}

