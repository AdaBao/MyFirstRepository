package cn.com.callback;

public class Test1 {
	public void calcLen(){
		TestThread1 testThread1=new TestThread1(this);
		testThread1.start();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test1 test1=new Test1();
		test1.calcLen();

	}
	
	public void printLen(int len){
		System.out.println(len);
	}

}
