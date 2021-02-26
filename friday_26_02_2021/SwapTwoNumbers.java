package friday_26_02_2021;
import java.util.Scanner;
public class SwapTwoNumbers {
	public static void main(String args[]) {
		Scanner s=new Scanner(System.in);
		int a=s.nextInt();
		int b=s.nextInt();
		System.out.println("Before Swapping: A="+a+" B="+b);
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println("After Swapping: A="+a+" B="+b);
	}
}
