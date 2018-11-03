package cn.com;

public class Demo4 extends Thread{
	
	@Override
	public void run(){
		//所有Demo4实例化的线程同一个时刻只有一个线程能够进入
		//synchronized代码块中执行,并且是"要么不做,要么都做"
		synchronized(Demo4.class){
			for(int i=0; i<10; i++)
		    {
				System.out.print(this.getName()+" ");
				System.out.println("000");
		    }
		}
		}
	}


