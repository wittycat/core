package com.core.design.factory.abstractfactory;

import com.core.design.factory.classs.ClassFromMysql;
import com.core.design.factory.classs.IClass;
import com.core.design.factory.student.IStudent;
import com.core.design.factory.student.StudentFromMysql;

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
