package friday_26_02_2021;
import java.util.*;
public class Lab34 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		float avg;
		float sum=0;
		int count=0;
		int n=s.nextInt();
		for(int i=1;i<=n;i=i+2) {
			sum=sum+(float)i;
			count++;
		}
		avg=sum/(float)count;
		System.out.println("Average:"+avg);
	}
}
