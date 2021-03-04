package day13;
import java.util.*;
public class TreeSetDemo {
	public static void main(String[] args) {
		Set<String> set=new TreeSet<>((s1,s2)->{return s2.compareTo(s1);});
		set.add("Welcome");
		set.add("Hello");
		set.add("Hi");
		System.out.println(set);
		Iterator<String> it=set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
