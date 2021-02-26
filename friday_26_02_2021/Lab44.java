package friday_26_02_2021;
import java.util.*;
public class Lab44 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the No. of elements in array:");
		int n=s.nextInt();
		int a[]=new int[n];
		int b[]=new int[n];
		System.out.println("Enter the first array elements:");
		for(int i=0;i<n;i++) {
			a[i]=s.nextInt();
		}
		System.out.println("Enter the Second array elements:");
		for(int i=0;i<n;i++) {
			b[i]=s.nextInt();
		}
		for(int i=0;i<n;i++)
		{
			a[i]=a[i]+b[i];
			b[i]=a[i]-b[i];
			a[i]=a[i]-b[i];
		}
		System.out.println("After Swapping:");
		System.out.println("First Array Elements:");
		for(int i=0;i<n;i++)
			System.out.print(a[i]+" ");
		System.out.println("");
		System.out.println("Second Array Elements:");
		for(int i=0;i<n;i++)
			System.out.print(b[i]+" ");
	}
}
