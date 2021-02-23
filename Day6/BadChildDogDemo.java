package Day6;

import java.util.Scanner;
public class BadChildDogDemo {
	public static void main(String[] args) throws Exception {
		Scanner scan=new Scanner(System.in);
		System.out.println("Please enter a item...:");
		String item=scan.next();
		NaughtyChild naughty=Container2.Method(item);
		naughty.playWithDog();
	}
}


class NaughtyChild{
	DogState dog;
	public void playWithDog() {
		dog.state();
	}
}

abstract class DogState {
	public abstract void state();
}

class Stick extends DogState {
	@Override
	public void state() {
		System.out.println("You Beat I Bite...");
		
	}
}

class Stone extends DogState {
	@Override
	public void state() {
		System.out.println("You hit I Bark...");
		
	}
}

class Container2 {
	public static NaughtyChild Method(String str) throws Exception {
		NaughtyChild nt=new NaughtyChild();
		DogState ds=(DogState)Class.forName(str).newInstance();
		nt.dog=ds;
		return nt;
	}
}
