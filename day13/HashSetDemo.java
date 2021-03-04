package day13;

import java.util.*;
public class HashSetDemo {
	public static void main(String[] args) {
		Set<String> set=new HashSet<>();
		set.add("14");
		set.add("12");
		set.add("13");
		System.out.println(set);
		Iterator<String> it=set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
