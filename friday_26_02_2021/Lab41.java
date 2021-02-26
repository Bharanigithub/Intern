package friday_26_02_2021;

import java.util.Scanner;

public class Lab41 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int j=1;
		for(int i=0;i<n;i++)
		{
			for(int k=0;k<=i;k++,j++)
			{
				System.out.print(j+" ");
			}
			System.out.println();
		}
		for(int i=0;i<n;i++)
		{
			for(int k=0;k<=i;k++)
			{
				System.out.print(0+" ");
			}
			System.out.println();
		}
	}
}
