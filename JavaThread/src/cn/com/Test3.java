package cn.com;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test3 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []data={1,2,3,10,5,6,7,8};
		
		FindMaxTask task1=new FindMaxTask(Arrays.copyOfRange(data, 0, data.length/2));
		FindMaxTask task2=new FindMaxTask(Arrays.copyOfRange(data, data.length/2, data.length));
		
		//创建两个线程
		ExecutorService executor=Executors.newFixedThreadPool(2);
		//将任务分解成两部分
		Future<Integer> future1=executor.submit(task1);
		Future<Integer> future2=executor.submit(task2);
		
		try {
			int max=future1.get()>future2.get()?future1.get():future2.get();
			System.out.println(max);
			executor.shutdown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
