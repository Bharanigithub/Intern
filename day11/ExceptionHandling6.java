package day11;

public class ExceptionHandling6 {
	public static void main(String[] args) {
		try {
			B b=new B();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
}

class A {
	public A() throws Exception {
		// TODO Auto-generated constructor stub
		throw new Exception();
	}
}

class B extends A {
	public B() throws Exception{
		// TODO Auto-generated constructor stub
	}
}