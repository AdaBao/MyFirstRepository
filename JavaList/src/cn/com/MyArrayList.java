package cn.com;

import java.util.Iterator;

public class MyArrayList<AnyType> implements Iterable<AnyType> {

	 private AnyType[] theItems;
	@Override
	public Iterator<AnyType> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void test(){
		//this.theItems=new AnyType[10];  ²»ºÏ·¨
		this.theItems=(AnyType[]) new Object[10];
	}

}
