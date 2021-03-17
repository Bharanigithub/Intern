package Assignment_Components;

import java.util.ArrayList;

public class TextConverter implements ArrListToTextConverter,Cloneable {
	private static TextConverter textConverter;
	public TextConverter() {
		// TODO Auto-generated constructor stub
	}
	public static TextConverter createObject() throws Exception {
		if(textConverter==null) {
			textConverter=new TextConverter();
			TextConverter obj=textConverter.clone();
			return obj;
		}
		else
			return textConverter.clone();
	}
	@Override
	protected TextConverter clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (TextConverter)super.clone();
	}
	@Override
	public String convert(ArrayList<ArrayList<String>> arr) {
		// TODO Auto-generated method stub
		String finalString="";
		for(int i=0;i<arr.size();i++) {
			ArrayList<String> al=arr.get(i);
			for(int j=0;j<al.size();j++) {
				finalString=finalString+al.get(j)+"\t";
			}
			finalString=finalString+"\n";
		}
		System.out.println(finalString);
		return finalString;
	}
}
