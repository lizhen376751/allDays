package netty;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Netty客户端
 * Created by lizhen on 2018/3/7.
 */
public class NettyClient {
    public static void main(String[] args) {
        ClientBootstrap clientBootstrap = new ClientBootstrap();
        ExecutorService boos = Executors.newCachedThreadPool();
        ExecutorService work = Executors.newCachedThreadPool();
        //3.将线程池放入到工程当中
        clientBootstrap.setFactory(new NioClientSocketChannelFactory(boos,work));
        //4.设置管道工程
        clientBootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            //设置管道
            @Override
            public ChannelPipeline getPipeline() throws Exception {
                ChannelPipeline pipeline = Channels.pipeline();
                //传输数据的时候直接就是String类型的
                pipeline.addLast("decoder",new StringDecoder());
                pipeline.addLast("encoder",new StringEncoder());
                //设置事件监听类
                pipeline.addLast("clientHandler",new ClientHandler());

                return pipeline;
            }
        });
        //连接服务端
        ChannelFuture connect = clientBootstrap.connect(new InetSocketAddress("127.0.0.1", 8080));
        Channel channel = connect.getChannel();
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("请输入内容!!!!!");
            channel.write(scanner.next());
        }

    }
}
class ClientHandler extends SimpleChannelHandler{
    /**
     * 通道关闭的时候触发
     */
    @Override
    public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        System.out.println("channelClosed");
    }

    /**
     * 必须是连接已经建立,关闭通道的时候才会触发.
     */
    @Override
    public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        super.channelDisconnected(ctx, e);
        System.out.println("channelDisconnected");
    }

    /**
     * 捕获异常
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
        super.exceptionCaught(ctx, e);
        System.out.println("exceptionCaught");

    }

    /**
     * 接受消息
     */
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        super.messageReceived(ctx, e);
        System.out.println("客户端收到服务端消息:"+e.getMessage());
        //回复内容
//        ctx.getChannel().write("我真的好吗?");
    }
}
