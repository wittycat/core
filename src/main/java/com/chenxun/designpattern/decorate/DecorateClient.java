package com.chenxun.designpattern.decorate;

import org.junit.Test;

/** 
 * @author：chenxun
 * 创建时间：2016年9月25日 上午12:16:32 
 * 参考：
 * 说明：装饰者 ,和装饰者一样的功能还有继承，和动态代理
 *      继承必须全部实现接口的方法不好,装饰者和动态代理比较灵活,有针对的实现
 * 
 */
public class DecorateClient {
	@Test
	public void myTest() {
		new Decorate(new OriginalClass()).say();
	}
}
