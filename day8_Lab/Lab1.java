package day8_Lab;

public class Lab1 {
	public static void main(String args[]) {
		int a[]=new int[10];
		for(int i=0;i<10;i++)
			a[i]=1;
		Lab1 obj1=new Lab1();
		obj1.method(a);
		Pass obj2=new Pass(10);
		obj2.method();
		System.out.println("Array Elements:");
		for(int x:a)
			System.out.print(x+" ");
		System.out.println("Object Element:"+obj2.a);
	}
	public void method(int a[]) {
		for(int i=0;i<10;i++) {
			a[i]=2;
		}
	}
}

class Pass {
	int a;
	public Pass() {
		// TODO Auto-generated constructor stub
	}
	public Pass(int a) {
		// TODO Auto-generated constructor stub
		this.a=a;
	}
	public void method() {
		this.a=15;
	}
}