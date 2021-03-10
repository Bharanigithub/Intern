package day17;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class InternationalizationDemo2 {
	public static void main(String[] args) {
		NumberFormat numberFormat=NumberFormat.getCurrencyInstance(new Locale("en","US"));
		int i=2542365;
		System.out.println(numberFormat.format(i));
		DateFormat dateFormat=DateFormat.getDateInstance(DateFormat.SHORT,new Locale("en","IN"));
		Date date=new Date();
		System.out.println(dateFormat.format(date));
		DateTimeFormatter format=DateTimeFormatter.ofPattern("d-MM-YY", new Locale("en","IN"));
		String ldt=LocalDateTime.now().format(format);
		System.out.println(ldt);
	}
}
