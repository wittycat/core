package com.core.design.singleton;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * @author：chenxun
 * createDate：2016年11月6日 上午11:32:20 
 * Theme:
 * reference:
 * descript:
 */
public class SingletonClient {
	//利用volatile的可见性，确保主线程的修改，其他线程能及时从主存中获取最新的值
	//否则其他线程可能一直使用本地缓存的false，造成cpu爆满，机器卡死
	private volatile  Boolean onoff;
    public Boolean getOnoff() {
		return onoff;
	}
	public void setOnoff(Boolean onoff) {
		this.onoff = onoff;
	}
	public static void main(String[] args) throws InterruptedException  {
    	final SingletonClient onoff = new SingletonClient();
    	onoff.setOnoff(false);
    	final Set<String> synchronizedSet = Collections.synchronizedSet(new HashSet<String>());
    	ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
//    	ExecutorService newCachedThreadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()+1);
    	for (int i = 0; i < 100; i++) {
    		newCachedThreadPool.submit(new Runnable() {
				@Override
				public void run() {
					while (true) {
    					if(onoff.getOnoff()){
    					    synchronizedSet.add(Singleton.getSingleton().toString());
    					    break;
    					}
    				}
					System.out.format("线程%s结束\r\n", Thread.currentThread().getName());
				}
			});
		}
    	Thread.sleep(3000);//保证所有的线程创建完成
    	onoff.setOnoff(true);
    	Thread.sleep(2000);//保证所有的线程完成
    	System.out.println("=========创建实例个数===========");
    	System.out.println(synchronizedSet.size());
    	newCachedThreadPool.shutdown();
	}
}
