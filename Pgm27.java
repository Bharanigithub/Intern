package Day1;
import java.util.*;
public class Pgm27 {
	public static void main(String args[]) {
		Scanner s=new Scanner(System.in);
		int n=14000;
		n=n+((n*40)/100);
		n-=1500;
		n=n+((n*12)/100);
		System.out.println(n);
	}
}
