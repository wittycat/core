package com.chenxun.design.factory.abstractfactory;
/** 
 * @author：chenxun
 * createDate：2016年11月6日 上午12:14:45 
 * Theme:
 * reference:
 * descript:
 */
public class IFromFactoryClient {
	public static void main(String[] args) {
		IFromFactory iFromFactory = new FromFactoryDb2();
		iFromFactory.getClasss().classFormWhere();
		iFromFactory.getStudent().studentFormWhere();
	}
}
