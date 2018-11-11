package com.core.guawa.util.concurrent.listenfuture;

public class TListenableFutureTask {
   public static void main(String[] args) {
	   for (int i = 0; i < 5; i++) {
		   TListenableFuture listenableFutureTask = new TListenableFuture();
		   listenableFutureTask.start();
	   }
   }
}
