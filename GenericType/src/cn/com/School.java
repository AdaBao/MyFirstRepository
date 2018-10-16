package cn.com;

import java.util.Iterator;
import java.util.List;

public class School<E> {
	private String name;
	private String location;
	private List<E> students;
	
	public School(String name,String location,List<E> students){
		this.name=name;
		this.location=location;
		this.students=students;
	}
	public <T extends E> void addAll(School<T> s){
		Iterator iterator=s.students.iterator();
		while(iterator.hasNext()){
			this.students.add((E) iterator.next());
		}
	}
	public List<E> getStudents() {
		return students;
	}
	public void setStudents(List<E> students) {
		this.students = students;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

}
