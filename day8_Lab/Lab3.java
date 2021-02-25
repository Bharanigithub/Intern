package day8_Lab;

public class Lab3 {
	public static void main(String[] args) {
		Employee emp=new SalesPerson();
		emp.doj=new Date("15.02.2021");
		System.out.println(emp.doj.get());
	}
}

class Date {
	String DOJ;
	public Date(String DOJ) {
		// TODO Auto-generated constructor stub
		this.DOJ=DOJ;
	}
	public String get() {
		return this.DOJ;
	}
}
abstract class Employee {
	Date doj;
	
}

class SalesPerson extends Employee {
	public SalesPerson() {
		// TODO Auto-generated constructor stub
		
	}
	
}

class SalesManager extends SalesPerson {
	public SalesManager() {
		// TODO Auto-generated constructor stub
	}
}

class SalesTerritoryManager extends SalesManager {
	public SalesTerritoryManager() {
		// TODO Auto-generated constructor stub
	}
}

class Worker extends Employee {
	public Worker() {
		// TODO Auto-generated constructor stub
	}
}