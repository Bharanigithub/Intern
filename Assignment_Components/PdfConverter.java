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
			PdfPTable table = addTable(arr.get(0));
			PdfPTable table2 = addTable(arr.get(2));
			for (int i = 1; i < arr.size(); i++) {
				ArrayList<String> temp = arr.get(i);
				for (int j = 0; j < temp.size(); j++) {
					if (i == 2) {
						continue;
					} else if (i > 2) {
						table2.addCell(temp.get(j));
					} else
						table.addCell(temp.get(j));
				}
			}

			PdfWriter.getInstance(document, new FileOutputStream(fileName));
			document.open();
			document.add(table);
			document.add(table2);
			document.close();
			System.out.println("Pdf Generated!!");
		} catch (Exception e) {
		}
	}
}
