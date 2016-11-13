package com.chenxun.designpattern.decorate.example;
/** 
 * @author：chenxun
 * createDate：2016年11月8日 下午11:58:24 
 * Theme:
 * reference:
 * descript:这个应该不是装饰者  因为没有对run() 方法扩展
 */
public class MyThreadClient {
	public static void main(String[] args) {
		Runnable target = new MyThread();
		Thread thread = new Thread(target);
		thread.start();
	}
}
