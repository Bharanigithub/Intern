package Day6;


abstract class DominosPizza {
	final public void selectFlour() {
		System.out.println("Aata Selected or Provided By Dominos Pizza!!!");
	}
	final public void selectIngredients() {
		System.out.println("Ingredients Selected or Provided by Dominos Pizza!!!");
	}
	final public void packet() {
		System.out.println("Use the Box which was provided by Dominos Pizza!!!");
	}
	public abstract void prepare();
	public abstract void Delivery();
	final public void makePizza() {
		selectFlour();
		selectIngredients();
	}
}

class EroPizza extends DominosPizza{
	@Override
	public void Delivery() {
		// TODO Auto-generated method stub
		prepare();
		packet();
		System.out.println("Out for Delivery!!!");
	}
	@Override
	public void prepare() {
		// TODO Auto-generated method stub
		makePizza();
		System.out.println("Cooking...!!!");
		}
	}

public class InheritanceAbstractDemo {
	public static void main(String args[]) {
		DominosPizza dp=new EroPizza();
		dp.Delivery();
	}
}
