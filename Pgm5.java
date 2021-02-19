package Day1;
import java.util.*;
public class Pgm5 {
	public static float fun(int a[]) {
		float sum=0;
		for(int i=0;i<a.length;i++)
			sum=sum+(float)a[i];
		return sum/(float)a.length;
	}
	public static void main(String args[]) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
			a[i]=s.nextInt();
		float k=fun(a);
		System.out.println(k);
	}
}
