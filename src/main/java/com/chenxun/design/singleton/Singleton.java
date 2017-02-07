package com.chenxun.design.singleton;
/** 
 * @author：chenxun
 * createDate：2016年11月6日 上午11:27:34 
 * Theme:
 * reference:
 * descript:
 */
public class Singleton {
	//保证一个变量
	private static Singleton singleton;
	//禁止外界创建
	private Singleton() {
	}
    /**
     * 检查一+检查二就是所谓的双重加锁
     * @return
     */
	public static  Singleton getSingleton() {
		//加入这个保证如果不为null 时，无须进入同步块
		//检查一：为null进入同步锁
		if(singleton==null){
			//检查二：synchronized只在不安全的代码上添加，无须添加到方法上
			synchronized (Singleton.class) {
				//这句很重要，2个线程都通过了第一个if  一个先进来，一个后进来，不加if 就会造成2个实例
				if(singleton==null){    
					singleton = new Singleton();
				}
			}
		}
       return singleton;
	}
}
