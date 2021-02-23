package Day6;

class Parent {
	Parent() {
		System.out.println("Parent Constructor");
	}
	public void method() {
		System.out.println("Parent Method");
	}
}

class Child extends Parent {
	Child() {
		System.out.println("Child Constructor");
	}
	public void method() {
		super.method();
		System.out.println("Child Method");
	}
}

public class OverridingDemo {
	public static void main(String args[]) {
		Parent p=new Child();
		p.method();
	}
}
