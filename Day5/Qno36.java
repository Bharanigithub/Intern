package Day5;

public class Qno36 {
	public static void main(String argv[]) { 
		Qno36 e=new Qno36();
	}
	Qno36() {
		String s="Java"; String s2="java";
		if(s==s2) { System.out.println("Equal");
	}
		if(s.equals(s2)) { System.out.println("Equal");
		}
		if(s.equalsIgnoreCase(s2)) { System.out.println("Equal");
		}
		/*if(s.noCaseMatch(s2)) { System.out.println("Equal");
		}*/
	else
	{
		System.out.println("Not equal");
	}
}
}
