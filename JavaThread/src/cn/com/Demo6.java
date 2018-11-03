package cn.com;

public class Demo6 extends Thread{
	@Override
	public void run(){
		this.print();
	}
	
	//synchronized方法作用范围是当前类实例
	private synchronized void print(){
		for(int i=0; i<10; i++)
			System.out.print(i+" ");
		System.out.println();
	}

}
