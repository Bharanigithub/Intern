package day8_Lab;

import java.util.Scanner;
class Stack {
	
	Stack(int data) {
		this.data=data;
		this.stack=null;
	}
	int data;
	Stack stack;
	Stack push(Stack tp,Stack st) {
		st.stack=tp;
		tp=st;
		return tp;
	}
}

public class Lab4 {
	static Stack top=null;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		for(int i=0;i<n;i++) {
			int d=s.nextInt();
			Stack stack=new Stack(d);
			if(i==0)
				top=stack;
			else
				top=stack.push(top,stack);
		}
		Stack tp=top;
		while(tp!=null)
		{
			System.out.print(tp.data+" ");
			tp=tp.stack;
		}
	}
}
