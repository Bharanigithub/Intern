package day11;

public class ExceptionHandling5 {
	public static void main(String[] args) {
		//Excep.Method();
		try {
			Excep.Method();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}

class Excep extends Exception {
	public static void Method() throws Exception {
		throw new CustomClass();
	}
}
