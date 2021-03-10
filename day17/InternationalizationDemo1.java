package day17;

import java.util.Locale;
import java.util.ResourceBundle;

public class InternationalizationDemo1 {
	public static void main(String[] args) {
		//Locale locale=Locale.getDefault();
	    //System.out.println(locale);
		Locale.setDefault(new Locale("ta"));
		Locale locale=Locale.getDefault();
		System.out.println(locale);
		ResourceBundle rb=ResourceBundle.getBundle("day17/Dictionary",locale);
		ResourceBundle rb2=ResourceBundle.getBundle("day17.Dictionary",locale);
		System.out.println(rb.getString("hello"));
		System.out.println(rb2.getString("hello"));
	}
}
