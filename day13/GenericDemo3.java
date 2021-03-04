package day13;

public class GenericDemo3 {
	public static void main(String[] args) {
		GenericDemo3 obj=new GenericDemo3();
		obj.getObject(new Integer[] {1,2,3});
		obj.getObject(new String[] {"hi","hello"});
	}
	public <E> E getObject(E[] element) {
		for(E e:element) {
			System.out.println(e);
		}
		return null;
	}
}
