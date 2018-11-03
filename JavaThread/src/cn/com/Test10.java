package cn.com;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建一个线程池,大小为2,默认情况下,线程池中没有任何线程.如果线程数量大大超过了
		//线程池的大小,那么没有开始工作的线程会排队等待
		ExecutorService pool=Executors.newFixedThreadPool(2);
		
		//创建三个线程,用于提交给线程池
		Demo10 thread1=new Demo10();
		Demo10 thread2=new Demo10();
		Demo10 thread3=new Demo10();
		
		//将3个线程提交给线程池
		Future future1=pool.submit(thread1);
		Future future2=pool.submit(thread2);
		Future future3=pool.submit(thread3);
		
		//通知线程池没有更多的任务需要提交了,并不会影响尚未完成的工程
		pool.shutdown();
		

	}

}
