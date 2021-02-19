package Day1;
import java.util.*;
public class Pgm10 {
	public static void main(String args[]) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the Row and Columns:");
		int m=s.nextInt();
		int n=s.nextInt();
		int a[][]=new int[m][n];
		System.out.println("Enter the Array Elements:");
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				a[i][j]=s.nextInt();
		System.out.println("Given Matrix:");
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
}
