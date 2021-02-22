package Day5;

public class Qno2 {
	public static void main(String arguments[]) 
	{ 
		//amethod(arguments); We cannot able to make a static reference to non static method
	}
	public void amethod(String[] arguments) { 
		System.out.println(arguments); 
		System.out.println(arguments[1]);
	}
}
