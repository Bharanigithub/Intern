package Day1;
import java.util.*;
public class Pgm19 {
	public static void main(String args[]) {
		Scanner s=new Scanner(System.in);
		int row=s.nextInt();
		int col=s.nextInt();
		int a[][]=new int[row][col];
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				a[i][j]=s.nextInt();
			}
		}
		for(int i=0;i<row;i++)
		{
			int k=col-1;
			for(int j=0;j<col/2;j++)
			{
				int temp=a[i][j];
				a[i][j]=a[i][k];
				a[i][k]=temp;
				k--;
			}
		}
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				System.out.print(a[i][j]+" ");;
			}
			System.out.println();
		}

	}
}
