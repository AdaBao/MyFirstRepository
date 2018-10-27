package cn.com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class Write {
	//使用write方法,每次写入一个字符
	public static void generateCharactersByOne(OutputStream out){
		int firstPrintableCharacter=33;
		int numberOfPrintableCharacters=94;
		int numberOfCharacterPerline=72;
		
		int start=firstPrintableCharacter;
		
		for(int i=0; i<200; i++){
			for(int j=start; j<start+numberOfCharacterPerline; j++){
				try {
					out.write((j-firstPrintableCharacter)%numberOfPrintableCharacters+firstPrintableCharacter);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			try {
				out.write('\r');
				out.write('\n');
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			start=(start+1-firstPrintableCharacter)%numberOfPrintableCharacters+firstPrintableCharacter;
			
		}
	}
	
	//使用write方法,每次写入一个数组
	public static void generateCharactersByArray(OutputStream out){
		int firstPrintableCharacter=33;
		int numberOfPrintableCharacters=94;
		int numberOfCharacterPerline=72;
		
		int start=firstPrintableCharacter;
		
		for(int i=0; i<200; i++){
			byte [] data=new byte[74];
			for(int j=start; j<start+numberOfCharacterPerline; j++){
				data[j-start]=(byte)((j-firstPrintableCharacter)%numberOfPrintableCharacters+firstPrintableCharacter);
			}
			
			data[72]='\r';
			data[73]='\n';
			
			try {
				out.write(data);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			start=(start+1-firstPrintableCharacter)%numberOfPrintableCharacters+firstPrintableCharacter;
			
		}
	}
	
	//DataOutputStream测试
	public static void writeData(){
		try {
			FileOutputStream fos = new FileOutputStream(new File("test4.txt"));
			DataOutputStream dos=new DataOutputStream(fos);
			dos.writeUTF("ab");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//书写器和阅读器测试代码
	public static void writerAndReaderTest(){
		
		try {
			File file=new File("test5.txt");
			OutputStream os=new FileOutputStream(file);
			OutputStreamWriter osw=new OutputStreamWriter(os,"UTF-8");
			BufferedWriter bw=new BufferedWriter(osw);
			bw.write("abcdefghijklmnopqrstuvwxyz");
			bw.newLine();
			bw.write("123456");
			bw.flush();
			
			//先打开的后关闭
			bw.close();
			osw.close();
			os.close();
			
			InputStream in=new FileInputStream(file);
			InputStreamReader isr=new InputStreamReader(in,"UTF-8");
			BufferedReader br=new BufferedReader(isr);
			String line=br.readLine();
			System.out.println(line);
			char[] c=new char[6];
			br.read(c);
			for(int i=0; i<c.length; i++)
				System.out.print(c[i]+" ");
			br.close();
			isr.close();
			in.close();
		
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
