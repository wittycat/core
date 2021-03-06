package com.core.design.factory.abstractfactory;

import com.core.design.factory.classs.ClassFromDb2;
import com.core.design.factory.classs.IClass;
import com.core.design.factory.student.IStudent;
import com.core.design.factory.student.StudentFromDb2;

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
