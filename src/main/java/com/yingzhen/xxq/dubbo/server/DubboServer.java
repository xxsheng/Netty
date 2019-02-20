/**
 * 
 */
package com.yingzhen.xxq.dubbo.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/**
 * Dubbo 生产者服务端
 * @author IGEN
 *
 */
public class DubboServer {

	private int port;
	
	public DubboServer(int port) {
		this.port = port;
	}
	
	public void run ()throws Exception{
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			ServerBootstrap bootstrap = new ServerBootstrap();
			
			bootstrap
			.group(group)
			.channel(NioServerSocketChannel.class)
			.childHandler(new ChannelInitializer<SocketChannel>() {

				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					// TODO Auto-generated method stub
					ch.pipeline().addLast(new ObjectDecoder(1024*1024, ClassResolvers.weakCachingConcurrentResolver(this.getClass().getClassLoader())));
					ch.pipeline().addLast(new ObjectEncoder());
					ch.pipeline().addLast(new DubboServerHandler());
				}
			})
			.option(ChannelOption.SO_BACKLOG, 128)
			.childOption(ChannelOption.SO_KEEPALIVE, true);
			
			//Bind and start to accept incomint connections
			ChannelFuture f = bootstrap.bind(port).sync();
			
			f.channel().closeFuture().sync();
		}finally {
			
			group.shutdownGracefully();
		}
	}
	
	public static void main(String[] args) throws Exception {
		new DubboServer(8080).run();;
	}
}
