package day8_Lab;

public class Lab10 {
	public static void main(String[] args) {
		Cc obj1=new Cc();
		Cc obj2=new Cc(5);
	}
}

class Aa {
	public Aa() {
		// TODO Auto-generated constructor stub
	}
	public Aa(int a) {
		// TODO Auto-generated constructor stub
	}
}

class Cc extends Aa {
	public Cc() {
		// TODO Auto-generated constructor stub
	}
	public Cc(int a) {
		super(a);
		// TODO Auto-generated constructor stub
	}

	Bb obj;
}

class Bb {
	public Bb(int a) {
		// TODO Auto-generated constructor stub
	}
}