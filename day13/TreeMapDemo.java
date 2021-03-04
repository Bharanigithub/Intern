package day13;
import java.util.*;
public class TreeMapDemo {
	public static void main(String[] args) {
		Map<MyKey,String> map=new TreeMap<>();
		map.put(new MyKey("1"), "HI");
		map.put(new MyKey("3"), "WELCOME");
		map.put(new MyKey("2"), "HELLO");
		System.out.println(map);
		Set<Map.Entry<MyKey, String>> set=map.entrySet();
		Iterator<Map.Entry<MyKey, String>> it=set.iterator();
		while(it.hasNext()) {
			Map.Entry<MyKey, String> mp=it.next();
			System.out.println(mp.getKey()+" "+mp.getValue());
		}
	}
}
class MyKey implements Comparable<MyKey> {
	String key;
	public MyKey(String key) {
		// TODO Auto-generated constructor stub
		this.key=key;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return key;
	}
	@Override
	public int compareTo(MyKey o) {
		return this.key.compareTo(o.key);
	}
}
