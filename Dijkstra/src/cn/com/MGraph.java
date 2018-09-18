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
	
	
	
	//初始化visited
	private void initVisited(){
		if(this.visited==null)
			return;
		else if(this.visited.length==0)
			return;
		else{
			for(int i=0; i<this.visited.length; i++){
				visited[i]=false;
			}
		}
	}
	
	
	public void dijkstra(int start,int end){
		Set minLengthPath=new LinkedHashSet<Integer>();
		
		minLengthPath.add(new Integer(start));
		int currentNode=start;
		
		while(currentNode!=end){
			int node=-1;
			int len=65535;
			for(int i=0; i<this.vertexNum; i++){
				if(!minLengthPath.contains(i)){
					if(this.arc[currentNode][i]<len)
						{
						   node=i;
						   len=this.arc[currentNode][i];
						}
				}
			}
			
			if(node==-1)
				break;
			currentNode=node;
			minLengthPath.add(node);
		}
		
		
		for(Object o:minLengthPath){
			System.out.print((Integer)o+" ");
		}
		
	}

}
