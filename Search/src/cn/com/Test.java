package cn.com;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ÕÛ°ë²éÕÒ²âÊÔ
		int []arr={0,1,16,24,35,47,59,62,73,88,99};
		int index=Search.binarySearch(arr, 0, arr.length-1, 62);
		System.out.println(index);
		index=Search.binarySearch(arr, 0, arr.length-1, 300);
		System.out.println(index);
		//-------------------------
		
		//ì³²¨ÄÇÆõ²âÊÔ
		index=Search.fibonacciSearch(arr, 10);
		System.out.println(index);
		//-------------------------
		
		//µ¹ÅÅË÷Òı
		Search.invertedIndex("aa bb cc","bb cc");
	}

}
