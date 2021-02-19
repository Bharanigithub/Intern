package package1;

public class Polymorphism {
	int no;
	public static void main(String[] args) {
		Polymorphism obj=new Polymorphism();
		obj.met(5);
		int k=obj.met(1,2,3,4,5);
		System.out.println(k);
		String str=obj.met("HI");
		System.out.println(str);
	}
	
	public void met(int n) {
		System.out.println(n);
	}
	
	public int met(int... n) {
		for(int x:n) {
			System.out.println(x);
		}
		return 1;
	}
	
	public String met(String s) {
		return s;
	}
	
	public Polymorphism met1(int n) {
		return new Polymorphism();
	}
	
}


