package Day1;

public class Pgm23 {
	protected int a;
	public static void main(String args[]) {
		Exmpl obj2=new Exmpl();
		obj2.method();
	}
}

class Exmpl {
	public void method()
	{
		Pgm23 obj1=new Pgm23();
		obj1.a=5;
		System.out.println(obj1.a);
	}
}
