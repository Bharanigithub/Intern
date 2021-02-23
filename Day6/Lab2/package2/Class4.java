package package2;
import package1.Class2;
class Class4 extends Class2 {
	public void Method4() {
		System.out.println(pri);
		System.out.println(def);
		System.out.println(pro);
		System.out.println(pub);
	}
}

class Class5 {
	public void Method5() {
		Class2 obj3=new Class2();
		System.out.println(obj3.pri);
		System.out.println(obj3.def);
		System.out.println(obj3.pro);
		System.out.println(obj3.pub);
	}
}