package cn.com;

public class Triangle implements Shape<Double> {
	private Double length1;
	private Double length2;
	private Double lenght3;

	public Triangle(Double length1,Double length2, Double length3)
	{
		this.length1=length1;
		this.length2=length2;
		this.lenght3=length3;
	}
	@Override
	public Double calcArea() {
		// TODO Auto-generated method stub
		Double p=(this.length1+this.length2+this.lenght3)/2;
		return Math.sqrt(p*(p-this.length1)*(p-this.length2)*(p-this.lenght3));
		
	}

	@Override
	public Double calcGirth() {
		// TODO Auto-generated method stub
		return this.length1+this.length2+this.lenght3;
	}

}
