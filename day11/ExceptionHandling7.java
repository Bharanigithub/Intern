package day11;
import java.util.Scanner;
public class ExceptionHandling7 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		while(true) {
			String str=s.next();
			String str2=s.next();
			try {
				method(str,str2);
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
	}
	public static void method(String str,String str2) {
		if(str.charAt(0)=='q' || str.charAt(0)=='Q')
		{
			System.exit(0);
		}
		int k=Integer.parseInt(str);
		int k2=Integer.parseInt(str2);
		System.out.println(k/k2);
	}
}
