package cn.com.error;

public class TestThread extends Thread {
	String str;
	@Override
	public void run(){
		this.str="str";
	}
	public int getStrLen(){
		return this.str.length();
	}

}
