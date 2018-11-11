package com.core.word.constructed;
/** 
 * @author：chenxun
 * 创建时间：2016年6月11日 下午7:36:37 
 * 参考：
 * 说明：
 */
public class Fu  {
	static{
		System.out.println("Fu 的static 代码块");
	}
	
	{
		System.out.println("Fu 的非static 代码块");
	}

	public Fu() {
		System.out.println("Fu 的无惨构造函数");
	}
	public Fu(String name) {
		System.out.println("Fu 的有惨构造函数");
	}

}
