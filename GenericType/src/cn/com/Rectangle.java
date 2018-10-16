package cn.com;

public class Rectangle implements Shape<Integer> {
	private Integer length1;
	private Integer length2;
	
	public Rectangle(Integer length1,Integer length2){
		this.length1=length1;
		this.length2=length2;
	}

	@Override
	public Integer calcArea() {
		// TODO Auto-generated method stub
		return this.length1*this.length2;
	}

	@Override
	public Integer calcGirth() {
		// TODO Auto-generated method stub
		return (this.length1+this.length2)*2;
	}
	
	

}
