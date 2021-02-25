package Day8;
import java.util.*;
public class UMLDemo {
	public static void main(String args[]) throws Exception{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the Shoe you want:");
		String st=s.next();
		Shoe shoe=(Shoe)Class.forName(st).newInstance();
		Customer cus=new ShoeCustomer("Bharani");
		shoe.ss=Container.getShoeShop(args[0]);
		shoe.sf=Container.getShoeFactory(args[1]);
		shoe.cus=cus;
		shoe.ShoeMaking(shoe);
	}
}

class Container {
		public static ShoeShop getShoeShop(String str) throws Exception {
			ShoeShop ss=(ShoeShop)Class.forName(str).newInstance();
			return ss;
		}
		public static ShoeFactory getShoeFactory(String str) throws Exception {
			ShoeFactory sf=(ShoeFactory)Class.forName(str).newInstance();
			return sf;
		}
}

abstract class ShoeFactory implements Manufacturer{
	public abstract void ShoeFactoryMaking();
}

abstract class ShoeShop implements Seller {
	public abstract void ShoeShopMaking();
}

abstract class Shoe {
	ShoeShop ss;
	ShoeFactory sf;
	Customer cus;
	public abstract void ShoeMaking(Shoe sh);
}

abstract class Customer {
	public String name;
	public abstract void CustomerMaking();
}

class LeatherShoe extends Shoe {
	 @Override
	public void ShoeMaking(Shoe sh) {
		// TODO Auto-generated method stub
		 
		System.out.println("Leather Shoe Made!!");
		sh.sf.ShoeFactoryMaking();
		sh.ss.ShoeShopMaking();
		sh.cus.CustomerMaking();
	}
}

class SportsShoe extends Shoe {
	@Override
	public void ShoeMaking(Shoe sh) {
		// TODO Auto-generated method stub
	 	
		System.out.println("Sports Shoe Made!!");
		sh.sf.ShoeFactoryMaking();
		sh.ss.ShoeShopMaking();
		sh.cus.CustomerMaking();
	}
}

class GokulShoeShop extends ShoeShop {
	@Override
	public void ShoeShopMaking() {
		// TODO Auto-generated method stub
		System.out.println("Shoes Bought from Gokul Shoe Shop!!");
		this.shoesell();
	}
	
	@Override
	public void shoesell() {
		// TODO Auto-generated method stub
		System.out.println("This Seller is Shoe Seller");
	}
}

class ShoeCustomer extends Customer {
	public ShoeCustomer(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
	}
	@Override
	public void CustomerMaking() {
		// TODO Auto-generated method stub
		System.out.println("Customer Name is "+this.name);
	}
}

class BataShoeFactory extends ShoeFactory {
	@Override
	public void ShoeFactoryMaking() {
		// TODO Auto-generated method stub
		System.out.println("Shoes Manufactured from Bata Shoe Factory!!");
		this.makeShoe();
	}
	
	@Override
	public void makeShoe() {
		// TODO Auto-generated method stub
		System.out.println("Shoes are Made!!");
	}
	
}

class LakhaniShoeFactory extends ShoeFactory {
	@Override
	public void ShoeFactoryMaking() {
		// TODO Auto-generated method stub
		System.out.println("Shoes Manufactured from Lakhani Shoe Factory!!");
		this.makeShoe();
	}
	@Override
	public void makeShoe() {
		// TODO Auto-generated method stub
		System.out.println("Shoes are Made!!");
	}
}

interface ShoeManufacturer {

}

interface Manufacturer extends ShoeManufacturer {
	public void makeShoe();
}

interface ShoeSeller {
	
}

interface Seller extends ShoeSeller {
	public void shoesell();
}
