package cn.com;

import java.util.LinkedList;
import java.util.List;

//线程thread2负责向strList中添加元素,线程thread1消耗（移除）strList中的元素
//线程thread2在添加元素之后使用notify通知thread1，并让自己wait，线程thread1
//在移除所有的元素之后，使用notify通知thread2，并让自己wait。
//类似于消费者和生产者之间的关系
public class Test9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> strList=new LinkedList();
		
		Demo9_1 thread1=new Demo9_1(strList);
		Demo9_2 thread2=new Demo9_2(strList);
		thread1.start();
		thread2.start();
		
		
		
	}

}
