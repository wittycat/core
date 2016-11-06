package com.chenxun.designpattern.factory.student;



/** 
 * @author：chenxun
 * createDate：2016年11月3日 下午10:31:48 
 * Theme:
 * reference:
 * descript:
 */
public class StudentFromMysql  implements IStudent{

	@Override
	public void studentFormWhere() {
		System.out.println("Student我从Mysql库取出");
	}
	
}
