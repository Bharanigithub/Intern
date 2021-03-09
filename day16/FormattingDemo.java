package day16;

public class FormattingDemo {
	public static void main(String[] args) {
		System.out.printf("String Formatting Example %d %f %s %04d %.3f", 20,12.54564f,"Hello World",10,15.2365897f);
		String s=String.format("\nString Format Function %d %f %s", 1,0.1f,"Hai");
		System.out.println(s);
		System.out.printf("\n%-15s%-15s%s","column1","column2","column3");
	}
}
