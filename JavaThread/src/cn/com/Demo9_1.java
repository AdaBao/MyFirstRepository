package cn.com;

import java.util.List;

public class Demo9_1 extends Thread{
	private List<String> strList;
	
	public Demo9_1(List<String> strList){
		this.strList=strList;
	}
	
	@Override
	public void run(){
		synchronized(strList){
			while(true){
				if(strList.size()!=0)
				{
					String str=strList.remove(0);
					System.out.println("子线程1 remove "+str);
				}
				else
				{
					try {
						System.out.println("子线程1 waiting...");
						strList.notify();
						strList.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
				
		}
	}

}
