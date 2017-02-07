package com.chenxun.word;

import org.junit.Test;

/** 
 * @author：chenxun
 * 创建时间：2016年6月11日 下午3:39:16 
 * 参考：
 * 说明：final只能被赋值一次（也就是只能初始化一次）
 */
public class TFinal {

	public final String s1 = "aaa";
	
	@Test
	public void  method() {
        System.out.println(s1);
        //s1 = "bbb";          final 不能被修改
        System.out.println(s1);
	}

}
