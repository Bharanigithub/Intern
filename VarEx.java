package package1;

public class VarEx {
	public static void main(String args[])
	{
		Patient pt1=new Patient();
		Patient pt2=new Patient();
	}
}
class Patient {
	public Patient() {
		System.out.println("Patient Admitted!!");
	}
	Bed bd=new Bed();
	static Hospital hp=new Hospital();
}
class Bed {
	public Bed() {
		System.out.println("Bed Allotted!!");
	}
}
class Hospital{
	public Hospital() {
		System.out.println("Hospital Allotted!!");
	}
}
