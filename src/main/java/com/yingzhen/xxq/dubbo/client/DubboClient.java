/**
 * 
 */
package com.yingzhen.xxq.dubbo.client;

import com.yingzhen.xxq.facade.api.IUserFacade;

/**
 * dubbo客户端(消费者)
 * @author IGEN
 *
 */
public class DubboClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IUserFacade userFacade =  DubboProxy.getProxyInstance(IUserFacade.class);
		
//		System.out.println(userFacade.getUserName(520L));
//		System.out.println(userFacade.getUserName(1314L));
//		System.out.println(userFacade.getUserName(1314520L));
		
		userFacade.getPassword("12345");
	}

}
