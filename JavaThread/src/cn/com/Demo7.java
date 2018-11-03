package cn.com;

public class Demo7 extends Thread{
	@Override
	public void run(){
		this.print();
	}
	
	//static的synchronized方法,对象锁是这个类
	public synchronized static void print(){
		for(int i=0; i<10; i++)
			System.out.print(i+" ");
		System.out.println();
	}

}
