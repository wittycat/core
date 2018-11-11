package com.core.word.constructed;
/** 
 * @author：chenxun
 * 创建时间：2016年6月11日 下午7:37:10 
 * 参考：
 * 说明：
 */
public class Son extends Fu {
    
	static{
		System.out.println("Son 的static 代码块");
	}
	
	{
		System.out.println("Son 的非static 代码块");
	}
	
	private static String name;

	public Son() {
		//(name);
		System.out.println("Son 无惨构造函数");
	}

	public Son(String name) {
		super();
		System.out.println("Son 的有惨构造函数");
	}

}
