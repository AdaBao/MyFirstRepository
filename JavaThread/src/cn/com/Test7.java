package cn.com;

public class Test7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo7 thread1=new Demo7();
		Demo7 thread2=new Demo7();
		thread1.start();
		thread2.start();
		
		//上下两部分输出是相同的
		/*Demo7 thread=new Demo7();
		Thread thread1=new Thread(thread);
		Thread thread2=new Thread(thread);
		thread1.start();
		thread2.start();*/
		
		

	}

}
