package com.chenxun.util;

import org.junit.Test;

/** 
 * @author：chenxun
 * 创建时间：2016年6月10日 下午10:22:10 
 * 参考：
 * 说明：
 */
public class ThreeElementOperation {
    @Test
	public  void method1() {
		String s1 = String.valueOf(100);
		String s2 = String.valueOf(100.0D);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1.equals(s2));
	}
    /**
     * 三元运算符：就是if else 的简化
     * 在表达式中尽量保持：前后的类型一致
     * 若不一致则：数字类型往最高的转（和其他的表达式一样遵循：）
     *          范围小的往范围大的转
     *          不同类型的，属于是在转不了，就不转了
     */
    @Test
    public  void method2() {
    	int i = 90;
    	String s1 = String.valueOf(i<100?100:200);
    	String s2 = String.valueOf(i<100?100:200.0D);
    	System.out.println(s1);
    	System.out.println(s2);
    	System.out.println(s1.equals(s2));
    }

}
