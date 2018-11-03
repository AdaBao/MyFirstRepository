package cn.com.callback;

public class TestThread extends Thread {
	String str;
	@Override
	public void run(){
		this.str="str";
		Test.printLen(getStrLen());
	}
	public int getStrLen(){
		return this.str.length();
	}

}
