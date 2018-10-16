package cn.com;

public class Circle implements Comparable<Circle>,Shape<Double>{
	private double radius;
	
	public Circle(double radius){
		this.radius=radius;
	}

	@Override
	public int compareTo(Circle o) {
		// TODO Auto-generated method stub
		if(this.radius>o.radius)
			return 1;
		else if(this.radius==o.radius)
			return 0;
		return -1;
		
	}

	@Override
	public Double calcArea() {
		// TODO Auto-generated method stub
		return Math.PI*Math.pow(this.radius, 2);
	}

	@Override
	public Double calcGirth() {
		// TODO Auto-generated method stub
		return Math.PI*2*this.radius;
	}

	
}
