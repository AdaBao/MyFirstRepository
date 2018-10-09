package cn.com;

import java.util.Arrays;

public class Search {
	//�۰����
	public static int binarySearch(int []arr,int start,int end,int key){
		if(start>end)
			return -1;
		//�۰���ҿ��Ը���ɲ�ֵ����,ֻ��Ҫ����������������һ��,�����������鿴����Ŀ¼�µ�'��ֵ����.png',
		//��ֵ���Ҹ��ʺϱȽϾ��ȵ�����
		int middle=(start+end)/2;
		if(key<arr[middle])
			return binarySearch(arr,start,middle-1,key);
		else if(key==arr[middle])
			return middle;
		else
			return binarySearch(arr,middle+1,end,key);
	}
	
	//쳲���������
	public static int fibonacciSearch(int []arr,int key){
		//��ʼ��һ��쳲���������,�����д�����������еĳ���
		int []f={0,1,1,2,3,5,8,13,21,34,55,89};
		int k=0;//k����쳲��������г�ʼֵ����Ӧ������
		while(f[k]<arr.length)
			k++;
		
		//����arr,ʹarr�ĳ�����f[k]��ͬ
		int []_arr=new int[f[k]];
		System.arraycopy(arr, 0, _arr, 0, arr.length);
		for(int i=arr.length; i<_arr.length; i++){
			_arr[i]=arr[arr.length-1]+1;
		}
		
		int start=0;
		int end=_arr.length-1;
		
		while(start<=end){
			int middle=start+f[k-1];//middle��ֵ��û�п��ܳ�����end��?
			if(key<_arr[middle]){
				end=middle-1;
				k=k-1;
			}else if(key>_arr[middle]){
				start=middle+1;
				k=k-2;
			}else{
				if(middle>arr.length-1)
					return -2;//��ʾ�ҵ��������ڲ�����ǲ���
				else
					return middle;
			}
		}
		
		return -1;//��ʾδ�ҵ�
	}
	
	//��������
	public static void invertedIndex(String... str){
		
		
	}

}
