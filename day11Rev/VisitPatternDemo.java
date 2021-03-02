package day11Rev;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Scanner;
public class VisitPatternDemo {
	public static void main(String[] args) throws Exception {
		Child child=Child.createObject();
		Dog dog=Dog.createObject();
		Scanner s=new Scanner(System.in);
		String str=s.next();
		Item item=(Item)Class.forName(str).getConstructor().newInstance();
		child.playWithDog(dog, item);
	}
}
class Child implements Cloneable {
	private static Child child;
	private Child() {
		
	}
	public static Child createObject() {
		if(child==null)
		{
			child=new Child();
		}
		return child;
	}
	public void playWithDog(Dog dog,Item item) {
		try {
			dog.action(item);
		}
		catch(DogException e) {
			System.out.println(e);
			e.doHandle();
		}
	}
	@Override
	protected Child clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (Child)super.clone();
	}
}
class Dog implements Cloneable{
	private static Dog dog;
	private Dog() {
		
	}
	public static Dog createObject() {
		if(dog==null)
		{
			dog=new Dog();
		}
		return dog;
	}
	public void action(Item item) throws DogException {
		item.execute();
	}
	@Override
	protected Dog clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (Dog)super.clone();
	}
}
abstract class Item {
	public Item() {
		// TODO Auto-generated constructor stub
	}
	public abstract void execute() throws DogException;
}
class Stick extends Item {
	public Stick() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void execute() throws DogException {
		throw new DogStickException("You Beat I Bite!!"); 
	}
}
class Stone extends Item {
	public Stone() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void execute() throws DogException {
		throw new DogStoneException("You Throw I Bark!!");
	}
}

abstract class DogException extends Exception {
	String str;
	public abstract void doHandle();
}

class DogStickException extends DogException {
	public DogStickException(String str) {
		this.str=str;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Exception:"+str;
	}
	@Override
	public void doHandle() {
		// TODO Auto-generated method stub
		Object o=ProxyHandler.getObj();
		StickInterface st=(StickInterface)o;
		st.method(this);
	}
}

class DogStoneException extends DogException {
	private static DogStoneException dst;
	public DogStoneException(String str) {
		this.str=str;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Exception:"+str;
	}
	@Override
	public void doHandle() {
		// TODO Auto-generated method stub
		Object o=ProxyHandler.getObj();
		StoneInterface st=(StoneInterface)o;
		st.method(this);
	}
}

interface StickInterface {
	public void method(DogStickException ee);
}
interface StoneInterface {
	public void method(DogStoneException es);
}
class class1 implements StickInterface {
	@Override
	public void method(DogStickException ee) {
		// TODO Auto-generated method stub
		System.out.println("Stick Exception using visit Pattern");
	}
}
class class2 implements StoneInterface {
	@Override
	public void method(DogStoneException es) {
		// TODO Auto-generated method stub
		System.out.println("Stone Exception using Visit Pattern");
	}
}
class Handler {
	
}
class ProxyHandler {
	static {
		class1 a = new class1();
		class2 b = new class2();
		obj = Proxy.newProxyInstance(Handler.class.getClassLoader(),
				new Class[] { StickInterface.class, StoneInterface.class},
				new MyInvocationHandler(new Object[] { a, b }));

	}
	public static Object obj;

	public static Object getObj() {
		return obj;
	}
}

class MyInvocationHandler implements InvocationHandler {
	Object[] obj;

	public MyInvocationHandler(Object[] obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object returnObject = null;
		for (Object o : obj) {
			Method m[] = o.getClass().getDeclaredMethods();
			// System.out.println("Invoke Method : "+Arrays.toString(m));
			for (Method met : m) {
				try {
					if (met.getName().equals(method.getName())) {
						met.setAccessible(true);
						returnObject = method.invoke(o, args);
						return returnObject;
					}
				} catch (Exception e) {

				}
			}
		}

		return returnObject;

	}
}
