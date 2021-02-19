package Day1;
import java.util.*;
public class Pgm24 {
	private int a;
	private int b;
	private int c;
	public Pgm24() {
		a=1;
		b=1;
		c=1;
	}
	public Pgm24(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public int getA() {
		return a;
	}
	public int getB() {
		return b;
	}
	public int getC() {
		return c;
	}
	void set(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	int compute(int x) {
		int ans=0;
		ans=(a*x*x)+(b*x)+c;
		return ans;
	}
	public static void main(String args[]) {
		Pgm24 obj=new Pgm24();
		Pgm24 obj1=new Pgm24(2,3,4);
		obj.set(7, 8, 9);
		System.out.println("Output of Equation 1"+obj.getA()+" "+obj.getB()+" "+obj.getC()+" is "+obj.compute(2)+" when the value of x is 2");
		System.out.println("Output of Equation 2"+obj1.getA()+" "+obj1.getB()+" "+obj1.getC()+" is "+obj1.compute(4)+" when the value of x is 4");
		
	}
}