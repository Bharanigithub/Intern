package Day1;
import java.util.*;
public class Pgm16 {
	public static void main(String args[]) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
			a[i]=s.nextInt();
		System.out.println("Enter the element to search:");
		int e=s.nextInt();
		int count=0;
		List<Integer> al=new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			if(a[i]==e)
			{
				count++;
				al.add(i+1);
			}
		}
		if(count==0)
			System.out.println("Element not found");
		else
		{
			System.out.println("Found "+count+" times");
			System.out.println("Positions are:");
			for(int i=0;i<count;i++)
				System.out.print(al.get(i)+" ");
		}
	}
}
