package com.chenxun.util.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author：chenxun 创建时间：2016年6月2日 下午11:03:58 参考： 说明：
 */
public class TestFutureCallable {

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future<Integer> future = executorService.submit(new FutureCallable(1000));
		while (future.isDone()) {
			TimeUnit.MILLISECONDS.sleep(2000);
			System.out.print("在运行中，future状态：" + future.isDone());
		}
		System.out.println("运行完成，结果是" + future.get());
		executorService.shutdown();
	}
}
