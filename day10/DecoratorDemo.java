package day10;

public class DecoratorDemo {
	public static void main(String[] args) throws Exception {		
		Vanila vanila=Vanila.createObject();
		DryFruit dryFruit=DryFruit.createObject();
		Vanila vanila2=vanila.CreateClone();
		IceCream iceCream=dryFruit.CreateClone(vanila.CreateClone(vanila2));
		System.out.println(iceCream.cost());
	}
}

abstract class IceCream {
	public abstract int cost();
	
}

abstract class Cream extends IceCream {
	
}

abstract class IceCreamIngredients extends IceCream {
	
}

class Vanila extends Cream implements Cloneable {
	private static Vanila vanila;
	private IceCream iceCream;
	private Vanila() {
		System.out.println("Vanila Object Created!!");
	}
	private Vanila(IceCream iceCream) {
		this.iceCream=iceCream;
		System.out.println("Vanila Object Created!!");
	}
	public static Vanila createObject() {
		if(vanila == null) vanila = new Vanila();
		return vanila;
	}
	
	public static Vanila createObject(IceCream iceCream) {
		if(vanila == null) vanila = new Vanila(iceCream);
		return vanila;
	}
	
	public Vanila CreateClone() throws Exception{
		return (Vanila)super.clone();
	}
	
	public Vanila CreateClone(IceCream iceCream) throws Exception{
		this.iceCream=iceCream;
		return (Vanila)super.clone();
	}
	
	@Override
	public int cost() {
		// TODO Auto-generated method stub
		if(iceCream==null)
			return 10;
		else 
			return 10+(iceCream.cost());
	}
}

class Strawberry extends Cream implements Cloneable {
	private static Strawberry strawberry;
	private IceCream iceCream;
	private Strawberry() {
		System.out.println("Strawberry Object Created!!");
	}
	private Strawberry(IceCream iceCream) {
		this.iceCream=iceCream;
		System.out.println("StrawBerry Object Created!!");
	}
	
	public static Strawberry createObject() {
		if(strawberry == null) strawberry = new Strawberry();
		return strawberry;
	}
	
	public static Strawberry createObject(IceCream iceCream) {
		if(strawberry == null) strawberry = new Strawberry(iceCream);
		return strawberry;
	}
	
	public Strawberry CreateClone() throws Exception{
		return (Strawberry)super.clone();
	}
	
	public Strawberry CreateClone(IceCream iceCream) throws Exception{
		this.iceCream=iceCream;
		return (Strawberry)super.clone();
	}
	
	@Override
	public int cost() {
		// TODO Auto-generated method stub
		if(iceCream==null)
			return 10;
		else 
			return 10+(iceCream.cost());
	}
}

class DryFruit extends IceCreamIngredients implements Cloneable {
	private IceCream iceCream;
	private static DryFruit dryFruit;
	private DryFruit() {
		System.out.println("Dry Fruit Object Created!!");
	}
	private DryFruit(IceCream iceCream) {
		this.iceCream=iceCream;
		System.out.println("Dry Fruit Object Created!!");
	}
	
	public static DryFruit createObject() {
		if(dryFruit == null) dryFruit = new DryFruit();
		return dryFruit;
	}
	
	public static DryFruit createObject(IceCream iceCream) {
		if(dryFruit == null) dryFruit = new DryFruit(iceCream);
		return dryFruit;
	}
	
	public DryFruit CreateClone() throws Exception{
		return (DryFruit)super.clone();
	}
	
	public DryFruit CreateClone(IceCream iceCream) throws Exception{
		this.iceCream=iceCream;
		return (DryFruit)super.clone();
	}
	
	@Override
	public int cost() {
		// TODO Auto-generated method stub
		if(iceCream==null)
			return 5;
		else 
			return 5+(iceCream.cost());
	}
}

