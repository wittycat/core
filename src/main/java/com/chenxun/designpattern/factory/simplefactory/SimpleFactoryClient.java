package com.chenxun.designpattern.factory.simplefactory;


/** 
 * @author：chenxun
 * createDate：2016年11月3日 下午9:56:05 
 * Theme:简单工厂
 * reference:
 * descript:
 * 服务端材料：一个工厂，一套抽象标准，实现了标准的一些类（根据标准可以继续扩展其他类）
 * 客户端：创建工厂，根据条件从工厂获取所需要的实现类
 */
public class SimpleFactoryClient {
	
	public static void main(String[] args) {
		new StudentSimpleFactory().createStudent("Db2").studentFormWhere();
		new StudentSimpleFactory().createStudent("Mysql").studentFormWhere();
	}
}