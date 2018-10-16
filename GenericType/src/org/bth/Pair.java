package org.bth;

public class Pair<U,V> {
	U first;
	V second;
	public Pair(U first,V second){
		this.first=first;
		this.second=second;
	}
	
	public U getFirst(){
		return this.first;
	}
	
	public V getSecond(){
		return this.second;
	}

}

