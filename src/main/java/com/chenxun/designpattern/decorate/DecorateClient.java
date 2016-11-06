package com.chenxun.designpattern.decorate;


/** 
 * @author：chenxun
 * 创建时间：2016年9月25日 上午12:16:32 
 * 参考：
 * 说明：装饰者 :和装饰者一样的功能还有继承，和动态代理
 *      继承必须全部实现接口的方法不好,装饰者和动态代理比较灵活,有针对的实现
 * 优势：把需要装饰的功能从原有的类中拆除，简化原有类的复杂度，在需要的时候动态的添加一些功能
 *      这些装饰的功能可以自由按需要的顺序组合
 * 
 */
public class DecorateClient {
	public static void main(String[] args) {
		OriginalClass originalClass = new OriginalClass();
		DecorateBase decorate1 = new Decorate1();
		DecorateBase decorate2 = new Decorate2();
		
		decorate1.setStandard(originalClass);
		decorate2.setStandard(decorate1);
		
		decorate2.say();
	}
}
