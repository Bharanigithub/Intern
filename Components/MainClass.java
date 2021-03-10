package Components;

import java.util.ArrayList;

public class MainClass {
	public static void main(String[] args) throws Exception {
		//XMLtoArrList obj=new XMLtoArrList();
		//obj.putFile("invoice.xml");
		//ArrayList<ArrayList<String>> str=obj.getFileAsArrList();
		//System.out.println(str);
		
		//XlsConverter obj2=new XlsConverter(str);
		//obj2.ConvertXls();
		SAXDemo sax=new SAXDemo();
		ArrayList<ArrayList<String>> str=sax.SaxParser();
		XlsConverter obj2=new XlsConverter(str);
		obj2.ConvertXls();
		PdfConverter pdf=new PdfConverter();
		pdf.arrListToPdf("ac.pdf", str);
		ArrListToString obj3=new ArrListToString(str);
		obj3.createParagraph();
	}
}
