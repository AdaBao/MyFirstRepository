package cn.com;

public class Student {
	private String stuId;
	private String name;
	private int year;
	
	public Student(String stuId,String name,int year){
		this.stuId=stuId;
		this.name=name;
		this.year=year;
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

}
