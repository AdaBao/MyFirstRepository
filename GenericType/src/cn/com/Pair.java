package cn.com;

public class Pair<T> {
	T first;
	T second;
	public Pair(T first,T second){
		this.first=first;
		this.second=second;
	}
	
	public T getFirst(){
		return this.first;
	}
	
	public T getSecond(){
		return this.second;
	}

}
