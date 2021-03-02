package day11;

import java.util.Scanner;
public class ExceptionHandling9 {
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		int count=0,marks=0;
		while(count<10) {
			System.out.println("Enter the Mark of Student "+(count+1)+":");
			String str=s.next();
			try {
				int k=Integer.parseInt(str);
				Method(k);
				marks+=k;
				count++;
			}
			catch(MyClass ee) {
				System.out.println(ee);
			}
			catch(NumberFormatException e) {
				System.out.println(e);
			}
		}
		float f=(float)marks/10.0f;
		System.out.println("Average:"+f);
	}
	public static void Method(int marks) throws MyClass {
		if(marks<0)
		{
			throw new MyClass("Entered Marks is Lesser than zero");
		}
		else if(marks>100)
		{
			throw new MyClass("Entered Marks is Greater than 100");
		}
	}
}

class MyClass extends Exception {
	public MyClass() {
		// TODO Auto-generated constructor stub
	}
	String str;
	public MyClass(String str) {
		// TODO Auto-generated constructor stub
		this.str=str;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Exception:-"+str;
	}
}