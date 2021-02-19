package Day1;

import java.util.Scanner;

public class Pgm15_b {
	public static void main(String args[]) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		String str=Integer.toString(n);
		int amstrong_no=0,len=str.length()-1,palindrome=1;
		for(int i=0;i<str.length();i++)
		{
			int num=(int)(str.charAt(i))-48;
			amstrong_no+=(num*num*num);
			if(str.charAt(len)!=str.charAt(i))
			{
				palindrome=0;
				len--;
			}
		}
		int perfect=0;
		for(int i=1;i<n;i++)
		{
			if(n%i==0)
				perfect+=i;
		}
		if(amstrong_no==n)
			System.out.println("The Given number is Amstrong Number");
		if(palindrome==1)
			System.out.println("The Giver number is Palindrome");
		if(perfect==n)
			System.out.println("The Giver number is Perfect Number");
	}
}
