package Day1;
import java.util.*;
public class Pgm20 {
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
			int max=a[i][0];
			for(int j=0;j<col;j++)
			{
				if(a[i][j]>max)
					max=a[i][j];
			}
			System.out.println("Maximum element in row "+(i+1)+": "+max);
		}
	}
}
