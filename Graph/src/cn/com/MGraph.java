package cn.com;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

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
	
	private void DFS(int i){
		if(visited[i])
			return;
		System.out.print(this.vertexs[i]+" ");
		this.visited[i]=true;
		for(int j=0; j<this.vertexNum;j++){
			if(!visited[j]&&this.arc[i][j]>0){
				DFS(j);
			}
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
	
	
	//深度遍历
	public void DFSTraverse(){
		for(int i=0; i<this.vertexNum; i++){
			if(!visited[i])
				DFS(i);
		}
	}
	
	//广度遍历
	public void BFSTraverse(){
		initVisited();
		Queue queue=new LinkedList<Integer>();
		
		for(int j=0; j<this.vertexNum; j++){
			if(!visited[j]){
				visited[j]=true;
				queue.add(new Integer(j));
				
				while(queue.size()>0){
					Integer e=(Integer)queue.poll();
					System.out.print(this.vertexs[e]+" ");
					
					for(int i=0; i<this.vertexNum; i++){
						if(!visited[i]&&this.arc[e][i]>0){
							visited[i]=true;
							queue.add(new Integer(i));
						}
					}
				}
			}	
		}
		
	}

}
