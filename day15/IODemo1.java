package day15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class IODemo1 {
	public static void main(String[] args) {
		new CopyCommand().copy("abc.properties");
	}
}
class CopyCommand {
	public void copy(String fileName) {
		FileReader read=null;
		try(FileWriter writer=new FileWriter("copyProperties.properties")) {
			//FileInputStream fis=new FileInputStream(fileName);
			//byte b[]=new byte[8];
			//FileOutputStream fos=new FileOutputStream("copyProperties.properties");
			//int noOfBytes;
			read=new FileReader(fileName);
			int noOfChar;
			char c[]=new char[8];
			while((noOfChar=read.read(c))!=-1) {
				String str=new String(c,0,noOfChar);
				System.out.println("Loop Running..");
				System.out.println(str);
				writer.write(c, 0, noOfChar);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
		}
	}
}