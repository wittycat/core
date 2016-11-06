package com.chenxun.designpattern.decorate;


/** 
 * @author：chenxun
 * createDate：2016年11月3日 下午10:38:38 
 * Theme:
 * reference:
 * descript:
 */
public class Decorate1 extends DecorateBase{

	@Override
	public void say() {
		super.say();
		System.out.println("Decorate1");
	}

}
