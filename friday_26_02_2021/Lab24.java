package friday_26_02_2021;

public class Lab24 {
	public static void main(String args[]) {
		int square_side=5;
		int rec_length=3;
		int rec_breadth=6;
		int rec_area=area(rec_length,rec_breadth);
		int rec_perimeter=perimeter(rec_length,rec_breadth);
		int square_area=area(square_side);
		int square_perimeter=perimeter(square_side);
		System.out.println("Area of Rectangle:"+rec_area);
		System.out.println("Perimeter of Rectangle:"+rec_perimeter);
		System.out.println("Area of Square:"+square_area);
		System.out.println("Perimeter of Square:"+square_perimeter);
	}
	public static int area(int l,int b) {
		return l*b;
	}
	public static int area(int a) {
		return a*a;
	}
	public static int perimeter(int l,int b) {
		return 2*(l+b);
	}
	public static int perimeter(int a)
	{
		return 4*a;
	}
	
}


