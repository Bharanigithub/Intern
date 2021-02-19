package Day1;
import java.util.*;
public class Pgm21 {
	public static void main(String args[]) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the Month:");
		String str=s.next();
		System.out.println("Enter the year:");
		int n=s.nextInt();
		if(str.equals("February"))
		{
			if(n%4==0)
				System.out.println("28");
			else
				System.out.println("27");
		}
		switch(str)
		{
			case "January":
				System.out.println("31");
				break;
			case "March":
				System.out.println("31");
				break;
			case "April":
				System.out.println("30");
				break;
			case "May":
				System.out.println("31");
				break;
			case "June":
				System.out.println("30");
				break;
			case "July":
				System.out.println("31");
				break;
			case "August":
				System.out.println("31");
				break;
			case "September":
				System.out.println("30");
				break;
			case "October":
				System.out.println("31");
				break;
			case "November":
				System.out.println("30");
				break;
			case "December":
				System.out.println("31");
				break;
			
		}
	}
}
