package com.chenxun.proxy.cglib;

import org.junit.Test;

import com.chenxun.proxy.EatImpl;

/** 
 * @author：chenxun
 * 创建时间：2016年9月11日 下午11:50:35 
 * 参考：
 * 说明：
 *     CGLib创建的动态代理对象性能比JDK创建的动态代理对象的性能高不少，但是CGLib在创建代理对象时所花费的时间却
 * 比JDK多得多，所以对于单例的对象，因为无需频繁创建对象，用CGLib合适，反之，使用JDK方式要更为合适一些。同时，由
 * 于CGLib由于是采用动态创建子类的方法，对于final方法，无法进行代理
 */
public class CglibTest {
	@Test
    public void test(){
		CglibEatProxy cglibEatProxy = new CglibEatProxy();
		EatImpl eat = (EatImpl) cglibEatProxy.getCglibEatProxy(EatImpl.class);
		eat.eat();
    }
}
