package cn.com;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//TreeMap会根据关键字保持有序的状态,下面第二行会抛出异常,因为People不能比较,People需要实现Comparable接口
		//Map map=new TreeMap<People,String>();
		//map.put(new People(), "");
		
		//containsKey方法会调用compareTo方法进行比较,所以下面的p1和p2被视为键值是相同的,所以下面的第二个put方法
		//不能添加键值对,但是会更新value
		Map map=new TreeMap<Person,String>();
		Person p1=new Person("sam",12);
		map.put(p1, "sam");
		System.out.println(map.containsKey(p1));
		System.out.println("-------------");
		Person p2=new Person("sam1",12);
		System.out.println(map.containsKey(p2));
		map.put(p2, "sam2");
		System.out.println("-------------");
		System.out.println(map.size());
		
		
		map.put(new Person("amy",13), "amy");
		map.put(new Person("lingling",14), "lingling");
		//下面这种遍历方式会报错,因为map.entrySet()得到的集合中的每一个元素是Object类型,Object类型无法转换为Map.Entry<Person,String>类型
		//for(Map.Entry<Person, String> entry : map.entrySet()){
		//}
		
		Set<Map.Entry<Person, String>> s=map.entrySet();
		Iterator iterator=s.iterator();
		while(iterator.hasNext()){
			Map.Entry<Person, String> entry=(Map.Entry<Person, String>)iterator.next();
			System.out.println(entry.getKey().getName()+" "+entry.getValue());
		}

	}

}
