package com.core.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/** 
 * @author：chenxun
 * 创建时间：2016年9月11日 下午11:47:05 
 * 参考：
 * 说明：
 */
public class CglibProxyEat implements MethodInterceptor{
	
	Enhancer enhancer = new Enhancer();  
	
	public  Object getCglibEatProxy(Class clazz) {
        enhancer.setSuperclass(clazz);  
        enhancer.setCallback(this);
        return  enhancer.create();
	}



	@Override
	public Object intercept(Object object, Method method, Object[] objects,
			MethodProxy methodProxy) throws Throwable {
		System.out.println("来点水果");
		methodProxy.invokeSuper(object, objects);
		System.out.println("漱口");
		return null;
	}

}
