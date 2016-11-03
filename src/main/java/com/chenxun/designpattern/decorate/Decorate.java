package com.chenxun.designpattern.decorate;


/** 
 * @author：chenxun
 * createDate：2016年11月3日 下午10:38:38 
 * Theme:
 * reference:
 * descript:
 */
public class Decorate implements Standard{
    
	private Standard fu;
	
	public Decorate(Standard fu) {
		super();
		this.fu = fu;
	}

	@Override
	public void say() {
		System.out.println("原装饰前...");
		fu.say();
		System.out.println("原装饰后...");
	}

}
