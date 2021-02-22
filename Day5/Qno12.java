package Day5;

public class Qno12 {
	public static void main(String args[]) {
		int i=1;
		switch (i) {
			case 0:
				System.out.println("zero"); break;
			case 1:
				System.out.println("one"); //It will display one two default since there is no break statement
			case 2:
				System.out.println("two"); 
			default:
				System.out.println("default");
		}
	}
}
