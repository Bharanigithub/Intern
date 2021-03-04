package day13;
import java.util.*;
public class WeakHashMapDemo {
	public static void main(String[] args) {
		Map<MyKey,String> map=new WeakHashMap<>();
		MyKey mk1=new MyKey("a1");
		MyKey mk2=new MyKey("a2");
		MyKey mk3=new MyKey("a3");
		map.put(mk1, "Dog");
		map.put(mk2, "Cat");
		map.put(mk3, "Tiger");
		System.out.println(map);
		mk1=null;
		System.out.println(map);
		System.gc();
		System.out.println(map);
	}
}
