package Day1;
import java.util.*;
public class Pgm18 {
	public static void main(String args[]) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		String str=Integer.toString(n);
		String st[]= {"zero","one","two","three","four","five","six","seven","eight","nine"};
		for(int i=0;i<str.length();i++)
		{
			int k=Integer.parseInt(str.substring(i,i+1));
			System.out.print(st[k]+" ");
		}
	}
}
