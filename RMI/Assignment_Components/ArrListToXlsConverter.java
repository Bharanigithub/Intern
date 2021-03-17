package Assignment_Components;

import java.util.ArrayList;

public interface ArrListToXlsConverter extends Converter {
	public void convertToXls(ArrayList<ArrayList<String>> arr,String fileName);
}
