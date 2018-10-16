package cn.com;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//以下六种泛型的实例化方式均可
		Pair pair=new Pair("hello","world");
		Pair pair1=new Pair<>("hello","world");
		Pair pair2=new Pair<String>("hello","world");
		Pair<String> pair3=new Pair("hello","world");
		Pair<String> pair4=new Pair<>("hello","world");
		Pair<String> pair5=new Pair<String>("hello","world");
		System.out.println(pair.getFirst());
		System.out.println(pair1.getFirst());
		System.out.println(pair2.getFirst());
		System.out.println(pair3.getFirst());
		System.out.println(pair4.getFirst());
		System.out.println(pair5.getFirst());
//-----------------------------------------------------------------
		//泛型的类型参数可以有多个
		org.bth.Pair p=new org.bth.Pair<Integer,String>(10,"hello");
		System.out.println(p.getFirst());
		System.out.println(p.getSecond());
		
//-----------------------------------------------------------------		
		//函数泛型调用
		sayHello("xiaoming");
		
//-----------------------------------------------------------------
		//接口泛型
		Rectangle rectangle=new Rectangle(2,3);
		System.out.println(rectangle.calcGirth());
		System.out.println(rectangle.calcArea());
		
		Triangle triangle=new Triangle(3.0,4.0,5.0);
		System.out.println(triangle.calcGirth());
		System.out.println(triangle.calcArea());
//-----------------------------------------------------------------
		//类型参数的限定
		//上限为某个具体类
		Calculator calc=new Calculator<Double>();
		System.out.println(calc.sum(3, 4));
		
		//上界为接口
		Chinese chinese1=new Chinese("zhao",20,100);
		Chinese chinese2=new Chinese("qian",21,120);
		Chinese chinese3=new Chinese("sun",18,90);
		Chinese[] chinese={chinese1,chinese2,chinese3};
		People people=new People<Chinese>(chinese,"peking");
		people.printAll();
		
		Circle circle1=new Circle(4.0);
		Circle circle2=new Circle(5.0);
		Circle circle3=new Circle(6.0);
		Circle[] circles={circle1,circle2,circle3};
		Circle maxCircle=max(circles);
		System.out.println(maxCircle.calcArea());
		
		//上界为其他类型参数,首先要知道List<Integer>并不是List<Number>的子类,在
		//School类的addAll函数中,T类型需要继承自或者是E类型,如下所示,Integer类型继承自Number
		List<Number> students1=new ArrayList<Number>();
		School<Number> school1=new School<Number>("bit","peking",students1);
		List<Integer> students2=new ArrayList<Integer>();
		School<Integer> school2=new School<Integer>("bit","peking",students2);
		school1.addAll(school2);//编译正确
		//school2.addAll(school1);//编译失败
//-----------------------------------------------------------------
		//解析通配符
		List<Double> doubleList=new LinkedList<Double>();
		doubleList.add(1.0);
		doubleList.add(2.0);
		doubleList.add(3.0);
		printAll(doubleList);
		System.out.println();
		List<Number> numberList=new LinkedList();
		numberList.add(1.0);
		printAll(numberList);
		System.out.println();
		//List<String> strList=new LinkedList();
		//printAll(strList); //编译错误
		_swap(doubleList);
//-----------------------------------------------------------------
		//超类型通配符,max函数使用了通配符和super,T是Child,Base(?) super Child,Child继承自Comparable<Base>
		List<Child> childList=new LinkedList<Child>();
		max(childList);
		//max1(childList);//编译错误,虽然Child继承自Base,但是对于编译器来说Child似乎并未实现Comparable接口
//-----------------------------------------------------------------
		//使用泛型类  方法和接口
		//每个类都有一份类型信息,叫做类型对象
		Class<?> cls="Hello".getClass();
		System.out.println(cls);
		System.out.println(String.class=="Hello".getClass());
		//System.out.println(List<Integer>.class);//编译失败,java不支持类似写法
		System.out.println(new LinkedList<Integer>().getClass()==LinkedList.class);//一个泛型对象的getClass方法的返回值与原始类型对象是相同的
		//if(new LinkedList<Integer> instanceof LinkedList<Integer>){}//同样编译失败,java不支持类似写法
		if(new LinkedList<Integer>() instanceof LinkedList<?>){}//java支持此写法
		//List<Integer>[] listArr={new LinkedList<Integer>()};//编译失败,java不能创建泛型数组
		LinkedList[] listArr={new LinkedList<Integer>(),new LinkedList<String>()};//编译通过
		
		//下面的语句能通过编译,但是Integer[]并不是Number[]的子类型,但是如果使用不当也是不安全的
		Integer[] ints=new Integer[10];
		Number[] numbers=ints;
		Object[] objs=ints;
		//objs[0]="hello";//编译能通过,但是运行时会抛异常
		
		//下列代码在运行时会报错,可以通过反射来解决这个问题
		try{
			Object [] oArr=new Object[10];
			Integer[] iArr={0,1,2,3,4,5,6,7,8,9};
			System.arraycopy(iArr, 0, oArr, 0, 10);
			Integer [] iArr1=(Integer[])oArr;
		}
		catch(Exception e){
			System.out.println("Exception");
		}
		
		try{
			Object  oArr=Array.newInstance(Integer.class, 10);
			Integer[] iArr={0,1,2,3,4,5,6,7,8,9};
			System.arraycopy(iArr, 0, oArr, 0, 10);
			Integer [] iArr1=(Integer[])oArr;
			System.out.println("no exception");
		}
		catch(Exception e){
			System.out.println("Exception");
		}
		
		
		
		
		
	
		
		
	}
	
	//函数泛型
	private static <T> void sayHello(T t){
		System.out.println(t+" hello");
	}
	
	//上界为接口
	//如何理解<T extends Comparable<T>>? T实现了Comparable接口,同时Comparable接口也是泛型,Comparable接口需要T做类型参数,可以通过查看Circle类来理解
	private static <T extends Comparable<T>> T max(T[] arr){
		if(arr==null||arr.length==0)
			return null;
		T max=arr[0];
		for(int i=1; i<arr.length; i++){
			if(arr[i].compareTo(max)==1)
				max=arr[i];
		}
		
		return max;
	}
	
	//通配符在泛型中的使用
	private static  void printAll(List<? extends Number> list){
		if(list==null||list.size()==0)
			return;
		//list.add(new Object());//编译错误,通配符只能写不能读
		Iterator iterator=list.iterator();
		while(iterator.hasNext()){
			System.out.print(iterator.next()+" ");
		}
	}
	//通配符在泛型中的使用,下面代码在编译的时候会报错,泛型中的通配符的一个特点就是只能写不能读
	/*private static void swap(List<?> list){
		Object tmp=list.get(0);
		list.set(0, list.get(1));
		list.set(1, tmp);
	}*/
	
	//通配符在泛型中的使用,下面两个函数可以实现交换,解决上面函数所出现的问题
	private static <T> void swap(List<T> list){
		System.out.println("交换前:"+list.get(0)+" "+list.get(1));
		T tmp=list.get(0);
		list.set(0, list.get(1));
		list.set(1, tmp);
		System.out.println("交换后:"+list.get(0)+" "+list.get(1));
	}
	private static void _swap(List<?> list){
		swap(list);
	}
	
	//超类型通配符,super表示某个父类型
	private static <T extends Comparable<? super T>>  T max(List<T> list){
		return null;
	}
	
	private static <T extends Comparable<T>>  T max1(List<T> list){
		return null;
	}
	
	

}
