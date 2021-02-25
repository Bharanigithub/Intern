package day8_lab5;
import day8_Lab2.*;
public class Lab5_2 {
	public static void main(String[] args) {
		Example ex=new Example();
		ex.method1();
		ex.method2();
		ex.method3();
	}
}



class Example implements Lab5 {
	@Override
	public void method1() {
		// TODO Auto-generated method stub
		System.out.println("Method 1");
	}
	@Override
	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("Method 2");
	}
	@Override
	public void method3() {
		// TODO Auto-generated method stub
		System.out.println("Method 3");
	}
}