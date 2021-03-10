package Components;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
public class PdfConverter {
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

	public void arrListToPdf(String filename, ArrayList<ArrayList<String>> data)
			throws FileNotFoundException, DocumentException {
		Document document = new Document();
		PdfPTable table = addTable(data.get(0));
		PdfPTable table2 = addTable(data.get(2));
		for (int i = 1; i < data.size(); i++) {
			ArrayList<String> temp = data.get(i);
			for (int j = 0; j < temp.size(); j++) {
				if (i == 2) {
					continue;
				} 
				else if (i > 2) {
					table2.addCell(temp.get(j));
				} else
					table.addCell(temp.get(j));
			}
		}

		PdfWriter.getInstance(document, new FileOutputStream(filename));
		document.open();
		document.add(table);
		document.add(table2);
		document.close();
		System.out.println("Done");
	}
}