package cn.com;

//ɢ�б�ʵ��
public class HashTable {
	int []data;//ɢ�б�
	int m;//ɢ�б�����
	int count;//ɢ�б��С
	
	public HashTable(int m){
		if(m<=0)
		{
			
		}else{
			this.m=m;
			this.data=new int[m];
			for(int i=0; i<this.m; i++){
				this.data[i]=-1;
			}
			
			this.count=0;
		}
		
	}
	
	//ɢ�к���
	public int hash(int key){
		return key%this.m;
	}
	
	//����
	public boolean insertHash(int key){
		if(this.count==this.data.length)
			return false;
		int addr=this.hash(key);
		while(this.data[addr]!=-1)
			addr=(addr+1)%this.m;
		this.data[addr]=key;
		this.count++;
		return true;
	}
	//����
	public int searchHash(int key){
		if(this.count==0)
			return -1;
		int addr=this.hash(key);
		while(this.data[addr]!=key){
			addr=(addr+1)%this.m;
			if(this.data[addr]==-1||addr==this.hash(key))
				return -1;
		}
		return addr;
	}
}
