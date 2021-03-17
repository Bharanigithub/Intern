package Assignment_Components;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
public class ConsignmentDetails {
	public static CalculateDetails getDetails() throws Exception {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the Starting date:");
		int day=s.nextInt();
		System.out.println("Enter the Starting month:");
		int month=s.nextInt();
		System.out.println("Enter the Starting year:");
		int year=s.nextInt();
		LocalDate date=LocalDate.of(year, month, day);
		System.out.println("Enter the Origin Place:");
		String origin=s.next();
		System.out.println("Enter the Destination:");
		String destination=s.next();
		System.out.println("Enter the Starting Hour:");
		int hour=s.nextInt();
		System.out.println("Enter the Starting Minute:");
		int minute=s.nextInt();
		LocalTime time=LocalTime.of(hour, minute);
		System.out.println("Enter the Average Rest Hours and Minutes :");
		float hour1=s.nextFloat();
		float minute1=s.nextFloat();
		System.out.println("Enter the Distance:");
		float dist=s.nextFloat();
		System.out.println("Enter the Speed:");
		float speed=s.nextFloat();
		CalculateDetails calculateDetails=CalculateDetails.createObject();
		calculateDetails.setDetails(date,origin,destination,time,hour1,minute1,dist,speed,hour,minute);
		return calculateDetails;
	}
}
