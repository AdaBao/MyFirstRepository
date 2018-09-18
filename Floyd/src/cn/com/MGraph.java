package cn.com;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MGraph {
	private int vertexNum;
	private String[] vertexs;
	private int [][]arc;
	private boolean []visited;
	
	public MGraph(){
		this.initMGraph();
	}
	
	private void initMGraph(){
		System.out.print("输入顶点数:");
		Scanner scanner=new Scanner(System.in);
		this.vertexNum=scanner.nextInt();
		vertexs=new String[this.vertexNum];
		arc=new int[this.vertexNum][this.vertexNum];
		visited=new boolean[this.vertexNum];
		for(int i=0; i<visited.length;i++){
			visited[i]=false;
		}
		System.out.print("输入各个顶点的值:");
		for(int i=0; i<this.vertexNum; i++){
			vertexs[i]=scanner.next();
		}
		System.out.print("输入邻接矩阵:");
		for(int i=0; i<this.vertexNum; i++)
			for(int j=0; j<this.vertexNum; j++){
				this.arc[i][j]=scanner.nextInt();
			}
	}
	
	
	
	public void floyd(int start,int end){
		int [][]p=new int[this.vertexNum][this.vertexNum];
		for(int i=0; i<this.vertexNum; i++)
			for(int j=0; j<this.vertexNum; j++){
				p[i][j]=j;
			}
		
		for(int k=0; k<this.vertexNum; k++)
			for(int i=0; i<this.vertexNum; i++)
				for(int j=0; j<this.vertexNum; j++){
					if(this.arc[i][k]+this.arc[k][j]<this.arc[i][j]){
						this.arc[i][j]=this.arc[i][k]+this.arc[k][j];
						p[i][j]=p[i][k];
					}
				}
		
		int w=start;
		while(w!=end){
			System.out.print(w+" ");
			w=p[w][end];
		}
		
		System.out.print(end);
	}
	
	
	

}
