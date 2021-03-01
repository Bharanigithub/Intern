package day10;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InterfaceDemo {
	public static void main(String args[]) throws Exception {
		Object hm=new Human();
		Inter in=new Inter();
		//((Human)hm).doCry();
		//StanleyAlopathyMC stanley=new StanleyAlopathyMC();
		//JetAcademy pt=new JetAcademy();
		//hm=Proxy.newProxyInstance(hm.getClass().getClassLoader(), new Class[] {Doctor.class}, new MyInvocationHandler(stanley));
		//Doctor doctor=(Doctor)hm;
		//doctor.doCure();
		//hm=Proxy.newProxyInstance(stanley.getClass().getClassLoader(), new Class[] {Pilot.class}, new MyInvocationHandler(pt));
		//Pilot pilot=(Pilot)hm;
		//pilot.doFly();
		hm=Proxy.newProxyInstance(hm.getClass().getClassLoader(), new Class[] {Doctor.class,Pilot.class}, new MyInvocationHandler(in));
		Doctor doctor=(Doctor)hm;
		doctor.doCure();
		Pilot pt=(Pilot)hm;
		pt.doFly();
	}
	static class MyInvocationHandler implements InvocationHandler {
		Object obj;
		public MyInvocationHandler(Object obj) {
			// TODO Auto-generated constructor stub
			this.obj=obj;
		}
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			// TODO Auto-generated method stub
			Object o=method.invoke(obj, args);
			return o;
		}
		
	}
}

class Human {
	public void doCry() {
		System.out.println("Do Cry!!");
	}
}

interface Doctor {
	public void doCure();
}

class StanleyAlopathyMC implements Doctor {
	@Override
	public void doCure() {
		// TODO Auto-generated method stub
		System.out.println("Cured By Alopathy Medicine!!");
	}
}

class PhysiotheraphyMC implements Doctor {
	@Override
	public void doCure() {
		// TODO Auto-generated method stub
		System.out.println("Cured By Physiotheraphy!!");
	}
}

interface Pilot {
	public void doFly();
}

class JetAcademy implements Pilot {
	@Override
	public void doFly() {
		// TODO Auto-generated method stub
		System.out.println("Becoming pilot by getting Trained in Jet Academy!!");
	}
}

class Inter implements Pilot,Doctor{
	@Override
	public void doCure() {
		// TODO Auto-generated method stub
		System.out.println("Cured By Physiotheraphy!!");
	}
	@Override
	public void doFly() {
		// TODO Auto-generated method stub
		System.out.println("Becoming pilot by getting Trained in Jet Academy!!");
	}
}


