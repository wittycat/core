package com.chenxun.designpattern;

import org.junit.Test;

/** 
 * @author：chenxun
 * 创建时间：2016年9月25日 上午12:16:32 
 * 参考：
 * 说明：装饰者 ,和装饰者一样的还有继承，和动态代理
 *      
 *      继承必须全部实现接口的方法不好
 *      装饰者和动态代理比较灵活,有针对的实现
 * 
 */
public class TestDecker {
   
	@Test
	public void myTest() {
		Fu zi1 = new Zi1();
		Fu zi2 = new Zi2(zi1);
		zi2.say();
	}
}
interface Fu{
	public void  say();
}
class Zi1 implements Fu{

	@Override
	public void say() {
		System.out.println("执行了...");
		
	}
	
}
class Zi2 implements Fu{
    
	private Fu fu;
	
	public Zi2(Fu fu) {
		super();
		this.fu = fu;
	}

	@Override
	public void say() {
		System.out.println("执行前...");
		fu.say();
		System.out.println("执行后...");
		
	}
	
}
