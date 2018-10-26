package cn.com;

//动态规划求解背包问题
public class KnapsackProblem {
	private int count;//表示物体数量
	private int[] value;//表示每个物体价值
	private int[] w;//表示每个物体大小
	private int capacity;//表示背包容量
	private int[][] V;//表格
	
	public KnapsackProblem(int count,int[] value,int []w,int capacity){
		this.count=count;
		this.value=value;
		this.w=w;
		this.capacity=capacity;
		this.V=new int[this.count+1][this.capacity+1];
	}
	
	//填表
	public void findMax(){
		for(int i=0; i<this.count+1; i++)
			this.V[i][0]=0;
		for(int i=0; i<this.capacity+1; i++)
			this.V[0][i]=0;
		
		for(int i=1; i<=this.count; i++)
			for(int j=1; j<=this.capacity; j++){
				if(j<w[i])
					V[i][j]=V[i-1][j];
				else{
					V[i][j]=V[i-1][j]>V[i-1][j-w[i]]+value[i]?V[i-1][j]:V[i-1][j-w[i]]+value[i];
				}
			}
		
		for(int i=0; i<this.count+1; i++){
			for(int j=0; j<this.capacity+1; j++)
			{
				System.out.print(this.V[i][j]+" ");
			}
			
			System.out.println();
		}
	}
	
	//打印放入背包的物体
	public void findWhat(){
		int i=this.count;
		int j=this.capacity;
		
		while(i!=0){
			
			if(V[i-1][j]!=V[i][j])
			{
				j=j-w[i];
				System.out.print(i+" ");
			}
			
			i=i-1;
		}
	}

}
