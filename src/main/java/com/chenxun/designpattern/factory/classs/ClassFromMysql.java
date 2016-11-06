package com.chenxun.designpattern.factory.classs;
/** 
 * @author：chenxun
 * createDate：2016年11月5日 下午11:27:40 
 * Theme:
 * reference:
 * descript:鸡肉
 */
public class ClassFromMysql implements IClass {

	@Override
	public void classFormWhere() {
		System.out.println("Class从Mysql取出");
	}

}
