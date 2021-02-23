package Day6;
import java.util.Scanner;
public class KaithanFan {
	public static void main(String args[]) throws Exception {
		FanOOPS obj2;
		//Scanner s=new Scanner(System.in);
			obj2=Container.Method1(args[0]);
			obj2.FanState();
	}
}

class FanOOPS {
	Fan fan;
	public void FanState() {
		fan.changeState();
	}
}

class Container {
	public static FanOOPS Method1(String s) throws Exception {
		FanOOPS obj=new FanOOPS();
		Fan obj1=(Fan)Class.forName(s).newInstance();
		obj.fan=obj1;
		return obj;
	}
}

abstract class Fan {
	public Fan var;
	public abstract void changeState();
}

class SwitchOnState extends Fan {
	@Override
	public void changeState() {
		// TODO Auto-generated method stub
		var=new MediumState();
		System.out.println("Fan is Switched On!!");
		var.changeState();
	}
}

class MediumState extends Fan {
	@Override
	public void changeState() {
		// TODO Auto-generated method stub
		var=new FastState();
		System.out.println("Fan is in Medium Speed!!");
		var.changeState();
	}
}

class FastState extends Fan {
	@Override
	public void changeState() {
		// TODO Auto-generated method stub
		var=new SwitchOffState();
		System.out.println("Fan is in High Speed!!");
		var.changeState();
	}
}

class SwitchOffState extends Fan {
	@Override
	public void changeState() {
		// TODO Auto-generated method stub
		System.out.println("Fan is Switched Off!!");
	}
	
}