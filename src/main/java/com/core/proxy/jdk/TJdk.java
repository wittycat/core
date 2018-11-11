package com.core.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.junit.Test;

import com.core.proxy.IEat;
import com.core.proxy.IEatImpl;

/** 
 * @author：chenxun
 * 创建时间：2016年9月11日 下午6:26:09 
 * 参考：
 * 说明：
 */
public class TJdk {
	@Test
	public void test(){
		ClassLoader loader = getClass().getClassLoader();
		@SuppressWarnings("rawtypes")
		Class[] interfaces = {IEat.class};
		InvocationHandler h = new InvocationHandlerEat(new IEatImpl());
		IEat newProxyInstance = (IEat) Proxy.newProxyInstance(loader, interfaces, h);
		newProxyInstance.eat();
	}
}
