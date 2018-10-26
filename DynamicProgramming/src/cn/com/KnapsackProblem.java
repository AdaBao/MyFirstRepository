package cn.com;

//��̬�滮��ⱳ������
public class KnapsackProblem {
	private int count;//��ʾ��������
	private int[] value;//��ʾÿ�������ֵ
	private int[] w;//��ʾÿ�������С
	private int capacity;//��ʾ��������
	private int[][] V;//���
	
	public KnapsackProblem(int count,int[] value,int []w,int capacity){
		this.count=count;
		this.value=value;
		this.w=w;
		this.capacity=capacity;
		this.V=new int[this.count+1][this.capacity+1];
	}
	
	//���
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
	
	//��ӡ���뱳��������
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
