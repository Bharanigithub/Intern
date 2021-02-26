package friday_26_02_2021;

import java.util.Scanner;

public class Lab43 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=s.nextInt();
		}
		int max=a[0],min=a[0];
		for(int i=1;i<n;i++) {
			if(a[i]>max)
				max=a[i];
			if(a[i]<min)
				min=a[i];
		}
		System.out.println("Max:"+max);
		System.out.println("Min:"+min);
	}
}	
