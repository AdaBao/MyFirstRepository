package cn.com;

import java.util.Scanner;

/*
 * շת������� ����ŷ������㷨��Euclidean algorithm�����������Լ����һ�ַ��������ľ��������ǣ��ý�С�����ϴ��������ó��ֵ���������һ������ȥ��������
 * ���ó��ֵ��������ڶ�������ȥ����һ��������˷�����ֱ�����������0Ϊֹ��������������������Լ������ô���ĳ��������������������Լ����
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
        	 
        	 //����С����Ϊ���Լ��
        	 if(a>b)
        	 {
        		 max=a;
        		 min=b;
        	 }else{
        		 max=b;
        		 min=a;
        	 }
        	 gcd=min;
        	 
        	 
        	 //ѭ��,�ô��������С����,����ܹ�����,��С����Ϊ���Լ��
        	 //����,��������ֵ��max,��������ֵ��min,����������Ϊ���Լ��
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
