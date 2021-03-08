package day15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class IODemo7 {
	public static void main(String[] args) throws Exception {
		Laddu laddu=new Laddu();
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("laddu.dat"));
		out.writeObject(laddu);
		System.out.println("Laddu Size:"+laddu.size);
		laddu.size=5;
		System.out.println("Laddu Size after Updation:"+laddu.size);
		ObjectInputStream in=new ObjectInputStream(new FileInputStream("laddu.dat"));
		Laddu laddu2=(Laddu)in.readObject();
		System.out.println("Deep Copy Size:"+laddu2.size);
	}
}

class Laddu implements Serializable {
	int size=10;
	public Laddu() {
		System.out.println("Laddu Object Created");
	}
}