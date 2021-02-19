package package1;

public class PassByEx {
	public static void main(String args[]) {
		Student st=new Student();
		st.set("Bharani");
		String name=st.get();
		System.out.println("Initial String:"+name);
		PBV obj1=new PBV();
		obj1.get(st.get());
		System.out.println("After Pass By Value:"+st.get());
		PBR obj2=new PBR();
		obj2.get(st);
		System.out.println("After Pass By Reference:"+st.get());
	}
}
class Student {
	private String name;
	public void set(String name) {
		this.name=name;
	}
	public String get() {
		return name;
	}
}
class PBV {
	public void get(String name) {
		name="Bharanidharan";
	}
}
class PBR {
	public void get(Student st) {
		st.set("Bharanidharan");
	}
}
