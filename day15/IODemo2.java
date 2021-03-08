package day15;

import java.io.File;
import java.io.FilenameFilter;

public class IODemo2 {
	public static void main(String[] args) {
		File file=new File("D:/temp");
		System.out.println("File Path:"+file.getAbsolutePath());
		System.out.println("FileName:"+file.getName());
		System.out.println("Does the File Exists:");
		System.out.println(file.exists()?"YES, The file exists!!":"NO, The file Not exists!!");
		System.out.println(file.canWrite());
		System.out.println(file.isDirectory());
		File destFile=new File("D:/temptemp");
		file.renameTo(destFile);
		String st[]=destFile.list(new MyClass("css"));
		for(String ss:st) {
			System.out.println(ss);
		}
	}
}

class MyClass implements FilenameFilter {
	String extName;
	public MyClass(String extName) {
		// TODO Auto-generated constructor stub
		this.extName=extName;
	}
	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		return name.endsWith("."+extName);
	}
}
