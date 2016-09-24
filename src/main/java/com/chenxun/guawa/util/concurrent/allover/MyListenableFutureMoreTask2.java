package com.chenxun.guawa.util.concurrent.allover;

import java.util.Random;
import java.util.concurrent.Callable;

import com.google.common.util.concurrent.ListenableFuture;

public class MyListenableFutureMoreTask2 extends ThreadPool {
	
	public ListenableFuture<Integer>  start() {
		ListenableFuture<Integer>  explosion = service.submit( MyTask());
		return explosion;
	}
	private  Callable<Integer> MyTask() {
		return new Callable<Integer>() {
		  public Integer call() {
			System.out.println("call开始："+Thread.currentThread().getName());
			try {
				Thread.sleep(2000L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    return new Random().nextInt(100);
		  }
		};
	}
	
}
