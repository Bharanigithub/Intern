package friday_26_02_2021;

import java.util.Scanner;

public class Lab38 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int a[]=new int[n];
		if(n==1)
			a[0]=0;
		else if(n==2) {
			a[0]=0;
			a[1]=1;
		}
		else {
			a[0]=0;
			a[1]=1;
			for(int i=2;i<n;i++)
			{
				a[i]=a[i-1]+a[i-2];
			}
		}
		for(int i=0;i<n;i++)
			System.out.print(a[i]+" ");
	}
}
