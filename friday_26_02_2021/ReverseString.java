package friday_26_02_2021;
import java.util.Scanner;
public class ReverseString {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.next();
		String str1="";
		for(int i=str.length()-1;i>=0;i--) {
			str1=str1+str.charAt(i);
		}
		System.out.println(str1);
	}
}
