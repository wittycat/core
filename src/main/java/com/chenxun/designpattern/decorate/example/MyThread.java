package com.chenxun.designpattern.decorate.example;
/** 
 * @author：chenxun
 * createDate：2016年11月8日 下午11:52:47 
 * Theme:
 * reference:
 * descript:
 */
public class MyThread implements Runnable {

	@Override
	public void run() {
		System.out.println("线程运行了");
	}

}
