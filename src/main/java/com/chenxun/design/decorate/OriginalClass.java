package com.chenxun.design.decorate;


/** 
 * @author：chenxun
 * createDate：2016年11月3日 下午10:38:02 
 * Theme:
 * reference:
 * descript:
 */
public class OriginalClass implements Standard{
	@Override
	public void say() {
		System.out.println("原方法...");
	}
}
