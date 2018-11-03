package cn.com.callback;

public class TestThread1 extends Thread{
	String str;
	Test1 test1;
	public TestThread1(Test1 test1){
		this.test1=test1;
	}
	@Override
	public void run(){
		this.str="str";
		this.test1.printLen(getStrLen());
	}
	public int getStrLen(){
		return this.str.length();
	}

}
