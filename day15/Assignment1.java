package day15;
import jxl.Workbook;
import jxl.write.*;
import jxl.write.Number;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Assignment1 {

    private static final String EXCEL_FILE_LOCATION = "MyFirstExcel.xls";

    public static void main(String[] args) {
    	Scanner s=new Scanner(System.in);
        //1. Create an Excel file
        WritableWorkbook myFirstWbook = null;
        try {

            myFirstWbook = Workbook.createWorkbook(new File(EXCEL_FILE_LOCATION));

            // create an Excel sheet
            WritableSheet excelSheet = myFirstWbook.createSheet("Sheet 1", 0);

            // add something into the Excel sheet
            System.out.println("Enter the Customer Name:");
            String cust_name=s.next();
            Label label = new Label(0, 0, "Customer Name");
            excelSheet.addCell(label);
            label = new Label(1,0, cust_name);
            excelSheet.addCell(label);
            
            System.out.println("Enter the Bill No:");
            cust_name=s.next();
            label = new Label(2, 0, "Bill No");
            excelSheet.addCell(label);
            label = new Label(3,0, cust_name);
            excelSheet.addCell(label);
            
            System.out.println("Enter the Bill Date:");
            cust_name=s.next();
            label = new Label(4, 0, "Bill Date");
            excelSheet.addCell(label);
            label = new Label(5,0, cust_name);
            excelSheet.addCell(label);
            
            label = new Label(0, 1, "S.NO");
            excelSheet.addCell(label);
            
            label = new Label(1, 1, "Item");
            excelSheet.addCell(label);
            
            label = new Label(2, 1, "Unit");
            excelSheet.addCell(label);
            
            label = new Label(3, 1, "Price");
            excelSheet.addCell(label);
            
            label = new Label(4, 1, "Quantity");
            excelSheet.addCell(label);
            
            label = new Label(5, 1, "Amount");
            excelSheet.addCell(label);
            
            System.out.println("Enter the no.of Items:");
            int n=s.nextInt();
            //String v=s.next();
            Number number;
            for(int i=1;i<=n;i++) {
            	number = new Number(i-1, 2, i);
                excelSheet.addCell(number);
            }
            for(int i=1;i<=n;i++) {
            	System.out.println("Enter the item "+i+":");
            	cust_name=s.next();
            	label = new Label(1, i+1, cust_name);
                excelSheet.addCell(label);
                System.out.println("Enter the Unit:");
                int unit=s.nextInt();
            	number = new Number(2, i+1, unit);
                excelSheet.addCell(number);
            	System.out.println("Enter the Price:");
            	int price=s.nextInt();
            	number = new Number(3, i+1, price);
                excelSheet.addCell(number);
                System.out.println("Enter the Quantity:");
            	int quantity=s.nextInt();
            	number = new Number(4, i+1, quantity);
                excelSheet.addCell(number);
            	number = new Number(5, i+1, quantity*price);
                excelSheet.addCell(number);
                //v=s.next();
            }
            
        

            myFirstWbook.write();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        } finally {

            if (myFirstWbook != null) {
                try {
                    myFirstWbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (WriteException e) {
                    e.printStackTrace();
                }
            }


        }

    }

}