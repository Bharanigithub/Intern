package day15;

import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IODemo6 {
	public static void main(String[] args) throws Exception {
		PipedReader reader=new PipedReader();
		PipedWriter writer=new PipedWriter(reader);
		ExecutorService es=Executors.newFixedThreadPool(2);
		es.execute(()->{
			try {
			int k=reader.read();
			while(k!=-1) {
				System.out.print((char)k);
				k=reader.read();
			}
			}catch(Exception e) {}
		});
		es.execute(()->{
			try {
			while(true) {
				
				writer.write("Hello World".toCharArray());
				try {
					Thread.sleep(1000);
				}catch(Exception e) {}
			}
			}catch(Exception e) {}
		});
	}
}
