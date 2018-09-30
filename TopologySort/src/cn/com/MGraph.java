package cn.com;

import java.util.Scanner;

public class MGraph {
	private int vertexNum;
	private String[] vertexs;
	private int [][]arc;
	private int []in;//��ʾ���
	
	public void init(){
		System.out.println("����ڵ���:");
		Scanner scanner=new Scanner(System.in);
		this.vertexNum=Integer.parseInt(scanner.nextLine());
		System.out.println("��������ڵ��ֵ:");
		String valueStr=scanner.nextLine();
		this.vertexs=valueStr.split(" ");
		this.arc=new int[this.vertexNum][this.vertexNum];
		in=new int[this.vertexNum];
		System.out.println("�����ڽӾ���:");
		for(int i=0; i<this.vertexNum; i++)
			for(int j=0; j<this.vertexNum; j++){
				this.arc[i][j]=scanner.nextInt();
				if(this.arc[i][j]==1)
					in[j]=in[j]+1;
			}
	}
	
	public void topologySort(){
		int next=0;
		while(true){
			next=-1;
			for(int i=0; i<this.vertexNum; i++){
				if(in[i]==0)
				{
					next=i;
					in[i]=-1;
					
					for(int j=0; j<this.vertexNum; j++){
						if(this.arc[i][j]>=0)
							in[j]--;
					}
					
					break;
				}
			
			
			}
			
			if(next==-1)
				break;
			System.out.println(this.vertexs[next]);
		}
}
	}