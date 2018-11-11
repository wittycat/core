package com.core.design.factory.simplefactory;

import com.core.design.factory.student.IStudent;
import com.core.design.factory.student.StudentFromDb2;
import com.core.design.factory.student.StudentFromMysql;


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
