package Day1;
import java.util.*;
public class Pgm11 {
	public static void main(String args[]) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the no.of Values: ");
		int n=s.nextInt();
		int k=0,x=1;
		while(x<n)
		{
			k++;
			x=x+k;
		}
		x=1;
		int a[][]=new int[k][k];
		for(int i=0;i<k && x<=n;i++)
			for(int j=0;j<=i && x<=n;j++,x++)
				a[i][j]=x;
		for(int i=0;i<k;i++)
		{
			for(int j=0;j<k;j++)
			{
				if(a[i][j]!=0)
					System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
}
