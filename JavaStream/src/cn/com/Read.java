package cn.com;

import java.io.IOException;
import java.io.InputStream;

public class Read {
	public static void readByOne(InputStream in){
		byte[] input=new byte[10];
		
		for(int i=0; i<10; i++)
		{
			try {
				int b=in.read();
				if(b==-1)
					break;
				input[i]=b>=0?(byte)b:(byte)(256+b);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(int i=0; i<10; i++)
			System.out.print((char)input[i]+" ");
	}

}
