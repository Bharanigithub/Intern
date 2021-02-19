package Day1;
import java.util.*;
public class Pgm8 {
	public static void main(String args[]) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
			a[i]=s.nextInt();
		System.out.println("Enter the Element to find the location:");
		int e=s.nextInt();
		int loc=-1;
		for(int i=0;i<n;i++)
		{
			if(a[i]==e)
			{
				loc=i+1;
				break;
			}
		}
		if(loc==-1)
			System.out.println("Element Not Found");
		else
			System.out.println("Element Found at Location "+loc);
	}
}
