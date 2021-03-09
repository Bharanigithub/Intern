package Components;

import java.util.ArrayList;

public class MainClass {
	public static void main(String[] args) throws Exception {
		XMLtoArrList obj=new XMLtoArrList();
		obj.putFile("invoices.xml");
		ArrayList<ArrayList<String>> str=obj.getFileAsArrList();
		System.out.println(str);
		XlsConverter obj2=new XlsConverter(str);
		obj2.ConvertXls();
	}
}
