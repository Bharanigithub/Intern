package friday_26_02_2021;

public class Lab47 {
	Lab47(int a) {
		System.out.println("Overloading Constructer 1");
	}
	Lab47(int a,int b) {
		System.out.println("Overloading Constructor 2");
	}
	public static int add(int a,int b) {
		return a+b;
	}
	public static int add(int a,int b,int c) {
		return a+b+c;
	}
	public static int add(int a,int b,int c,int d) {
		return a+b+c+d;
	}
	public static void main(String[] args) {
		int a,b,c;
		a=add(10,20);
		b=add(10,20,30);
		c=add(10,20,30,40);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		Lab47 lb1=new Lab47(10);
		Lab47 lb2=new Lab47(10,20);
	}
}
