package day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadLockDemo {
	public static void main(String[] args) {
		Crane crane=new Crane();
		Frog frog=new Frog();
		ExecutorService es=Executors.newFixedThreadPool(2);
		es.execute(()->{
			crane.eat(frog);
		});
		es.execute(()->{
			frog.escape(crane);
		});
		es.shutdown();
	}
}
class Crane {
	synchronized public void eat(Frog frog) {
		try {
			Thread.sleep(3000);
		}
		catch(Exception e) {}
		frog.leaveCrane();
		System.out.println("Frog Died");
	}
	synchronized public void spitFrog() {
		
	}
}
class Frog {
	synchronized public void escape(Crane crane) {
		crane.spitFrog();
	}
	synchronized public void leaveCrane() {
		
	}
}