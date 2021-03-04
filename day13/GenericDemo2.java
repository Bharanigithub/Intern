package day13;
import java.util.ArrayList;
public class GenericDemo2 {
	public static void main(String[] args) {
		ArrayList<String> al=new ArrayList();
		al.add("Hi");
		al.add("Hello");
		//al.add(3);
		for(int i=0;i<al.size();i++) {
			String s=(String)al.get(i);
			System.out.println(s);
		}
	}
}
