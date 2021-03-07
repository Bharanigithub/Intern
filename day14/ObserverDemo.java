package day14;
/*
import java.util.Observable;
import java.util.Observer;

public class ObserverDemo {
	public static void main(String[] args) {
		Student student=new Student();
		Teacher teacher=new Teacher();
		FireAlarm fireAlarm=new FireAlarm();
		fireAlarm.addObserver(teacher);
		fireAlarm.addObserver(student);
		fireAlarm.alert();
	}
}

class FireAlarm extends Observable{
	public void alert() {
		setChanged();
		notifyObservers();
	}
}
class Teacher implements Observer {
	public void run() {
		System.out.println("Teacher is Running");
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		run();
	}
}
class Student implements Observer {
	public void run() {
		System.out.println("Student is Running");
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		run();
	}
}
*/