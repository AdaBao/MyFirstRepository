package cn.com;

import java.util.Scanner;

/*
 * 辗转相除法， 又名欧几里德算法（Euclidean algorithm），是求最大公约数的一种方法。它的具体做法是：用较小数除较大数，再用出现的余数（第一余数）去除除数，
 * 再用出现的余数（第二余数）去除第一余数，如此反复，直到最后余数是0为止。如果是求两个数的最大公约数，那么最后的除数就是这两个数的最大公约数。
 * 
 * */

public class Gcd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int a=0,b=0;
         int max=0,min=0;
         Scanner scanner=new Scanner(System.in);
         a=scanner.nextInt();
         b=scanner.nextInt();
         int gcd=0;
         if(a<=0||b<=0)
        	 System.out.println("no gcd");
         else if(a==1||b==1)
        	 System.out.println("1");
         else
         {
        	 
        	 //假设小的数为最大公约数
        	 if(a>b)
        	 {
        		 max=a;
        		 min=b;
        	 }else{
        		 max=b;
        		 min=a;
        	 }
        	 gcd=min;
        	 
        	 
        	 //循环,用大的数除以小的数,如果能够整除,则小的数为最大公约数
        	 //否则,将除数赋值给max,将余数赋值给min,并假设余数为最大公约数
        	 while(true){
        		int temp=max%min;
        		if(temp==0)
        			break;
        		else{
        			max=min;
        			min=temp;
        			gcd=temp;
        		}
        	 }
        	 
        	 System.out.println(gcd);
         }
	}

}
