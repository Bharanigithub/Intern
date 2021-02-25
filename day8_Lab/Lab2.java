package day8_Lab;
import java.util.*;
class Complex {
	Complex() {
		a=0;
		b=0;
	}
	Complex(int a,int b) {
		this.a=a;
		this.b=b;
	}
	int a;
	int b;
	public Complex add(Complex c1,Complex c2) {
		Complex c3=new Complex();
		c3.a=c1.a+c2.a;
		c3.b=c1.b+c2.b;
		return c3;
	}
}
public class Lab2 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter Real and Imaginary of Number 1:");
		int a=s.nextInt();
		int b=s.nextInt();
		Complex c1=new Complex(a,b);
		System.out.println("Enter Real and Imaginary of Number 2:");
		int c=s.nextInt();
		int d=s.nextInt();
		Complex c2=new Complex(c,d);
		Complex c3=new Complex().add(c1,c2);
		System.out.println(c3.a+" "+c3.b+"i");
	}
}
