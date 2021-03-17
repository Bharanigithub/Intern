package Assignment_Components;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class PrintDetails {
	public static void printConsignmentDetails(LocalDateTime ldt) {
		LocalDate date=ldt.toLocalDate();
		LocalTime time=ldt.toLocalTime();
		System.out.println("Estimated Delivery Date:"+date.getDayOfMonth()+"/"+date.getMonthValue()+"/"+date.getYear());
		System.out.println("Estimated Delivery Time:"+time);
	}
}
