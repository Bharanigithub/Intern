package Assignment_Components;

import java.util.ArrayList;

public interface ArrListToPdfConverter extends Converter {
	public void convertToPdf(ArrayList<ArrayList<String>> arr,String fileName);
}
