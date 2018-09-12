package cn.com;

import java.util.Comparator;

//比较器作为TreeSet构造函数的参数传入,在TreeSet的构造函数中会调用TreeMap的构造函数,然后用传入的比较器给TreeMap的成员变量赋值
//当插入数据时,put函数会调用比较器中的函数去比较大小
public class PersonCompare implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		// TODO Auto-generated method stub
		if(o1.getAge()>o2.getAge())
			return 1;
		else if(o1.getAge()==o2.getAge())
			return 0;
		else
			return -1;
		
	}

}
