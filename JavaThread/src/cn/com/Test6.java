package cn.com;

public class Test6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo6 thread=new Demo6();
		Thread thread1=new Thread(thread);
		Thread thread2=new Thread(thread);
		
		thread1.start();
		thread2.start();
		
	
		//上下对比
		/*Thread thread1=new Demo6();
		Thread thread2=new Demo6();
		
		thread1.start();
		thread2.start();*/

	}

}
