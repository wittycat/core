package com.chenxun.designpattern.factory.simplefactory;

import com.chenxun.designpattern.factory.student.IStudent;
import com.chenxun.designpattern.factory.student.StudentFromDb2;
import com.chenxun.designpattern.factory.student.StudentFromMysql;


/** 
 * @author：chenxun
 * createDate：2016年11月3日 下午10:29:45 
 * Theme:
 * reference:
 * descript:
 */
public class StudentSimpleFactory {
	public StudentSimpleFactory() {
	}

	public IStudent createStudent(String type) {
		IStudent studnt = null ;
		switch (type) {
		case "Db2":
			studnt = new StudentFromDb2();
			break;
		case "Mysql":
			studnt = new StudentFromMysql();
			break;
		default:
			break;
		}
      return studnt;
	}
}
