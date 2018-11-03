package cn.com;

import java.util.Arrays;

public class Demo8 extends Thread {
	private int[] data;
	public Demo8(int [] data){
		this.data=data;
	}
	@Override
	public void run(){
		Arrays.sort(this.data);
	}
	

}
