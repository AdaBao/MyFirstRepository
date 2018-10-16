package cn.com;

public class Calculator<T extends Number> {
	public double sum(T n1, T n2){
		return n1.doubleValue()+n2.doubleValue();
	}
}
