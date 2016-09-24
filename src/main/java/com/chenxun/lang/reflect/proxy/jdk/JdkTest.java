package com.chenxun.lang.reflect.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.junit.Test;

import com.chenxun.lang.reflect.proxy.Eat;
import com.chenxun.lang.reflect.proxy.EatImpl;

/** 
 * @author：chenxun
 * 创建时间：2016年9月11日 下午6:26:09 
 * 参考：
 * 说明：
 */
public class JdkTest {
	@Test
	public void test(){
		ClassLoader loader = getClass().getClassLoader();
		@SuppressWarnings("rawtypes")
		Class[] interfaces = {Eat.class};
		InvocationHandler h = new JdkEatProxy(new EatImpl());
		Eat newProxyInstance = (Eat) Proxy.newProxyInstance(loader, interfaces, h);
		newProxyInstance.eat();
	}
}
