package com.core.jvm;


/** 
 * @author：chenxun
 * createDate：2016年11月19日 下午3:13:58 
 * Theme:测试多线个线程引起StackOverflowError
 * reference:
 * 参数设置：
 * -Xms100M -Xmx100M -Xss100K -XX:+HeapDumpOnOutOfMemoryError -XX:MetaspaceSize=100m  -XX:MaxMetaspaceSize=100m
 * 
 * 疑惑点：
 * 1.方法区是原来的永久代码？（或是1.8中的Metaspace吗）？如果是为什么vm图要分开画
 * 2.-XX:MetaspaceSize=100m  -XX:MaxMetaspaceSize=100m 参数设置的为什么对于jvisualvm.exe 图的显示没起作用，
 * 
 */
public class TStackOverFlow {

	private static int threadNums;

	public static void main(String[] args) throws InterruptedException {
		for (;;) {
//			Thread.sleep(50000);
            final Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    method();
                }
            });
            thread.setName(TStackOverFlow.class.getName()+threadNums);
            thread.start();
        }
//		String  base = "string";
//        List<String> list = new ArrayList<String>();
//        for (int i=0;i< Integer.MAX_VALUE;i++){
//            String str = base + base;
//            base = str;
//            list.add(str.intern());
//        }
	}

	private static void method(){
		synchronized(TStackOverFlow.class){
			threadNums++;
		}
		System.out.println(threadNums);
		for (;;) {
			
		}
//		byte[] G_1 = new byte[1024*1024*5];
        
	}

}
