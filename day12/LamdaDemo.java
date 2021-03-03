package day12;

public class LamdaDemo {
	public static void main(String[] args) {
		display(new MyInter());
		display(new Inter() {
			@Override
			public void Method() {
				// TODO Auto-generated method stub
				System.out.println("Hello from Anonymous Class1!!");
			}
		});
		display(()->{System.out.println("Hi from Lambda1!!");});
		display1((String str)->{System.out.println(str+" Hello from Lambda2!!");});
		int k=display2(()->{return 5;});
		System.out.println(k);
	}

	public static void display(Inter inter) {
		inter.Method();
	}
	public static void display1(Inter2 inter1) {
		inter1.Method("Hi");
	}
	public static int display2(Inter3 inter3) {
		return inter3.Method();
	}
}



interface Inter {
	public void Method();
}
class MyInter implements Inter {
	@Override
	public void Method() {
		// TODO Auto-generated method stub
		System.out.println("Hello from Implemented Class1!!");
	}
}
interface Inter2 {
	public void Method(String str);
}
interface Inter3 {
	public int Method();
}