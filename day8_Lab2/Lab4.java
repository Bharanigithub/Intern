package day8_Lab2;

public class Lab4 {
	public static void main(String args[]) {
		Exercise1 aa=new Exercise1();
		A a=new Exercise();
		aa.method1(a);
		B b=new Exercise();
		aa.method2(b);
		C c=new Exercise();
		aa.method3(c);
		d dd=new Exercise();
		aa.method4(dd);
	}
}

interface A {
	public void met1();
	public void met2();
}

interface B {
	public void met3();
	public void met4();
}

interface C {
	public void met5();
	public void met6();
}

interface d extends A,B,C {
	public void met7();
}

class Exercise implements d {
	@Override
	public void met1() {
		// TODO Auto-generated method stub
		System.out.println("Method 1");
	}@Override
	public void met2() {
		// TODO Auto-generated method stub
		System.out.println("Method 2");
	}@Override
	public void met3() {
		// TODO Auto-generated method stub
		System.out.println("Method 3");
	}@Override
	public void met4() {
		// TODO Auto-generated method stub
		System.out.println("Method 4");
	}@Override
	public void met5() {
		// TODO Auto-generated method stub
		System.out.println("Method 5");
	}@Override
	public void met6() {
		// TODO Auto-generated method stub
		System.out.println("Method 6");
	}@Override
	public void met7() {
		// TODO Auto-generated method stub
		System.out.println("Method 7");
	}
}
class Exercise1 extends Exercise {
	public void method1(A a) {
		a.met1();
		a.met2();
	}
	public void method2(B b) {
		b.met3();
		b.met4();
	}
	public void method3(C c) {
		c.met5();
		c.met6();
	}
	public void method4(d da) {	
		da.met7();
	}
}