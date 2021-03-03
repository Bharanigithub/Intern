package day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwoThreadsOneObject {
	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(2);
		ReservationCounter rc=new ReservationCounter();
			es.execute(()->{
				Thread.currentThread().setName("Ramesh");
				synchronized(rc) {
				rc.bookTicket(1000);
				rc.giveChange();
				try {
				Thread.sleep(2000);
				}
				catch(Exception e) {}
				}
			});
			es.execute(()->{
				Thread.currentThread().setName("Suresh");
				synchronized(rc) {
					rc.bookTicket(500);
					rc.giveChange();
				}
			});
		es.shutdown();
	}
}

class ReservationCounter {
	int amount;
	public void bookTicket(int amount) {
		this.amount=amount;
		System.out.println("Ticket Booked By:"+Thread.currentThread().getName());
	}
	public void giveChange() {
		System.out.println("Remaining Change:"+(amount-100)+" for "+Thread.currentThread().getName());
	}
}