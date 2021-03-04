package day13;

import java.util.*;

public class CollectionDemo2 {
	public static void main(String[] args) {
		Vector<String> v=new Vector<>();
		v.add("Hi");
		v.add("Hello");
		v.add("Welcome");
		Iterator<String> it=v.iterator();
		while(it.hasNext()) {
			System.out.println("From Iterator:"+it.next());
		}
		Enumeration<String> e=v.elements();
		v.add("New Variable");
		while(e.hasMoreElements()) {
			System.out.println("From Enumeration:"+e.nextElement());
		}
	}
}
