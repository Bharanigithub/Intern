package package1;

public class Class1 {
	public static void main(String[] args) {
		System.out.println("Introduction to Access Specifiers!!!");
	}
}

class Class3 extends Class2 {
	public void Method2()
	{
		System.out.println(pri);
		System.out.println(def);
		System.out.println(pro);
		System.out.println(pub);
	}
}

class Class4
{
	public void Method3()
	{
		Class2 obj1=new Class2();
		System.out.println(obj1.pri);
		System.out.println(obj1.def);
		System.out.println(obj1.pro);
		System.out.println(obj1.pub);
	}
}