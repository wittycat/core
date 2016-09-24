package com.chenxun.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author：chenxun 创建时间：2016年6月2日 下午10:42:11 参考： 说明：
 */
public class FutureCallable implements Callable<Integer> {
	private int money;

	public FutureCallable(int money) {
		this.money = money;
	}

	public Integer call() throws Exception {
		TimeUnit.MILLISECONDS.sleep(10000);
		return money / 10;
	}

}
