package friday_26_02_2021;
import java.util.*;
public class Lab25 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int a=s.nextInt();
		int b=s.nextInt();
		int c=s.nextInt();
		int d;
		if(a>b && a>c)
		{
			d=a;
		}
		else if(b>a && b>c)
		{
			d=b;
		}
		else
			d=c;
		System.out.println("Biggest Number : "+d);
	}
}
