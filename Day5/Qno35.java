package Day5;

public class Qno35{
public static void main(String argv[]) { 
	Qno35 c=new Qno35();
	String s=new String("ello"); 
	c.amethod(s);
	}
	public void amethod(String s) { 
		char c='H';
		// c+=s; can't able to add String in the character 
		System.out.println(c);
	}
}
