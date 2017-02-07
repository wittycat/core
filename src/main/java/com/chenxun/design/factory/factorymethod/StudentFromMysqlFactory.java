package com.chenxun.design.factory.factorymethod;

import com.chenxun.design.factory.student.IStudent;
import com.chenxun.design.factory.student.StudentFromMysql;

/** 
 * @author：chenxun
 * createDate：2016年11月5日 下午8:10:49 
 * Theme:
 * reference:
 * descript:
 */
public class StudentFromMysqlFactory implements IStudentFactory {

	@Override
	public IStudent getStudent() {
		return new StudentFromMysql();
	}

}
