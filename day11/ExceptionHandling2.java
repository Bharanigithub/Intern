package day11;

public class ExceptionHandling2 {
	public static void main(String[] args) {
		Sample sample=new Sample();
		sample.mth1();
	}
}

class Sample {
	public void mth1() {
		mth2();
		System.out.println("Caller");
	}
	public void mth2() {
		try {
			int k=1/0;
			return;
		}
		catch(Exception e) {
			System.out.println("catch Method 2!!");
		}
		finally {
			System.out.println("Finally Method 2!!");
		}
	}
}