package com.core.word;

import org.junit.Test;

/** 
 * @author：chenxun
 * 创建时间：2016年6月11日 下午3:39:16 
 * 参考：
 * 说明：
 */
public class TStatic {

	public static String s1 = "aaa";
	
	@Test
	public void  method() {
        System.out.println(s1);
        s1 = "bbb";//值能修改        static 单独 防止多个方法引用的值不一样，所以建议 static和final 一块连用
        System.out.println(s1);
	}

}
