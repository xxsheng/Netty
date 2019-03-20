/**
 * 
 */
package com.yingzhen.xxq.facade.api;

/**
 * dubbo api interface
 * @author IGEN
 *
 */
public interface IUserFacade {

	/**
	 * retrun username interface
	 * @param id
	 * @return
	 */
	public String getUserName(Long id);
	
	public void getPassword(String password);
	
}
