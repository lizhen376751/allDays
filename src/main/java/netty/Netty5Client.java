package netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

/**
 * 利用Netty5创建的客户端
 * Created by lizhen on 2018/3/7.
 */
public class Netty5Client {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("客户端已经启动....");
        // 创建负责接收客户端连接
        NioEventLoopGroup pGroup = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        b.group(pGroup).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel sc) throws Exception {
                sc.pipeline().addLast(new StringDecoder());
                sc.pipeline().addLast(new Client5Handler());
            }
        });

        ChannelFuture cf = b.connect("127.0.0.1", 8080).sync();
        cf.channel().writeAndFlush(Unpooled.wrappedBuffer("lizhe_goog_goog_stard1".getBytes()));
        cf.channel().writeAndFlush(Unpooled.wrappedBuffer("lizhe_goog_goog_stard2".getBytes()));
        cf.channel().writeAndFlush(Unpooled.wrappedBuffer("lizhe_goog_goog_stard3".getBytes()));
        cf.channel().writeAndFlush(Unpooled.wrappedBuffer("lizhe_goog_goog_stard4".getBytes()));
        cf.channel().writeAndFlush(Unpooled.wrappedBuffer("lizhe_goog_goog_stard5".getBytes()));
        // 等待客户端端口号关闭
        cf.channel().closeFuture().sync();
        pGroup.shutdownGracefully();

    }
}

class Client5Handler extends ChannelHandlerAdapter {

    /**
     * 当通道被调用,执行该方法
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 接收数据
        String value = (String) msg;
        System.out.println("client msg:" + value);
    }


}
