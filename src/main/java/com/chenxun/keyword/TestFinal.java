package com.chenxun.keyword;

import org.junit.Test;

/** 
 * @author：chenxun
 * 创建时间：2016年6月11日 下午3:39:16 
 * 参考：
 * 说明：
 */
public class TestFinal {

	public final String s1 = "aaa";
	
	@Test
	public void  method() {
        System.out.println(s1);
        //s1 = "bbb";          final 不能被修改
        System.out.println(s1);
	}

}
