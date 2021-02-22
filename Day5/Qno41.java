package Day5;

public class Qno41{
static int j=20;
public static void main(String argv[]){ int i=10;
Qno41 p = new Qno41(); p.amethod(i); System.out.println(i); System.out.println(j);
}
public void amethod(int x){ x=x*2;
j=j*2;
}
}
