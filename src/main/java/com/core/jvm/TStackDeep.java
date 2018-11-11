package com.core.jvm;
/** 
 * @author：chenxun
 * createDate：2016年11月19日 下午3:13:58 
 * Theme:
 * reference:
 * descript:StackOverflowError
 * -Xms20M -Xmx20M -Xss1M -XX:+HeapDumpOnOutOfMemoryError
 */
public class TStackDeep {
	private static int threadStackDeep;
	public static void main(String[] args) throws InterruptedException {
		//栈深度      
		//11484  :不创建的对象             StackOverflowError
		//2      :创建对象10M的对象     OutOfMemoryError
		//4      :创建对象5M的对象        OutOfMemoryError
		method();
	}
	
	private static void method(){
		threadStackDeep++;
		System.out.println(threadStackDeep);
		byte[] G_1 = new byte[1024*1024*5];
		method();
	}

}
