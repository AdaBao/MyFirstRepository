package cn.com;

public class Sort {
	//改进后的冒泡排序
	public static void bubbleSort(int []arr){
		boolean flag=true;
		if(arr==null||arr.length==0)
			return;
		for(int i=1; i<arr.length&&flag; i++)
		{
			//System.out.println("aaaa");
			flag=false;
			for(int j=arr.length-1; j>=i; j--){
				if(arr[j]<arr[j-1])
					{swap(arr,j-1,j);
				    flag=true;}
			}
			
		}
		
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+" ");
		}
	}
	
	private static void swap(int[] arr, int i, int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	//选择排序
	public static void selectSort(int []arr){
		if(arr==null||arr.length==0)
			return;
		for(int i=0; i<arr.length-1; i++)
		{
			int min=i;
			for(int j=i+1; j<arr.length; j++){
				if(arr[j]<arr[min])
					min=j;
			}
			
			if(min!=i)
				swap(arr,i,min);
		}
		
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]+" ");
	}
	
	//插入排序
	public static void insertSort(int[] arr){
		if(arr==null||arr.length==0)
			return;
		for(int i=1; i<arr.length; i++){
			if(arr[i]<arr[i-1]){
				int x=arr[i];
				int j=0;
				for(j=i-1;j>=0&&arr[j]>x; j--){
					arr[j+1]=arr[j];//后移
				}
				arr[j+1]=x;//插入
			}
		}
		
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+" ");
		}
	}
	
	//希尔排序,详情请查看图片 希尔排序.jpg
	//https://www.cnblogs.com/chengxiao/p/6104371.html
	public static void shellSort(int[] arr){
		if(arr==null||arr.length==0)
			return;
		int gap=arr.length/2;//这里使用的是希尔增量
		for(;gap>=1;gap=gap/2)
		{
			for(int i=gap; i<arr.length; i++)
			{
				
				if(arr[i]<arr[i-gap]){
					int x=arr[i];
					int j=0;
					for(j=i-gap; j>=0&&arr[j]>x; j=j-gap){
						arr[j+gap]=arr[j];//后移
					}
					
					arr[j+gap]=x;
				}
			}
		}
		
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+" ");
		}
	}
	
	//堆排序,这里的arr数组从第二个位置开始存数据,时间复杂度是O(nlogn)
	public static void heapSort(int arr[]){
		//构造堆,构造堆的过程实际上是从下到上,从右到左,但是heapAdjust函数的调整过程是从上到下
		//heapAdjust函数使用的前提条件是只有大顶堆的根节点不满足堆的性质
		for(int i=arr.length/2;i>=1; i--)
			heapAdjust(arr,i,arr.length);
		//在输出堆顶元素之后,调整剩余元素形成一个新堆
		for(int i=1; i<arr.length; i++){
			System.out.print(arr[1]+" ");
			arr[1]=arr[arr.length-i];
			heapAdjust(arr,1,arr.length-i);
		}
		
		
	}
	
	private static void heapAdjust(int arr[],int i,int curLen){
		for(int j=i; j<=(curLen-1)/2; ){
			int max=j;
			
			if(arr[j]<arr[2*j]){
				max=2*j;
				
			}
			if(2*j+1<curLen&&arr[max]<arr[2*j+1]){
				max=2*j+1;
			}
			
			if(max!=j){
				int temp=arr[j];
				arr[j]=arr[max];
				arr[max]=temp;
				j=max;
				
			}else
				break;
		}
	} 
	
	//归并排序,时间复杂度O(nlogn),空间复杂度O(n+logn)
	public static void mSort(int []arr){
		if(arr==null||arr.length==0)
			return;
		int[] result=new int[arr.length];
		mergeSort(arr,result,0,arr.length-1);
		
		for(int i=0; i<result.length; i++)
			System.out.print(result[i]+" ");
	}
	
	private static void mergeSort(int []arr,int []result,int start,int end){
		if(start==end){
			result[0]=arr[start];
		}else{
			int m=(start+end)/2;
			int[] result1=new int[m-start+1];
			int[] result2=new int[end-m];
			mergeSort(arr,result1,start,m);
			mergeSort(arr,result2,m+1,end);
			merge(result,result1,result2);
		}
	}
	
	private static void merge(int[]result, int[] result1, int[]result2){
		int i=0,j=0,k=0;
		while(true){
			if(i>=result1.length||j>=result2.length)
				break;
			
			if(result1[i]>result2[j])
			{
				result[k]=result2[j];
				j++;
				k++;
			}else
			{
				result[k]=result1[i];
				i++;
				k++;
			}
		}
		
		if(i>=result1.length){
			for(;j<result2.length;j++){
				result[k]=result2[j];
				k++;
			}
		}else if(j>=result2.length){
			for(;i<result1.length; i++){
				result[k]=result1[i];
				k++;
			}
		}
	}
	
	

}
