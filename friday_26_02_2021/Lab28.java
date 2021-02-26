package friday_26_02_2021;
import java.util.*;
public class Lab28 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.next();
		if(str.equals("December") || str.equals("January") || str.equals("February"))
			System.out.println("Winter Season");
		else if(str.equals("March") || str.equals("April") || str.equals("May"))
			System.out.println("Summer Season");
		else if(str.equals("June") || str.equals("July") || str.equals("August") || str.equals("September"))
			System.out.println("Monsoon Season");
		else 
			System.out.println("Post Monsoon Season");
	}
}
