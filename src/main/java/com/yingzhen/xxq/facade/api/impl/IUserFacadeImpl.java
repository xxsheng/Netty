/**
 * 
 */
package com.yingzhen.xxq.facade.api.impl;

import com.yingzhen.xxq.facade.api.IUserFacade;

/**
 * dubbo 服务端实现类
 * @author IGEN
 *
 */
public class IUserFacadeImpl implements IUserFacade {

	/* (non-Javadoc)
	 * @see com.yingzhen.xxq.facade.api.IUserFacade#getUserName(java.lang.Long)
	 */
	@Override
	public String getUserName(Long id) {
		// TODO Auto-generated method stub
		return "dubbo is" + id;
	}

}
