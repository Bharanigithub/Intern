package friday_26_02_2021;

public class Lab51 {
	public static void main(String[] args) {
		c1 obj=new c1();
		c1 obj1=new c2();
		obj.met();
		obj1.met();
	}
}

class c1 {
	int i=5;
	public void met() {
		System.out.println(i);
	}
}

class c2 extends c1 {
	public void met() {
		super.met();
		this.i=10;
		System.out.println(i);
	}
}

