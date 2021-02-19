package Day1;
import java.util.*;
public class Pgm9 {
	public static void main(String args[]) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=s.nextInt();
		}
		for(int i=0;i<=n/2;i++)
		{
			int temp=a[i];
			a[i]=a[n-i-1];
			a[n-i-1]=temp;
		}
		System.out.println();
		for(int i=0;i<n;i++)
			System.out.print(a[i]+" ");
	}
}
