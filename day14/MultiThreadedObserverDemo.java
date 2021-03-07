package day14;

import java.util.Enumeration;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class MultiThreadedObserverDemo {
	public static void main(String[] args) {
		FireAlarm shakthi=new FireAlarm();
		Student ey=new Student();
		Teacher shoiab=new Teacher();
		shakthi.addObserver(ey);
		shakthi.addObserver(shoiab);
		shakthi.setAlarm();
	}
}
class MultiThreadedObservable extends Observable{
	Vector<Observer> vector=new Vector<>();
	@Override
	public synchronized void addObserver(Observer o) {
		// TODO Auto-generated method stub
		vector.add(o);
	}
	@Override
	public void notifyObservers(Object arg) {
		// TODO Auto-generated method stub
		Enumeration<Observer> en=vector.elements();
		ExecutorService es=Executors.newFixedThreadPool(vector.size());
		while(en.hasMoreElements()) {
			Observer observer=en.nextElement();
			es.execute(()->{observer.update(this, arg);});
		}
		es.shutdown();
	}	
}
class FireAlarm extends MultiThreadedObservable{
	public void setAlarm() {
			setChanged();
			notifyObservers("fire in the mountain run run run..................");
		
	}
}
class Student implements Observer{
	@Override
	public void update(Observable o, Object arg) {
			odungo((String)arg);
	}
	public void odungo(String msg) {
		System.out.println("student running............"+msg);
	}
}
class Teacher implements Observer{
	@Override
	public void update(Observable o, Object arg) {
			odungo((String)arg);
	}
	public void odungo(String msg) {
		System.out.println("odlama vendama...................");
		System.out.println("teacher is thinking...................................");
		try {Thread.sleep(10000);}catch(Exception e) {}
		System.out.println("teching running.............."+msg);
	}
}