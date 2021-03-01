package day10;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class GCDemo {
	public static void main(String[] args) {
		Runtime r=Runtime.getRuntime();
		System.out.println("Before thatha's Birth:"+r.freeMemory());
		Thatha t=new Thatha();
		System.out.println("After thatha's Birth:"+r.freeMemory());
		System.out.println("Thatha lives sometime");
		//WeakReference wf=new WeakReference(t);
		SoftReference sf=new SoftReference(t);
		t=null;
		System.out.println("After thatha's Death:"+r.freeMemory());
		System.out.println("Thatha Kariyam starts!!");
		r.gc();
		System.out.println(t);
		t=(Thatha)sf.get();
		System.out.println(t);
		System.out.println("After Kariyam:"+r.freeMemory());
	}
}

class Thatha {
	String space;
	public Thatha() {
		for(int i=0;i<10000;i++) {
			space=new String(" "+i);
		}
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("Finalize Method!!");
	}
}