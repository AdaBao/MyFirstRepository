package cn.com;

import java.util.Scanner;

//判断是否是质数,除数从2到num/2,如果出现能整除的情况,输出no,否则在循环体外输出yes
public class PN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
            Scanner scanner=new Scanner(System.in);
            int num=scanner.nextInt();
            
            if(num<=1)
            	{
            	    System.out.println("neither");
            	    return;
            	}
            for(int i=2; i<=num/2; i++){
            	if(num%i==0)
            		{
            		   System.out.println("no");
            		   return;
            		}
              }
            System.out.println("yes");
	}

}
