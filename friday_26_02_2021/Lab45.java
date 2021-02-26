package friday_26_02_2021;
import java.util.*;
public class Lab45 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the name:");
		String name=s.next();
		System.out.println("Enter the Account_no:");
		String acnt_no=s.next();
		System.out.println("Enter the Type of Account:");
		String type=s.next();
		BankAccount customer1=new BankAccount(name,acnt_no,type);
		customer1.Balance();
		customer1.Deposit(1800);
		customer1.Balance();
	}
}

class BankAccount {
	String name;
	String acnt_no;
	String type_of_acnt;
	int Bal_amnt;
	
	public BankAccount(String name, String acnt_no, String type_of_acnt) {
		super();
		this.name = name;
		this.acnt_no = acnt_no;
		this.type_of_acnt = type_of_acnt;
		Bal_amnt = 0;
	}
	public void Balance() {
		System.out.println("Name:"+this.name);
		System.out.println("Type of Account:"+this.type_of_acnt);
		System.out.println("Your Balance Amount:"+this.Bal_amnt);
	}
	public void Deposit(int amnt) {
		System.out.println("Your Current Balance Amount:"+Bal_amnt);
		this.Bal_amnt=this.Bal_amnt+amnt;
	}
}
