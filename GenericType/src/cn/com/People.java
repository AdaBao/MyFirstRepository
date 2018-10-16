package cn.com;

public class People <T extends Human>{
	private String province;
	private T[] human;
	//private static T instance;//编译失败,因为不管是静态变量还是静态方法都是属于class,并不属于某个对象
	public People(T[] human,String province){
		this.human=human;
		this.province=province;
		
		//下面这两句都不能编译通过,因为通过类型参数创建对象并无意义,由于类型擦出,只能创建Object类型的对象
		//T t=new T();
		//T[] arr=new T[10];
	}
	
	public void printAll(){
		System.out.println(this.province+":");
		for(int i=0; i<this.human.length; i++){
			System.out.println(human[i].getName()+" "+human[i].getYear()+" "+human[i].getWeight()+" "+human[i].getNationality());
		}
	}
	
	//如果确实是想使用类型参数创建对象,可以使用下列方法
	public <E> E create(Class<E> type){
		try {
			return type.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		} 
		
	}
	
	//编译失败,原因在上面的静态变量处已说
	/*public static T getInstance(){
		return null;
	}*/
	
}
