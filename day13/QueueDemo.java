package day13;
import java.util.*;
public class QueueDemo {
	public static void main(String[] args) {
		Queue<Integer> queue=new LinkedList<>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		System.out.println(queue);
		Iterator<Integer> it=queue.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println(queue.remove()+" Element Removed");
		System.out.println("New Size "+queue.size());
	}
}
