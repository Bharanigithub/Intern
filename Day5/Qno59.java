package Day5;

class Base2{
private void amethod(int iBase){ System.out.println("Base.amethod");
}
}

class Qno59 extends Base{


public static void main(String argv[]){ Qno59 o = new Qno59();
int iBase=0; o.amethod(iBase);
}
public void amethod(int iOver){ System.out.println("Over.amethod");
}

}
