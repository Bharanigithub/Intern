package day11;

import java.io.IOException;

public class ExceptionHandling4 {
	public static void main(String[] args){
		try {
			method();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public static void method() throws Exception {
		throw new CustomClass1("User Defined Exception");
	}
}

class CustomClass1 extends Exception {
	String s;
	public CustomClass1(String s) {
		this.s=s;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Exception:"+s;
	}
}