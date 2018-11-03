package cn.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.bind.DatatypeConverter;

//通过继承Thread实现多线程
public class ReadFile extends Thread {
	private String filename;
	public ReadFile(String filename){
		this.filename=filename;
	}
	@Override
	public void run(){
		File file=new File(filename);
		try {
			FileInputStream fis=new FileInputStream(file);
		  int fileSize=fis.available();
		  byte[] fileContent=new byte[fileSize];
		  fis.read(fileContent);
		  for(int i=0; i<fileContent.length; i++)
			  System.out.print((char)fileContent[i]);
		  System.out.println();
		  fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
