package day13;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
public class ForkJoinDemo {
	public static void main(String[] args) {
		StringArray sar=new StringArray();
		int cnt=0;
		for(String s:sar.arr) {
			if(s.equals("Ramu")) {
				cnt++;
			}
		}
		System.out.println("No. of Ramu's:"+cnt);
		OurTask task1=new OurTask(0,3,sar.arr,"Ramu");
		OurTask task2=new OurTask(3,6,sar.arr,"Ramu");
		OurTask task3=new OurTask(6,8,sar.arr,"Ramu");
		OurTask task4=new OurTask(8,10,sar.arr,"Ramu");
		ForkJoinPool fjp=ForkJoinPool.commonPool();
		int result1=fjp.invoke(task1);
		int result2=fjp.invoke(task2);
		int result3=fjp.invoke(task3);
		int result4=fjp.invoke(task4);
		System.out.println("No.of Ramu's using Fork and Join:"+(result1+result2+result3+result4));
	}
}
class OurTask extends RecursiveTask<Integer> {
	int start;
	int end;
	String arr[];
	String str;
	public OurTask(int start,int end,String arr[],String str) {
		// TODO Auto-generated constructor stub
		this.start=start;
		this.end=end;
		this.arr=arr;
		this.str=str;
	}
	@Override
	protected Integer compute() {
		// TODO Auto-generated method stub
		int cnt=0;
		for(int i=start;i<end;i++) {
			if(arr[i].equalsIgnoreCase(str)) {
				cnt++;
			}
		}
		return cnt;
	}
}
class StringArray {
	String arr[]= {"Ramu","Ravi","Vignesh","Suresh","Sundar","Ramu","Somu","Venkat","Ramu","Rakesh"};
}