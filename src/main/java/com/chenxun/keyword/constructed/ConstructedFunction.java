package com.chenxun.keyword.constructed;
/** 
 * @author：chenxun
 * 创建时间：2016年6月11日 下午7:22:52 
 * 参考：
 * 说明：
 */
public class ConstructedFunction {
	/*
	执行顺序
	Fu 的static 代码块 
	Son 的static 代码块
	Fu 的非static 代码块
	Fu 的无惨构造函数
	Son 的非static 代码块
	Son 的有惨构造函数
          注意： 1.默认子类的任何构造函数在第一行隐式（即super()）调用父类的无参构造函数
         2.如果父类没有无参构造函数，子类必须显式指定父类的其他构造函数
         3.如果父类没有任何构造函数，子类可以显式或隐式的写super()  只不过不会执行任何什么，无意义
         4.注意static代码块，在服务起来后只会在第一次执行
                                   非static代码块，会在每个实例时执行，相当于会在构造函数前插入非静态块代码的内容
	 */
	public static void main(String[] args) {
		Son son = new Son("");
		//Fu fu = new Fu();
	}
}
