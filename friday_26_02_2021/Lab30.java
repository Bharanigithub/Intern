package friday_26_02_2021;
import java.util.*;
public class Lab30 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.next();
		switch(str)
		{
		case "December":
		case "January":
		case "February":	
			System.out.println("Winter Season");
			break;
		case "March":	
		case "April":
		case "May":
			System.out.println("Summer Season");
			break;
		case "June":
		case "July":
		case "August":
			System.out.println("Monsoon Season");
			break;	
		default:
			System.out.println("Post Monsoon Season");
		}
	}
}
