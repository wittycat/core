package com.chenxun.util.concurrent;

import org.junit.Test;

/** 
 * @author：chenxun
 * 创建时间：2016年10月8日 下午8:58:33 
 * 参考：
 * 说明： Object类的方法：
 *      Wait()是Object类的方法，范围是使该Object实例所处的线程。
 *      Wait方法进入等待状态时会释放同步锁(如例中的lock对象)
 *      notify()将随机唤醒一个在对象上等待的线程，没有一个都没有，则什么都不做。
 *      notifyAll()唤醒的所有线程，将在notify()线程释放了对象监视器以后才执行，并不是notify了以后马上执行。
 *      --------------------------------------------------------------------
 *      Thread类的方法：
 *      Sleep()是Thread类专属的静态方法，针对一个特定的线程。
 *      Sleep方法不会释放同步锁
 *      interrupt()终止线程，前提该线程必须持有锁，如果线程在调用 Object 类的 wait()、wait(long) 
 *      或 wait(long, int) 方法，或者该类的 join()、join(long)、join(long, int)、
 *      sleep(long) 或 sleep(long, int) 方法过程中受阻，则其中断状态将被清除，也就是无效
 */
public class TestWaitNotify {
   
   @Test
   public void methodOne() throws InterruptedException {
	   @SuppressWarnings("rawtypes")
	   final Class lock = TestWaitNotify.class;
	   Thread t1 = new Thread(MyTask(lock));
	   Thread t2 = new Thread(MyTask(lock));
	   Thread t3 = new Thread(MyNotify(lock));
	   
	   t1.setName("t1");
	   t2.setName("t2");
	   t3.setName("t3");
	   t1.start();
	   t2.start();
	   /**
	    * 不添加这两个sleep  完全也可以，只不过有时不能复现
	    * 加了可以基本保障复现
	    */
	   Thread.sleep(2000);
	   t3.start();
	   Thread.sleep(3000);
   }

   public Runnable MyNotify(final Class lock) {
		return new Runnable() {
			@Override
			public void run() {
				 synchronized (lock) {
//					lock.notify();
					lock.notifyAll();
				 }
			}
		 };
	}

	/**
	 * @param lock
	 * @return
	 */
	public Runnable MyTask( final Class lock) {
		return new Runnable() {
			@Override
			public void run() {
//					 synchronized (lock) {  
						 try {
								String name = Thread.currentThread().getName();
								System.out.println("before"+name);
								Thread.currentThread().interrupt();
								lock.wait();
								System.out.println("after"+name);
							} catch (InterruptedException e) {
								e.printStackTrace();
//						 }
					}
			  }
		 };
	}
}
