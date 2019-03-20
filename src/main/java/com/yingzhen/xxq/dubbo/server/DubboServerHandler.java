/**
 * 
 */
package com.yingzhen.xxq.dubbo.server;

import java.lang.reflect.Method;

import com.yingzhen.xxq.facade.api.DubboRequest;
import com.yingzhen.xxq.facade.api.IUserFacade;
import com.yingzhen.xxq.facade.api.impl.IUserFacadeImpl;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * netty-dubbo 服务端拦截器
 * @author IGEN
 *
 */
public class DubboServerHandler extends ChannelInboundHandlerAdapter{

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("服务端收到消息：" + msg);
		DubboRequest req = (DubboRequest) msg;
		// 1. 根据类名返回对象
		Object target = this.getInstanceByInterfaceClass(req.getInterfaceClass());
		
		// 2. 获取方法名
		String methodName = req.getMethodName();
		
		// 3. 获取方法参数类型
		// 4. 获取方法
		Method method = target.getClass().getMethod(methodName, req.getParamTypes());
		
		// 5. 获取参数值
		// 调用方法 获取返回值
		if(method.getReturnType().getName() ==void.class.getName()) {
			System.out.println("---------------");
		}
		Object res = method.invoke(target, req.getArgs());
		
		if(res != null){
			//返回给调用者
			ctx.write(res);
		}else {
			return;
		}
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		super.exceptionCaught(ctx, cause);
	}

	
	/**
	 * 根据接口返回对应的实列
	 * @param clazz
	 * @return
	 */
	private Object getInstanceByInterfaceClass(Class<?> clazz) {
		if (IUserFacade.class.equals(clazz)) {
			return new IUserFacadeImpl();
		}
		return null;
	}
}
