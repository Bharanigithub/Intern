package Day5;

public class InnerClass {
	public static void main(String args[]) {
		Mahindra mah=new Mahindra();
		Tata ta=new Tata();
		mah.MahindraCar();
		ta.TataCar();
	}
}

abstract class CarManufacturer {
	public void Manufacturing() {
		
	}
}

/*class Manufacturer extends CarManufacturer {
	public void Manufacturing() {
		System.out.println("Manufacturing Company!!!");
	}
}*/

class Mahindra {
	//Inner Class
	public void MahindraCar() {
		//CarManufacturer obj1=new Tata().new Manufacturer();
		CarManufacturer obj1=new Tata().Trojen();
		obj1.Manufacturing();
		System.out.println("Mahindra Car Manufacturerd!!");
	}
}

class Tata {
	private class Manufacturer extends CarManufacturer {
		public void Manufacturing() {
			System.out.println("Manufacturing Company!!!");
		}
	}
	public void TataCar() {
		CarManufacturer obj2=new Manufacturer();
		obj2.Manufacturing();
		System.out.println("Tata Car Manufactured!!");
	}
	public Manufacturer Trojen() {
		return new Manufacturer();
	}
}
