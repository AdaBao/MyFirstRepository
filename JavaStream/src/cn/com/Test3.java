package cn.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file=new File("test3.txt");
		try {
			FileInputStream fis=new FileInputStream(file);
			Read.readByOne(fis);
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
