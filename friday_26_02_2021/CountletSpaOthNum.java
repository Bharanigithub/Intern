package friday_26_02_2021;

//import java.util.Scanner;

public class CountletSpaOthNum {
	public static void main(String[] args) {
		//Scanner s=new Scanner(System.in);
		String str="Aa kiuu, I swd skieo 236587. GH kiu: sieo?? 25.33";
		int number=0,letter=0,space=0,other=0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)==' ')
				space++;
			else if((str.charAt(i)>=97 && str.charAt(i)<=122) || (str.charAt(i)>=65 && str.charAt(i)<=90))
				letter++;
			else if((str.charAt(i)>=48 && str.charAt(i)<=57))
				number++;
			else
				other++;
		}
		System.out.println("Spaces:"+space);
		System.out.println("Numbers:"+number);
		System.out.println("Letters:"+letter);
		System.out.println("Others:"+other);
	}
}
