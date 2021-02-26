package friday_26_02_2021;
import java.util.*;
public class Lab32 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int flag=1;
		for(int i=2;i<=n/2;i++)
		{
			if(n%i==0)
			{
				flag=0;
				break;
			}
		}
		if(flag==1)
			System.out.println("Prime Number!!");
		else
			System.out.println("Not a Prime Number!!");
	}
}
