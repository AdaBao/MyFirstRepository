package cn.com;

public class Chinese implements Human{
	private String name;
	private int year;
	private int weight;
	private String nationality;
	
	public Chinese(String name,int year,int weight){
		this.name=name;
		this.year=year;
		this.weight=weight;
		this.nationality="CN";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public int getYear() {
		// TODO Auto-generated method stub
		return this.year;
	}

	@Override
	public int getWeight() {
		// TODO Auto-generated method stub
		return this.weight;
	}

	@Override
	public String getNationality() {
		// TODO Auto-generated method stub
		return this.nationality;
	}

}
