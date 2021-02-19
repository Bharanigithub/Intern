package Day1;
import java.util.*;
public class Pgm4 {
	public static void main(String args[]) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int flag=1;
		if(n==0 || n==1)
			flag=0;
		for(int i=2;i<=n/2;i++)
		{
			if(n%i==0) {
				flag=0;
				break;
			}
		}
		if(flag==0)
			System.out.println("Not a Prime Number!!!");
		else
			System.out.println("Prime Number!!!");
	}
}
