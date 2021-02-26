package friday_26_02_2021;
import java.util.*;
public class Lab50 {
	public static void main(String args[]) {
		Class1 c1=new Class2();
		Class2 c2=new Class3();
		c1.met1();
		c1.met2();
		c2.met1();
		c2.met2();
	}
}

abstract class Class1 {
	public final void met1() {
		System.out.println("Parent Method");
	}
	public abstract void met2();
}

class Class2 extends Class1 {
	 @Override
	public void met2() {
		System.out.println("Child 1");
	}
}

class Class3 extends Class2 {
	public void met2() {
		System.out.println("Child 2");
	}
}