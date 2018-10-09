package cn.com;

//散列表实现
public class HashTable {
	int []data;//散列表
	int m;//散列表容量
	int count;//散列表大小
	
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
	
	//散列函数
	public int hash(int key){
		return key%this.m;
	}
	
	//插入
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
	//查找
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
