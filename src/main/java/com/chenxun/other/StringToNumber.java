package com.chenxun.other;

/**
 *
 * @author chenxun
 * @date 2017年2月16日 下午3:14:00
 *
 */
public class StringToNumber {
	
	
	public static void main(String[] args) {
		
//		System.out.println(StingToNumber("123"));
		
		printCharUionNum();
		
	}

    /**
     * 小于33，或大于126的不属于常见字符
     */
	public static void printCharUionNum() {
		for (int i = 33; i < 126; i++) {
			System.out.println((char)i+":"+i);
		}
	}
	
	
	/**
	 * 
	 * 仿照Integer.parseInt()的功能 ， 转化的基本思路
	 * 1. Character 类是char 的包装类型 
	 * 2. charAt(index)  根据索引取出字符串中的字符
	 * 3. Character.digit(c, radix)的方法可以把一个字符转化为数字;
	 *    char类型也属于特殊的int ，一个char对应一个int ，可以直接进行强转； 
	 *    digit(c,radix)里面就是直接强转的。
	 * 异常，校验未处理
	 */
	public static int StingToNumber(String num) {
		int length = num.length();
		int radix = 10;
		int digit = 0;
		int r = 0;
		for (int i = 0; i < length; i++) {
			char c = num.charAt(i);
			// System.out.println((int)c-48);
			digit = Character.digit(c, radix);
			r = (r + digit) * (i == (length - 1) ? 1 : 10);
		}
		return r;
	}
}
