package netty;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Netty服务端
 * Created by lizhen on 2018/3/7.
 */
public class NettyServer {

    public static void main(String[] args) {

        //1.创建服务对象
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        //2.创建两个线程池,一个是监控端口号,一个是监控NIO
        ExecutorService boos = Executors.newCachedThreadPool();
        ExecutorService work = Executors.newCachedThreadPool();
        //3.将线程池放入到工程当中
        serverBootstrap.setFactory(new NioServerSocketChannelFactory(boos,work));
        //4.设置管道工程
        serverBootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            //设置管道
            @Override
            public ChannelPipeline getPipeline() throws Exception {
                ChannelPipeline pipeline = Channels.pipeline();
                //传输数据的时候直接就是String类型的
                pipeline.addLast("decoder",new StringDecoder());
                pipeline.addLast("encoder",new StringEncoder());
                //设置事件监听类
                pipeline.addLast("serverHandler",new ServerHandler());

                return pipeline;
            }
        });
        //5.绑定端口号
        serverBootstrap.bind(new InetSocketAddress(8080));
        System.out.println("服务端已经启动.........");
    }
}


class ServerHandler extends SimpleChannelHandler{
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
        System.out.println("服务器端收到客户端消息:"+e.getMessage());
        //回复内容
        ctx.getChannel().write("好不好只有你自己知道!!!");
    }



}
