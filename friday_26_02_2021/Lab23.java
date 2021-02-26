package friday_26_02_2021;

public class Lab23 {
	static final float pi=3.14f;
	public static void main(String args[]) {
		int r=5,h=6;
		float f1=area(pi,r,h);
		int mass=5,acceleration=6,height=7,velocity=10;
		float f2=Energy(mass,acceleration,height,velocity);
		System.out.println("Area:"+f1);
		System.out.println("Energy:"+f2);
	}
	public static float Energy(int mass,int acceleration,int height,int velocity) {
		float f=mass*((acceleration*height)+(velocity*velocity)/2);
		return f;
	}
	public static float area(float pi,int r,int h) {
		float f=(pi*r*r)+(2*pi*r*h);
		return f;
	}
}
