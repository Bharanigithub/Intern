package day22;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import Assignment_Components.*;
public class InvoiceClient {
	public static void main(String[] args) throws Exception {
		Scanner s=new Scanner(System.in);
		Invoice inv = (Invoice) Naming.lookup("rmi://localhost:1099/myinvoiceapp");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			System.out.println("Please select your choice...");
			System.out.println("1-Create new Invoice");
			System.out.println("2-Display the Invoice");
			System.out.println("3-Calculate Delivery date and time");
			System.out.println("4-Convert Invoice to Excel");
			System.out.println("5-Convert Invoice to PDF");
			System.out.println("6.Insert Items");
			System.out.println("7.Exit");
			String str = br.readLine();
			int choice=Integer.parseInt(str);
			if(choice==7)
				break;
			switch (choice) {
			case 1: {
				System.out.println("Enter the invoice No:");
				str=br.readLine();
				int invno=Integer.parseInt(str);
				System.out.println("Enter the Date:");
				System.out.println("Enter the Day:");
				str=br.readLine();
				int day=Integer.parseInt(str);
				System.out.println("Enter the Month:");
				str=br.readLine();
				int month=Integer.parseInt(str);
				System.out.println("Enter the Year:");
				str=br.readLine();
				int year=Integer.parseInt(str);;
				System.out.println("Enter the Customer No:");
				str=br.readLine();
				int cusno=Integer.parseInt(str);;
				System.out.println("Enter the Customer Name:");
				String cusname=br.readLine();
				System.out.println("Enter the Customer Phone:");
				String mobile=br.readLine();
				System.out.println("Enter the Customer Address:");
				String address=br.readLine();
				System.out.println("Enter the Customer Email:");
				String email=br.readLine();
				System.out.println("Enter the no.of Items:");
				str=br.readLine();
				int noofitems=Integer.parseInt(str);
				int itemno[]=new int[noofitems];
				int itemqty[]=new int[noofitems];
				for(int i=0;i<noofitems;i++) {
					System.out.println("Enter the Item "+(i+1)+" Number");
					str=br.readLine();
					itemno[i]=Integer.parseInt(str);
					System.out.println("Enter the Item "+itemno[i]+" Quantity:");
					str=br.readLine();
					itemqty[i]=Integer.parseInt(str);
				}
				inv.createInvoice(invno,day,month,year,cusno,cusname,mobile,address,email,noofitems,itemno,itemqty);
				System.out.println("Inserted!!");
				break;
			}
			case 2: {
				System.out.println("Enter Invoice Number:");
				str=br.readLine();
				int invno=Integer.parseInt(str);
				ArrayList<ArrayList<String>> al=inv.printInvoice(invno);
				for(int i=0;i<al.size();i++) {
					ArrayList<String> alist=al.get(i);
					for(int j=0;j<alist.size();j++) {
						System.out.print(alist.get(j)+"\t");
					}
					System.out.println();
				}
				break;
			}
			case 3: {
				System.out.println("Enter the Starting date:");
				int day=s.nextInt();
				System.out.println("Enter the Starting month:");
				int month=s.nextInt();
				System.out.println("Enter the Starting year:");
				int year=s.nextInt();
				LocalDate date=LocalDate.of(year, month, day);
				System.out.println("Enter the Origin Place:");
				String origin=s.next();
				System.out.println("Enter the Destination:");
				String destination=s.next();
				System.out.println("Enter the Starting Hour:");
				int hour=s.nextInt();
				System.out.println("Enter the Starting Minute:");
				int minute=s.nextInt();
				LocalTime time=LocalTime.of(hour, minute);
				System.out.println("Enter the Average Rest Hours and Minutes :");
				float hour1=s.nextFloat();
				float minute1=s.nextFloat();
				System.out.println("Enter the Distance:");
				float dist=s.nextFloat();
				System.out.println("Enter the Speed:");
				float speed=s.nextFloat();
				String ans=inv.trackDelivery(date,origin,destination,time,hour1,minute1,dist,speed,hour,minute);
				System.out.println(ans);
				break;
			}
			case 4: {
				System.out.println("Enter Invoice Number:");
				str=br.readLine();
				int invno=Integer.parseInt(str);
				ArrayList<ArrayList<String>> al=inv.printInvoice(invno);
				byte[] bArray=inv.convertToExcel(al);
				FileOutputStream out = new FileOutputStream("InvClientExcel.xls");
				if(bArray!=null) {
					out.write(bArray);
				}
				out.close();
				System.out.println("Excel Received!!");
				break;
			}
			case 5: {
				System.out.println("Enter Invoice Number:");
				str=br.readLine();
				int invno=Integer.parseInt(str);
				ArrayList<ArrayList<String>> al=inv.printInvoice(invno);
				byte[] bArray=inv.convertToPDf(al);
				FileOutputStream out = new FileOutputStream("InvClientPdf.pdf");
				if(bArray!=null) {
					out.write(bArray);
				}
				out.close();
				System.out.println("Pdf Recieved!!");
				break;
			}
			case 6: {
				System.out.println("Enter the Item No:");
				str=br.readLine();
				int itemno=Integer.parseInt(str);
				System.out.println("Enter the Item Description:");
				str=br.readLine();
				String desc=str;
				System.out.println("Enter the Price:");
				str=br.readLine();
				int price=Integer.parseInt(str);
				System.out.println("Enter the Unit:");
				str=br.readLine();
				int unit=Integer.parseInt(str);
				inv.addItem(itemno, desc, price, unit);
				System.out.println("Item Added!!");
				break;
			}
			default:
				System.out.println("wrong choice...");
				break;
			}
		}
	}
}
