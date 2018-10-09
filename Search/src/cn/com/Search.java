package cn.com;

import java.util.Arrays;

public class Search {
	//折半查找
	public static int binarySearch(int []arr,int start,int end,int key){
		if(start>end)
			return -1;
		//折半查找可以改造成插值查找,只需要把下面这条语句改造一下,改造后的语句清查看工程目录下的'插值查找.png',
		//插值查找更适合比较均匀的数据
		int middle=(start+end)/2;
		if(key<arr[middle])
			return binarySearch(arr,start,middle-1,key);
		else if(key==arr[middle])
			return middle;
		else
			return binarySearch(arr,middle+1,end,key);
	}
	
	//斐波那契查找
	public static int fibonacciSearch(int []arr,int key){
		//初始化一个斐波那契数列,该数列代表待查找序列的长度
		int []f={0,1,1,2,3,5,8,13,21,34,55,89};
		int k=0;//k代表斐波那契数列初始值所对应的索引
		while(f[k]<arr.length)
			k++;
		
		//补齐arr,使arr的长度与f[k]相同
		int []_arr=new int[f[k]];
		System.arraycopy(arr, 0, _arr, 0, arr.length);
		for(int i=arr.length; i<_arr.length; i++){
			_arr[i]=arr[arr.length-1]+1;
		}
		
		int start=0;
		int end=_arr.length-1;
		
		while(start<=end){
			int middle=start+f[k-1];//middle的值有没有可能超过了end呢?
			if(key<_arr[middle]){
				end=middle-1;
				k=k-1;
			}else if(key>_arr[middle]){
				start=middle+1;
				k=k-2;
			}else{
				if(middle>arr.length-1)
					return -2;//表示找到的数据在补齐的那部分
				else
					return middle;
			}
		}
		
		return -1;//表示未找到
	}
	
	//倒排索引
	public static void invertedIndex(String... str){
		
		
	}

}
