package com.core.guawa.util.concurrent.listenfuture;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

public class TListenableFuture {
	
	static ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
	
	public  void start() {
		ListenableFuture<Integer> explosion = service.submit(myTask());
		Futures.addCallback(explosion, resultCallBack());
	}

	private static FutureCallback<Integer> resultCallBack() {
		return new FutureCallback<Integer>() {

			public void onSuccess(Integer result) {
				System.out.println("call结果[Integer]:"+result);
				System.out.println("call结束："+Thread.currentThread().getName());
			}

			public void onFailure(Throwable t) {
				System.out.println("call结果[Throwable]:"+t.getMessage());
				System.out.println("call结束："+Thread.currentThread().getName());
			}
		};
	}

	private static Callable<Integer> myTask() {
		return new Callable<Integer>() {
		  public Integer call() {
			System.out.println("call开始："+Thread.currentThread().getName());
			try {
				Thread.sleep(2000L);
				//int r = 1/0;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    return new Random().nextInt(100);
		  }
		};
	}
	
}
