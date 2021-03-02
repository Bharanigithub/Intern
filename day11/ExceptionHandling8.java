package day11;
import java.util.*;
public class ExceptionHandling8 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int count=0,marks=0;
		while(count<10) {
			System.out.println("Enter the Mark of Student "+(count+1)+":");
			String str=s.next();
			try {
				marks+=Integer.parseInt(str);
				count++;
			}
			catch(NumberFormatException e) {
				System.out.println(e);
			}
		}
		float f=(float)marks/10.0f;
		System.out.println("Average:"+f);
	}
}
