package com.chenxun.util.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/** 
 * @author：chenxun
 * createDate：2016年11月13日 下午11:14:09 
 * Theme:
 * reference:
 * descript:
 * Condition:限制
 * 为每个对象提供多个等待。
 */
public class TCondition {
  public static void main(String[] args) {
	ReentrantLock reentrantLock = new ReentrantLock();
	Condition newCondition1 = reentrantLock.newCondition();
	Condition newCondition2 = reentrantLock.newCondition();
	new Thread(new Runnable() {
		@Override
		public void run() {
			try {
				reentrantLock.lock();
				System.out.println(Thread.currentThread().getName()+"-ing");
				newCondition1.await();
				newCondition2.signal();
				System.out.println(Thread.currentThread().getName()+"-over");
			} catch (InterruptedException e) {
			}finally{
				reentrantLock.unlock();
			}
		}
	}).start();
	
	new Thread(new Runnable() {
		@Override
		public void run() {
			try {
				reentrantLock.lock();
				System.out.println(Thread.currentThread().getName()+"-ing");
				newCondition1.signal();
				newCondition2.await();
				System.out.println(Thread.currentThread().getName()+"-over");
			} catch (InterruptedException e) {
			}finally{
				reentrantLock.unlock();;
			}
		}
	}).start();
	
	while (Thread.activeCount()>1) {
		Thread.yield();
	}
	System.out.println("mian-over");
  }
}