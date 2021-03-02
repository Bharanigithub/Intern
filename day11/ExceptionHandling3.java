package day11;

public class ExceptionHandling3 {
	public static void main(String[] args) {
		Sample1 sample=new Sample1();
		sample.mth1();
	}
}

class Sample1 {
	public void mth1() {
		mth2();
		System.out.println("Caller");
	}
	public void mth2() {
		try {
			//int k=1/0;
			System.exit(0);
			int k=1/0;
		}
		catch(Exception e) {
			System.out.println("catch Method 2!!");
		}
		finally {
			System.out.println("Finally Method 2!!");
		}
	}
}