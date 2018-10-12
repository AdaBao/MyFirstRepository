package cn.com;

public class Sort {
	//�Ľ����ð������
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
	
	//ѡ������
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
	
	//��������,���������Ǽ�������������õ�
	public static void insertSort(int[] arr){
		if(arr==null||arr.length==0)
			return;
		for(int i=1; i<arr.length; i++){
			if(arr[i]<arr[i-1]){
				int x=arr[i];
				int j=0;
				for(j=i-1;j>=0&&arr[j]>x; j--){
					arr[j+1]=arr[j];//����
				}
				arr[j+1]=x;//����
			}
		}
		
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+" ");
		}
	}
	
	//ϣ������,������鿴ͼƬ ϣ������.jpg
	//https://www.cnblogs.com/chengxiao/p/6104371.html
	public static void shellSort(int[] arr){
		if(arr==null||arr.length==0)
			return;
		int gap=arr.length/2;//����ʹ�õ���ϣ������
		for(;gap>=1;gap=gap/2)
		{
			for(int i=gap; i<arr.length; i++)
			{
				
				if(arr[i]<arr[i-gap]){
					int x=arr[i];
					int j=0;
					for(j=i-gap; j>=0&&arr[j]>x; j=j-gap){
						arr[j+gap]=arr[j];//����
					}
					
					arr[j+gap]=x;
				}
			}
		}
		
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+" ");
		}
	}
	
	//������,�����arr����ӵڶ���λ�ÿ�ʼ������,ʱ�临�Ӷ���O(nlogn)
	public static void heapSort(int arr[]){
		//�����,����ѵĹ���ʵ�����Ǵ��µ���,���ҵ���,����heapAdjust�����ĵ��������Ǵ��ϵ���
		//heapAdjust����ʹ�õ�ǰ��������ֻ�д󶥶ѵĸ��ڵ㲻����ѵ�����
		for(int i=arr.length/2;i>=1; i--)
			heapAdjust(arr,i,arr.length);
		//������Ѷ�Ԫ��֮��,����ʣ��Ԫ���γ�һ���¶�
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
	
	//�鲢����,ʱ�临�Ӷ�O(nlogn),�ռ临�Ӷ�O(n+logn)
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
	
	
	//��������,���ŵ�ĳЩ�����ǿ����Ż���,�˴�δ�޸�
	public static void qSort(int[] arr){
		if(arr==null||arr.length==0)
			return;
		
		quickSort(0,arr.length-1,arr);
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]+" ");
	}
	
	private static void quickSort(int low,int high,int[] arr){
		if(low<high){
			int pivot=partition(low,high,arr);
			quickSort(low,pivot-1,arr);
			quickSort(pivot+1,high,arr);
		}
	}
	
	private static int partition(int low,int high,int[]arr){
		int pivotValue=arr[low];
		while(low<high){
			while(arr[high]>=pivotValue&&high>low)
				high--;
			swap(arr,low,high);
			while(arr[low]<=pivotValue&&low<high)
				low++;
			swap(arr,low,high);
		}
		return low;
	}

}
