package com.chenxun.guawa.util.concurrent.allover;

import java.util.List;
import java.util.concurrent.Executors;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

public class ThreadPool {

	static final ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
	
	static  FutureCallback<List<Integer>> resultCallBack() {
		return new FutureCallback<List<Integer>>() {
			public void onFailure(Throwable t) {
				System.out.println("call结果[Throwable]:"+t.getMessage());
				System.out.println("call结束："+Thread.currentThread().getName());
			}

			public void onSuccess(List<Integer> result) {
				// TODO Auto-generated method stub
				System.out.println("call结果[Integer]:"+result.toString());
				System.out.println("call结束："+Thread.currentThread().getName());
			}
		};
	}
}