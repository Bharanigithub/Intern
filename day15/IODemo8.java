package day15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class IODemo8 {
	public static void main(String[] args) throws Exception {
		WriteToString obj=new WriteToString();
		obj.setString("Hello".getBytes());
		System.out.println("Initial String:"+obj.getString());
		store(obj);
		obj.name="HelloWorld";
		
		System.out.println("After Modification:"+obj.getString());
		obj=retrieve(obj);
		System.out.println("After Retrieval:"+obj.getString());
		
	}
	public static void store(WriteToString wts) throws Exception {
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("obj.dat"));
		out.writeObject(wts);
	}
	public static WriteToString retrieve(WriteToString wts) throws Exception {
		ObjectInputStream in=new ObjectInputStream(new FileInputStream("obj.dat"));
		return (WriteToString)in.readObject();
	}
}

class WriteToString implements Serializable {
	String name;
	public void setString(byte[] b) {
		name=new String(b);
	}
	public String getString() {
		return name;
	}
}
