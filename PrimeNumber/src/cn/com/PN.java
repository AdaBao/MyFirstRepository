package cn.com;

import java.util.Scanner;

//�ж��Ƿ�������,������2��num/2,������������������,���no,������ѭ���������yes
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
