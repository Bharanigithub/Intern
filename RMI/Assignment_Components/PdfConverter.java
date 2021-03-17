package Assignment_Components;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfConverter implements ArrListToPdfConverter,Cloneable{
	private static PdfConverter pdfConverter;
	public PdfConverter() {
		// TODO Auto-generated constructor stub
	}
	public static PdfConverter CreateObject() throws Exception {
		if(pdfConverter==null) {
			pdfConverter=new PdfConverter();
			PdfConverter obj=pdfConverter.clone();
			return obj;
		}
		return pdfConverter.clone();
	}
	@Override
	protected PdfConverter clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (PdfConverter)super.clone();
	}
	public PdfPTable addTable(ArrayList<String> temp) {
		int n = temp.size();
		float f[] = new float[n];
		for (int i = 0; i < n; i++) {
			f[i] = 3;
		}
		PdfPTable table = new PdfPTable(f);
		for (int i = 0; i < n; i++) {
			table.addCell(temp.get(i));
		}

		return table;
	}

	@Override
	public void convertToPdf(ArrayList<ArrayList<String>> arr, String fileName) {
		// TODO Auto-generated method stub
		try {
			Document document = new Document();
			PdfPTable table[]=new PdfPTable[arr.size()];
			for (int i = 0; i < arr.size(); i++) {
				table[i]=addTable(arr.get(i));
			}

			PdfWriter.getInstance(document, new FileOutputStream(fileName));
			document.open();
			for(int i=0;i<arr.size();i++) {
				document.add(table[i]);
			}
			document.close();
			System.out.println("Pdf Generated!!");
		} catch (Exception e) {
		}
	}
}
