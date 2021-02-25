package day8_Lab2;

public class Lab3 {
	public static void main(String[] args) {
		Stack st1=new FixedStack();
		Stack st2=new DynamicStack();
		st1.pop();
		st1.push();
		st2.pop();
		st2.push();
	}
}

interface Stack {
	public void push();
	public void pop();
}

class FixedStack implements Stack {
	@Override
	public void pop() {
		// TODO Auto-generated method stub
		System.out.println("Pop Method from FixedStack");
	}
	@Override
	public void push() {
		// TODO Auto-generated method stub
		System.out.println("Push Method from FixedStack");
	}
}

class DynamicStack implements Stack {
	@Override
	public void pop() {
		// TODO Auto-generated method stub
		System.out.println("Pop Method from DynamicStack");
	}
	@Override
	public void push() {
		// TODO Auto-generated method stub
		System.out.println("Push Method from DynamicStack");
	}
}