package com.chenxun.guawa.util.concurrent.mylistenfuture;

public class TestListenableFutureTask {
   public static void main(String[] args) {
	   for (int i = 0; i < 5; i++) {
		   ListenableFutureTask listenableFutureTask = new ListenableFutureTask();
		   listenableFutureTask.start();
	   }
   }
}
