package com.chenxun.guawa.util.concurrent.allover;

import java.util.ArrayList;
import java.util.List;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

public class AllOverTest {
   public static void main(String[] args) {
	   List<ListenableFuture<Integer>> list = new ArrayList<ListenableFuture<Integer>>() ;
	   
	   for (int i = 0; i < 50; i++) {
		  ListenableFuture<Integer> start = new  MyListenableFutureMoreTask2().start();
		  list.add(start);
	   }
	   
	   ListenableFuture<List<Integer>> allAsList = Futures.allAsList(list);
	   
	   Futures.addCallback(allAsList, ThreadPool.resultCallBack());
   }
}
