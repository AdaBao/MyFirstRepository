package cn.com;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] files={"test1_1.txt","test1_2.txt","test1_3.txt"};
		for(int i=0; i<files.length; i++)
		{
			Thread t=new ReadFile(files[i]);
			t.start();
		}

	}

}
