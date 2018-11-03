package cn.com;

import java.util.List;
import java.util.Scanner;

public class Demo9_2 extends Thread{
	private List<String> strList;
	
	public Demo9_2(List<String> strList){
		this.strList=strList;
	}
	
	@Override
	public void run(){
		synchronized(strList){
			while(true){
				System.out.println("×ÓÏß³Ì2 input...");
				Scanner scanner=new Scanner(System.in);
				String str=scanner.nextLine();
				String strArray[]=str.split(" ");
				for(int i=0; i<strArray.length; i++)
					strList.add(strArray[i]);
				strList.notify();
				try {
					strList.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}