package day8_Lab;

public class Lab8 {
	private static Lab8 obj=new Lab8();
	private Lab8() {
		
	}
	void getMethod() {
		System.out.println("Hi");
	}
	public static void main(String[] args) {
		obj.getMethod();
	}
}
