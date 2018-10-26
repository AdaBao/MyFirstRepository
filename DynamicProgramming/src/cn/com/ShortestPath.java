package cn.com;

//动态规划求最短路径
public class ShortestPath {
	private int vertexNum;
	private String[] vertexs;
	private int [][]arc;
	private int[][]d;
	private int[][]path;
	
	public ShortestPath(int vertexNum, String[] vertexs, int[][]arc){
		this.vertexNum=vertexNum;
		this.vertexs=vertexs;
		this.arc=arc;
		d=new int[this.vertexNum][this.vertexNum];
		for(int i=0; i<this.vertexNum; i++)
			for(int j=0; j<this.vertexNum; j++)
				d[i][j]=arc[i][j];
		this.path=new int[this.vertexNum][this.vertexNum];
		for(int i=0; i<this.vertexNum; i++)
			for(int j=0; j<this.vertexNum; j++)
				this.path[i][j]=-1;
	}
	
	public void shortestPath(){
		for(int k=0; k<this.vertexNum; k++)
			for(int i=0; i<this.vertexNum; i++)
				for(int j=0; j<this.vertexNum; j++){
					if(d[i][k]+d[k][j]<d[i][j]){
						d[i][j]=d[i][k]+d[k][j];
						path[i][j]=k;
					}
				}
		
		System.out.print(0+" ");
		printResult(0,this.vertexNum-1);
		System.out.println(this.vertexNum-1+" ");
	}
	
	private void printResult(int start, int end){
		
		
		int middle=path[start][end];
		if(middle!=-1)
			{
			   printResult(start,middle);
			   System.out.print(middle+" ");
			   printResult(middle,end);
			}
		
		
		
	}
	

}
