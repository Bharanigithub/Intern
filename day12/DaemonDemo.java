package day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DaemonDemo {
	public DaemonDemo() {
		ExecutorService es=Executors.newFixedThreadPool(1);
		es.execute(()->{
			while(true) {
				System.out.println("Child Thread");
				es.shutdown();
			}		
		});
		
		es.shutdown();
	}
	public static void main(String[] args) {
		new DaemonDemo();
		System.out.println(Thread.currentThread().getName());
		Thread.currentThread().setDaemon(true);
		try {
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			
		}
		System.exit(1);
	}
}
