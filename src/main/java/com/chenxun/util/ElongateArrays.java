package com.chenxun.util;

import java.util.Arrays;

import org.junit.Test;

/** 
 * @author：chenxun
 * 创建时间：2016年5月29日 下午10:39:03 
 * 参考：
 * 说明：ElongateArrays变长数组，若有必要使用变长数组Arrays.copyOf(array, size);
 */
public class ElongateArrays {
	
   @Test
   public void testElongateArrays() {
		String[] array = new String[2];
		array[0] = "0";
		array[1] = "1";
		System.out.println("数组长度=" + array.length + "/element0=" + array[0]
				+ "/element1=" + array[1]);
		array = Arrays.copyOf(array, 4);
		System.out.println("数组长度=" + array.length + "/element0=" + array[0]
				+ "/element1=" + array[1] + "/element2=" + array[2]);
  }
}
