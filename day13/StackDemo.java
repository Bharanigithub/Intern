package day13;
import java.util.*;
public class StackDemo {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		Stack<Integer> stack=new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		System.out.println(stack);
		System.out.println(stack.peek());
		stack.pop();
		System.out.println(stack);
		System.out.println("Enter the element to search:");
		int e=s.nextInt();
		if(stack.search(e)>=0)
			System.out.println("Element found at position "+stack.search(e));
		else
			System.out.println("Element Not Found");
	}
}
