/**
 * 
 */
package com.yingzhen.xxq.facade.api;

import java.io.Serializable;
import java.util.Arrays;

/**
 * dubbo 请求类
 * 
 * @author IGEN
 *
 */
public class DubboRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3392126811656620259L;

	private Class<?> interfaceClass;
	private String methodName;
	private Class<?>[] paramTypes;
	private Object[] args;

	public DubboRequest(Class<?> interfaceClass, String methodName, Class<?>[] paramTypes, Object[] args) {

		this.interfaceClass = interfaceClass;
		this.methodName = methodName;
		this.paramTypes = paramTypes;
		this.args = args;
	}

	public Class<?> getInterfaceClass() {
		return interfaceClass;
	}

	public void setInterfaceClass(Class<?> interfaceClass) {
		this.interfaceClass = interfaceClass;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Class<?>[] getParamTypes() {
		return paramTypes;
	}

	public void setParamTypes(Class<?>[] paramTypes) {
		this.paramTypes = paramTypes;
	}

	public Object[] getArgs() {
		return args;
	}

	public void setArgs(Object[] args) {
		this.args = args;
	}

	@Override
	public String toString() {
		return "DubboRequest [interfaceClass=" + interfaceClass + ", methodName=" + methodName + ", paramTypes="
				+ Arrays.toString(paramTypes) + ", args=" + Arrays.toString(args) + "]";
	}

}
