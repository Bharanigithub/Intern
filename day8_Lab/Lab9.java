package day8_Lab;

public class Lab9 {
	
}

class A {
	public int a;
	private int b;
	protected int c;
	public void meth1() {
		System.out.println("Public Method");
	}
	private void meth2() {
		System.out.println("Private Method");
	}
	protected void meth3() {
		System.out.println("Protected Method");
	}
}

class B extends A {
	public int e;
	private int f;
	protected int g;
	public void meth4() {
		A obj=new A();
		obj.meth1();
		//obj.meth2();  Cannot Access private Members
		obj.meth3();
	}
}