package friday_26_02_2021;

public class Lab54 {
	public static void main(String[] args) {
		Inter in=new Print();
		in.printInteger();
	}
}

interface Inter {
	public void printInteger();
}

class Print implements Inter {
	@Override
	public void printInteger() {
		// TODO Auto-generated method stub
		System.out.println("10");
	}
}