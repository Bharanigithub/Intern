package Day1;
import java.util.*;
public class Pgm13 {
	public static void main(String args[]) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the no. of Students:");
		int r=s.nextInt();
		System.out.println("Enter the no. of Subjects:");
		int c=s.nextInt();
		int a[][]=new int[r][c];
		for(int i=0;i<r;i++)
		{
			System.out.println("Student "+(i+1));
			for(int j=0;j<c;j++)
			{
				System.out.println("Enter the Mark of Subject "+(j+1));
				a[i][j]=s.nextInt();
			}
		}
		for(int i=0;i<r;i++)
		{
			float sum=0;
			for(int j=0;j<c;j++)
			{
				sum=sum+(float)a[i][j];
			}
			System.out.println("Student "+(i+1)+"has Secured "+((int)(sum))+" Marks with the percentage of "+(sum)/(float)c);
		}
		
	}
}
