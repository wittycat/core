package com.core.design.factory.student;



/** 
 * @author：chenxun
 * createDate：2016年11月3日 下午10:31:48 
 * Theme:
 * reference:
 * descript:
 */
public class StudentFromDb2  implements IStudent{

	@Override
	public void studentFormWhere() {
		System.out.println("Student我从Db2库取出");
	}
	
}
