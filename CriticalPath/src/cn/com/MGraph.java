package cn.com;

import java.util.Arrays;
import java.util.Scanner;

public class MGraph {
	private int vertexNum;
	private String[] vertexs;
	private int [][]arc;
	private int []in;//表示入度
	private int []eTime;//表示最早开始时间
	private int []lTime;//表示最晚开始时间
	
	public void init(){
		System.out.println("输入节点数:");
		Scanner scanner=new Scanner(System.in);
		this.vertexNum=Integer.parseInt(scanner.nextLine());
		System.out.println("输入各个节点的值:");
		String valueStr=scanner.nextLine();
		this.vertexs=valueStr.split(" ");
		this.arc=new int[this.vertexNum][this.vertexNum];
		in=new int[this.vertexNum];
		System.out.println("输入邻接矩阵:");
		for(int i=0; i<this.vertexNum; i++)
			for(int j=0; j<this.vertexNum; j++){
				this.arc[i][j]=scanner.nextInt();
				if(this.arc[i][j]>0)
					in[j]=in[j]+1;
			}
		eTime=new int[this.vertexNum];
		lTime=new int[this.vertexNum];
	}
	
	public void criticalPath(){
		this.getETime();
		this.getLTime();
		
		int currentNode=0;
		while(currentNode!=this.vertexNum-1){
			System.out.println(this.vertexs[currentNode]);
			
			for(int i=0; i<this.vertexNum; i++){
				if(this.arc[currentNode][i]>0){
					if(this.eTime[i]==this.lTime[i])
					{
						//System.out.println(this.vertexs[i]);
						currentNode=i;
						break;
					}
				}
			}
		}
		System.out.println(this.vertexs[currentNode]);
	}
	
	private void getETime(){
		this.eTime[0]=0;
		int []_in=Arrays.copyOf(this.in, this.vertexNum);
		int next=0;
		while(true){
			next=-1;
			for(int i=0; i<this.vertexNum; i++){
				if(_in[i]==0)
				{
					next=i;
					_in[i]=-1;
					
					
					for(int j=0; j<this.vertexNum; j++){
						if(this.arc[i][j]>0)
							{
							   _in[j]--;
							}
					}
					
					break;
				}
			
			
			}
			
			if(next==-1)
				break;
			
			
			for(int i=0; i<this.vertexNum; i++){
				if(this.arc[i][next]>0)
				if(this.arc[i][next]+this.eTime[i]>this.eTime[next])
					this.eTime[next]=this.arc[i][next]+this.eTime[i];
			}
			
			
		}
	}
	
private void getLTime(){
	for(int i=0; i<this.vertexNum-1; i++)
		this.lTime[i]=65535;
	this.lTime[this.vertexNum-1]=this.eTime[this.vertexNum-1];
	
	//代表每个节点的出度
	int []out=new int[this.vertexNum];
	for(int i=0; i<this.vertexNum; i++){
		for(int j=0; j<this.vertexNum; j++)
			if(this.arc[i][j]>0)
				out[i]=out[i]+1;
	}
	
	System.out.println();
	while(true){
		int next=-1;
		for(int i=0; i<this.vertexNum; i++){
			if(out[i]==0)
			{
				next=i;
				out[i]=-1;
				
				for(int j=0; j<this.vertexNum; j++){
					if(this.arc[j][i]>0)
						out[j]--;
				}
				break;
			}
		}
		
		if(next==-1)
			break;
		
		for(int i=0; i<this.vertexNum; i++){
			if(this.arc[next][i]>0){
				if(this.lTime[i]-this.arc[next][i]<this.lTime[next]){
					this.lTime[next]=this.lTime[i]-this.arc[next][i];
				}
			}
		}
	}
}
}