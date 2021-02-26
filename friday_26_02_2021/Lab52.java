package friday_26_02_2021;

public class Lab52 {
	public static void main(String[] args) {
		BankAcnt bk[]=new BankAcnt[3];
		bk[0]=new BankAcnt("Bharani","123456","savings");
		bk[1]=new BankAcnt("Ram","234561","savings");
		bk[2]=new BankAcnt("Vikram","345612","Salary");
		bk[0].Balance();
		bk[1].Balance();
		bk[2].Balance();
	}
}

class BankAcnt {
	String name;
	String acnt_no;
	String type_of_acnt;
	int Bal_amnt;
	
	public BankAcnt(String name, String acnt_no, String type_of_acnt) {
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