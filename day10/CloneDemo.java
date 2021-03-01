package day10;

public class CloneDemo {
	public static void main(String[] args) throws Exception {
		Example eg1=new Example();
		eg1.name="Hello";
		Example eg2=eg1.Method();
		eg2.name="World";
		System.out.println(eg1.name+" "+eg2.name);
	}
}

class Example implements Cloneable {
	String name;
	public Example() {
		System.out.println("Sheep Object Created!!");
	} 
	public Example Method() throws Exception {
		return (Example)super.clone();
	}
}