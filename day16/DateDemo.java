package day16;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class DateDemo {
	public static void main(String[] args) {
		LocalDateTime localDateTime=LocalDateTime.now();
		System.out.println(localDateTime);
		LocalDate date=localDateTime.toLocalDate();
		LocalTime time=localDateTime.toLocalTime();
		System.out.println(date+" "+time);
		Month month=localDateTime.getMonth();
		int month1=localDateTime.getMonthValue();
		//System.out.println(month1);
		int day=localDateTime.getDayOfMonth();
		//int day1=localDateTime.getDayOfYear();
		int year=localDateTime.getYear();
		int hour=localDateTime.getHour();
		int minute=localDateTime.getMinute();
		int second=localDateTime.getSecond();
		LocalDate dateEg=LocalDate.of(1999, 12, 19);
		System.out.println(dateEg);
		LocalTime customTime=LocalTime.of(2,20, 15);
		System.out.println(customTime);
		LocalTime parseEg=LocalTime.parse("02:20:15");
		System.out.println(parseEg.getMinute());
		LocalDate datePlus=dateEg.plus(2, ChronoUnit.CENTURIES);
		System.out.println(datePlus);
		LocalTime timePlus=customTime.plus(5, ChronoUnit.HOURS);
		System.out.println(timePlus);
	}
}
