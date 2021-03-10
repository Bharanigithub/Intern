package Components;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
public class XlsConverter {
	ArrayList<ArrayList<String>> arr;
	public XlsConverter(ArrayList<ArrayList<String>> arr) {
		this.arr=arr;
	}
	public void ConvertXls() {
		
		WritableWorkbook myFirstWbook = null;
		try {
			myFirstWbook = Workbook.createWorkbook(new File("InvoiceDemo1.xls"));

			// create an Excel sheet
			WritableSheet excelSheet = myFirstWbook.createSheet("Sheet 1", 0);

			for (int i = 0; i < arr.size(); i++) {
				ArrayList<String> temp = arr.get(i);
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < temp.size(); j++) {
					
					Label label = new Label(j, i, temp.get(j));
					excelSheet.addCell(label);
				}
				
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






