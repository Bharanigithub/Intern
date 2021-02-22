package Day5;

abstract class MineBase {
abstract void amethod(); 
static int i;
}
public class Qno11 extends MineBase	{ 
	public void amethod() {
		//Extended class should inherit the abstract Method MineBase
	}
	public static void main(String argv[]) {
		int[] ar=new int[5]; for(i=0;i < ar.length;i++)
			System.out.println(ar[i]);
	}
}
