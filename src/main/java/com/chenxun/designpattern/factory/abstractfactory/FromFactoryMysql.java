package com.chenxun.designpattern.factory.abstractfactory;

import com.chenxun.designpattern.factory.classs.ClassFromMysql;
import com.chenxun.designpattern.factory.classs.IClass;
import com.chenxun.designpattern.factory.student.IStudent;
import com.chenxun.designpattern.factory.student.StudentFromMysql;

/** 
 * @author：chenxun
 * createDate：2016年11月6日 上午12:04:20 
 * Theme:
 * reference:
 * descript:
 */
public class FromFactoryMysql implements IFromFactory{

	@Override
	public IStudent getStudent() {
		return new StudentFromMysql();
	}

	@Override
	public IClass getClasss() {
		return new ClassFromMysql();
	}

}
