package day22;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Scanner;

public class InvoiceClient {
	public static void main(String[] args) throws Exception {
		Invoice inv = (Invoice) Naming.lookup("rmi://localhost:1099/myinvoiceapp");
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println("Please select your choice...");
			System.out.println("1-Create new Invoice");
			System.out.println("2-Display the Invoice");
			System.out.println("3-Calculate Delivery date and time");
			System.out.println("4-Convert Invoice to Excel");
			System.out.println("5-Convert Invoice to PDF");
			System.out.println("6.Exit");
			int choice = s.nextInt();
			if(choice==6)
				break;
			switch (choice) {
			case 1: {
				System.out.println("Enter the invoice No:");
				int invno=s.nextInt();
				System.out.println("Enter the Date:");
				System.out.println("Enter the Day:");
				int day=s.nextInt();
				System.out.println("Enter the Month:");
				int month=s.nextInt();
				System.out.println("Enter the Year:");
				int year=s.nextInt();
				System.out.println("Enter the Customer No:");
				int cusno=s.nextInt();
				System.out.println("Enter the Customer Name:");
				String cusname=s.next();
				System.out.println("Enter the Customer Phone:");
				String mobile=s.next();
				System.out.println("Enter the Customer Address:");
				String address=s.next();
				System.out.println("Enter the Customer Email:");
				String email=s.next();
				System.out.println("Enter the no.of Items:");
				int noofitems=s.nextInt();
				int itemno[]=new int[noofitems];
				int itemqty[]=new int[noofitems];
				for(int i=0;i<noofitems;i++) {
					System.out.println("Enter the Item "+(i+1)+" Number");
					itemno[i]=s.nextInt();
					System.out.println("Enter the Item "+itemno[i]+" Quantity:");
					itemqty[i]=s.nextInt();
				}
				inv.createInvoice(invno,day,month,year,cusno,cusname,mobile,address,email,noofitems,itemno,itemqty);
				System.out.println("Inserted!!");
				break;
			}
			case 2: {
				System.out.println("Enter Invoice Number:");
				int invno=s.nextInt();
				ArrayList<ArrayList<String>> al=inv.printInvoice(invno);
				for(int i=0;i<al.size();i++) {
					ArrayList<String> alist=al.get(i);
					for(int j=0;j<alist.size();j++) {
						System.out.println(alist.get(j)+"\t");
					}
					System.out.println();
				}
				break;
			}
			case 3: {
				inv.trackDelivery();
			}
			case 4: {
				inv.convertToExcel();
			}
			case 5: {
				inv.convertToPDf();
			}
			default:
				System.out.println("wrong choice...");
			}
		}
	}
}
