package com.core.design.factory.factorymethod;

import com.core.design.factory.student.IStudent;

/** 
 * @author：chenxun
 * createDate：2016年11月5日 下午8:13:54 
 * Theme:
 * reference:
 * descript:
 */
public class FactoryMethodClient {
   public static void main(String[] args) {
	    IStudentFactory factoryMethodServer = new StudentFromMysqlFactory();
	    IStudent student = factoryMethodServer.getStudent();
	    student.studentFormWhere();
	    new StudentFromDb2Factory().getStudent().studentFormWhere();
   }
}
