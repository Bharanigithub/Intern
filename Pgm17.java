package Day1;

public class Pgm17 {
	final int a=10;
	public static void main(String args[]) {
		Pgm17 obj=new Pgm17();
		System.out.println(a);
		obj.a=20;
		Eg obj1=new Eg();
	}
}

class Eg {
	Eg(int b) {
		System.out.println(b);
	}
}