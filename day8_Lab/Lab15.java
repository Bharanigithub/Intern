package day8_Lab;

public class Lab15 {
	public static void main(String args[]) {
		Door d=new Door(10,100);
		Window w=new Window(8,40);
		House h=new House(d,w);
		System.out.println(h.calculate());
	}
}


class House {
	Door d;
	Window w;
	public House(Door d,Window w) {
		// TODO Auto-generated constructor stub
		this.d=d;
		this.w=w;
	}
	public int calculate() {
		return (d.sqft*d.cost+w.sqft*w.cost);
	}
}

class Door {
	int cost;
	int sqft;
	public Door(int cost,int sqft) {
		this.cost=cost;
		this.sqft=sqft;
	}
}

class Window {
	int cost;
	int sqft;
	public Window(int cost,int sqft) {
		this.cost=cost;
		this.sqft=sqft;
	}
	
}