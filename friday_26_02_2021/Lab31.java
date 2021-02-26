package friday_26_02_2021;

import java.util.Scanner;

public class Lab31 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter two Numbers");
		int a=s.nextInt();
		int b=s.nextInt();
		System.out.println("Enter the operation to Perform:");
		System.out.println("1.Add 2.Subtract 3.Multiply 4.Division");
		int n=s.nextInt();
		int k;
		switch(n)
		{
		case 1:
			k=a+b;
			System.out.println(k);
			break;
		case 2:
			k=a+b;
			System.out.println(k);
			break;
		case 3:
			k=a+b;
			System.out.println(k);
			break;
		case 4:
			k=a+b;
			System.out.println(k);
			break;
		}
	}
}

