package cn.com;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
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
	
	//普里姆算法
	public void prim(){
		List newList=new LinkedList();
		List oldList=new LinkedList();
		List sideList=new LinkedList();
		//初始化两个队列
		newList.add(new Integer(0));
		for(int i=1; i<this.vertexs.length; i++){
			oldList.add(new Integer(i));
		}
		
		while(newList.size()!=this.vertexNum){
			this.findMin(newList, oldList,sideList);
		}
		
		for(int i=0; i<sideList.size(); i++){
			Side side=(Side)sideList.get(i);
			System.out.println(side.startPoint+" "+side.endPoint);
		}
	}
	
	//找出最小边并增删节点和添加边
	private void findMin(List newList,List oldList,List sideList){
		int min=65535;
		Object newO=new Object();
		Object oldO=new Object();
		for(int i=0; i<newList.size();i++){
			for(int j=0; j<oldList.size(); j++){
				Object o1=newList.get(i);
				Object o2=oldList.get(j);
				
				if(this.arc[(Integer)o1][(Integer)o2]<min&&this.arc[(Integer)o1][(Integer)o2]>0){
					min=this.arc[(Integer)o1][(Integer)o2];
					newO=o1;
					oldO=o2;
				}
			}
		}
		
		newList.add(oldO);
		oldList.remove(oldO);
		Side side=new Side();
		side.startPoint=(Integer)newO;
		side.endPoint=(Integer)oldO;
		sideList.add(side);
	}
	
	class Side implements Comparable<Side>{
		public int startPoint;
		public int endPoint;
		
		@Override
		public int compareTo(Side o) {
			// TODO Auto-generated method stub
			if(arc[startPoint][endPoint]>arc[o.startPoint][o.endPoint])
				return 1;
			else if(arc[startPoint][endPoint]<arc[o.startPoint][o.endPoint])
				return -1;
			else
			   return 0;
		}
	}
	
	public void kruskal(){
		List newSides=new LinkedList<Side>();
		List oldSides=new LinkedList<Side>();
		
		for(int i=0; i<this.vertexNum; i++){
			for(int j=i; j<this.vertexNum; j++){
				if(this.arc[i][j]>0&&this.arc[i][j]<65535){
					Side side=new Side();
					side.startPoint=i;
					side.endPoint=j;
					oldSides.add(side);
				}
			}
		}
		
		//parent并不是用来表示最小生成树中的父子关系,实际目的是用来将不同的集合区分开来
		int []parent=new int[this.vertexNum];
		for(int i=0; i<parent.length; i++){
			parent[i]=-1;
		}
		
		while(newSides.size()<this.vertexNum-1){
			Collections.sort(oldSides);
			Side side=(Side)oldSides.remove(0);
			
			int n=this.findParent(parent, side.startPoint);
			int m=this.findParent(parent, side.endPoint);
			
			if(n!=m){
				parent[n]=m;
				newSides.add(side);
			}
			
			/*if(points.contains(side.startPoint)&&points.contains(side.endPoint)){
				
			}else
			{
				points.add(side.startPoint);
				points.add(side.endPoint);
				newSides.add(side);
			}*/
			
			
		}
		
		Iterator iterator=newSides.iterator();
		while(iterator.hasNext()){
			Side side=(Side)iterator.next();
			System.out.println(side.startPoint+" "+side.endPoint);
		}
	}
	
	private int findParent(int []parent,int index){
		while(parent[index]!=-1){
			index=parent[index];
		}
		return index;
	}

}
