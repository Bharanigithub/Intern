package day8_Lab;

public class Lab12 {
	public static void main(String[] args) {
		Harris h1=new HarrisInfotech();
		Harris h2=new HarrisTechnologies();
		Harris h3=new HarrisPharma();
		h1.harrisInfotech();
		h2.harrisTechnologies();
		h3.harrisPharma();
	}
}

class Harris {
	public void harrisInfotech() {
		System.out.println("Harris Infotech from Base Class");
	}
	public void harrisTechnologies() {
		System.out.println("Harris Technologies from Base Class");
	}
	public void harrisPharma() {
		System.out.println("Harris Pharma from Base Class");
	}
}

class HarrisInfotech extends Harris {
	
	public void harrisInfotech() {
		System.out.println("Harris Infotech from Child Class");
	}
}

class HarrisTechnologies extends Harris {
	public void harrisTechnologies() {
		System.out.println("Harris Technologies from Child Class");
	}
}

class HarrisPharma extends Harris {
	public void harrisPharma() {
		System.out.println("Harris Technologies from Child Class");
	}
}
