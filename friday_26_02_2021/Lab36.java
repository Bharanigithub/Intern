package friday_26_02_2021;
import java.util.*;
public class Lab36 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the Number:");
		int n=s.nextInt();
		System.out.println("Enter the String:");
		String str=s.next();
		String str1="";
		for(int i=str.length()-1;i>=0;i--) {
			str1=str1+str.charAt(i);
		}
		int k=n,sum=0;
		while(k!=0)
		{
			int b=k%10;
			sum=sum*10+b;
			k=k/10;
		}
		if(sum==n)
			System.out.println("Number is Palindrome");
		else 
			System.out.println("Number is not a Palindrome");
		if(str.equals(str1))
			System.out.println("String is Palindrome");
		else
			System.out.println("String is not a Palindrome");
	}
}
