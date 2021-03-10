package Components;

import java.util.ArrayList;

public class ArrListToString {
	ArrayList<ArrayList<String>> arr=new ArrayList<ArrayList<String>>();
	public ArrListToString(ArrayList<ArrayList<String>> arr) {
		this.arr=arr;
	}
	public String createParagraph() {
		String finalString="";
		for(int i=0;i<arr.size();i++) {
			ArrayList<String> al=arr.get(i);
			for(int j=0;j<al.size();j++) {
				finalString=finalString+al.get(j)+"\t";
			}
			//System.out.println(finalString);
			finalString=finalString+"\n";
		}
		System.out.println(finalString);
		return finalString;
	}
}
