package day11;

import java.io.IOException;

public class ExceptionHandling1 {
	public static void main(String[] args){
		CustomClass cl=new CustomClass();
		/*try {
			cl.method();
		}
		catch(Exception e) {
			System.out.println(e);
		}*/
		cl.method();
	}
}

class CustomClass extends Exception {
	public static void method() throws Exception {
		throw new IOException();
	}
}