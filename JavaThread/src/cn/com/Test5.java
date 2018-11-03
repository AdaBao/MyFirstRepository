package cn.com;

public class Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Demo5 thread=new Demo5();
		
		Thread thread1=new Thread(thread);
		Thread thread2=new Thread(thread);
		
		thread1.start();
		thread2.start();
		

		//上下对比
		/*Thread thread1=new Demo5();
		Thread thread2=new Demo5();
		
		thread1.start();
		thread2.start();*/

	}

}
