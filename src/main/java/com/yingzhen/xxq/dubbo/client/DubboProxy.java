/**
 * 
 */
package com.yingzhen.xxq.dubbo.client;

import java.lang.reflect.Proxy;

/**
 * Dubbo 代理类
 * @author IGEN
 *
 */
public class DubboProxy {

	public static <T> T getProxyInstance(Class<T> clazz) {
		
		return clazz.cast(Proxy.newProxyInstance(clazz.getClassLoader(), new Class[] {clazz}, new DubboConsumeHandler()));
	}
}
