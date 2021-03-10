package day17;

public class EnumDemo {
	public static void main(String[] args) {
		Cars car;
		car=Cars.skoda;
		met(car);
	}
	
	public static void met(Cars car) {
		if(car==Cars.skoda) {
			System.out.println("Skoda Car.........");
		}
		else if(car==Cars.renault) {
			System.out.println("Renault Car.........");
		}
		else if(car==Cars.mahindra) {
			System.out.println("Mahindra Car..........");
		}
		else if(car==Cars.suzuki) {
			System.out.println("Suzuki Car..........");
		}
		else if(car==Cars.tata) {
			System.out.println("Tata Car..........");
		}
		
		switch(car)	{
		case skoda:{
			System.out.println("Skoda car in case Statement....");
			break;
		}
		case renault:{
			System.out.println("Renault car in case Statement....");
		}
		default:{
			System.out.println("Other Cars....");
		}
	}
		
		Cars c[]=Cars.values();
		for(Cars cc:c) {
			System.out.println(cc.getPrice());
		}
		Cars.tata.setPrice(1500);
		System.out.println("Tata Car Price..:"+Cars.tata.getPrice());
	}
}
enum Cars{
	tata(2000),mahindra(3000),suzuki(4000),skoda(5000),renault(6000);
	private int price;
	Cars(int price){
		this.price=price;
	}
	
	public int getPrice() {
		return this.price;
	}
	public void setPrice(int price) {
		this.price=price;
	}
}