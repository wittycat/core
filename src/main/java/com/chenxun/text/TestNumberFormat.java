package com.chenxun.text;

import java.text.NumberFormat;

import org.junit.Test;

/** 
 * @author：chenxun
 * 创建时间：2016年6月10日 下午10:53:10 
 * 参考：
 * 说明：
 */
public class TestNumberFormat {
	
   @Test
   public void method() {
	   String value = NumberFormat.getCurrencyInstance().format(100D);
	   String percent = NumberFormat.getPercentInstance().format(0.2D);
	   
	   System.out.println(value);//￥100.00
	   System.out.println(percent);//20%
	   

   }
}
