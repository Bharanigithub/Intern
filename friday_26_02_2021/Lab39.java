package friday_26_02_2021;

import java.util.Scanner;

public class Lab39 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int i=1;
		do {
			System.out.println(n+"*"+i+"="+(n*i));
			i++;
		}while(i<=20);
	}
}
