package com.chenxun.designpattern.factory.abstractfactory;

import com.chenxun.designpattern.factory.classs.ClassFromDb2;
import com.chenxun.designpattern.factory.classs.IClass;
import com.chenxun.designpattern.factory.student.IStudent;
import com.chenxun.designpattern.factory.student.StudentFromDb2;

/** 
 * @author：chenxun
 * createDate：2016年11月6日 上午12:04:20 
 * Theme:
 * reference:
 * descript:
 */
public class FromFactoryDb2 implements IFromFactory{

	@Override
	public IStudent getStudent() {
		return new StudentFromDb2();
	}

	@Override
	public IClass getClasss() {
		return new ClassFromDb2();
	}

}
