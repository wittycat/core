package com.chenxun.designpattern.factory.factorymethod;

import com.chenxun.designpattern.factory.student.IStudent;
import com.chenxun.designpattern.factory.student.StudentFromDb2;

/** 
 * @author：chenxun
 * createDate：2016年11月5日 下午8:10:49 
 * Theme:
 * reference:
 * descript:
 */
public class StudentFromDb2Factory implements IStudentFactory {

	@Override
	public IStudent getStudent() {
		return new StudentFromDb2();
	}

}
