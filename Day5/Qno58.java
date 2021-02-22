package Day5;

class Base1{
protected void amethod(){ System.out.println("amethod");
}//End of amethod
}//End of class base package Class1;
//Class1.java
public class Qno58 extends Base{

public static void main(String argv[]){ Base1 b = new Base1(); b.amethod();
}//End of main
}//End of Class1
