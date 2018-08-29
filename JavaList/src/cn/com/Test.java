package cn.com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List myList1=new LinkedList<Integer>();
		List myList2=new ArrayList<Integer>();
		
		for(int i=0; i<10; i++)
		{
			myList1.add(i);
			myList2.add(i);
		}
		
		Iterator iterator1=myList1.iterator();
		Iterator iterator2=myList2.iterator();
		
		/*如果对正在被迭代的集合进行结构上的改变(即对该集合使用add、remove或clear方法),那么迭代器就不再合法
		 * 但是如果使用迭代器自己的remove方法,那么这个迭代器就仍然是合法的
		 * */
		
		//myList1.remove(3);  
		//iterator1.next();
		//iterator1.remove();
		/*while(iterator1.hasNext())
		{
			System.out.println(iterator1.next());
		}*/
		
		//myList2.remove(3);
		//myList2.add(10);
		//iterator2.next();
		//iterator2.remove();
		/*while(iterator2.hasNext())
		{
			System.out.println(iterator2.next());
		}*/

	}

}
