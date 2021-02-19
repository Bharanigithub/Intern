package Day1;
import java.util.*;
public class Pgm6 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int a[]=new int[10];
		System.out.println("Initial Size of an Array:"+a.length);
		System.out.println("Enter the Reallocation Size:");
		int k=s.nextInt();
		a=new int[k];
		System.out.println("Size of an Array after Reallocation:"+a.length);
	}
}
