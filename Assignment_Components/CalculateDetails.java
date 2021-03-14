package Assignment_Components;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CalculateDetails implements Cloneable {
	private static CalculateDetails calculateDetails;
	LocalDate date;
	LocalTime time;
	String originPlace;
	String Destination;
	int startingHour;
	int startingMinute;
	float restHour;
	float restMinute;
	float distance;
	float speed;
	int hour;
	int minute;
	public void setDetails(LocalDate date,String origin,String destination,LocalTime time,float hour1,float minute1,float dist,float speed,int hour,int minute) {
		this.date=date;
		this.time=time;
		this.originPlace=origin;
		this.Destination=destination;
		this.startingHour=hour;
		this.startingMinute=minute;
		this.restHour=hour1;
		this.restMinute=minute1;
		this.distance=dist;
		this.speed=speed;
	}
	public static CalculateDetails createObject() throws Exception {
		if(calculateDetails==null) {
			calculateDetails=new CalculateDetails();
			CalculateDetails cd=calculateDetails.clone();
			return cd;
		}
		else
			return calculateDetails.clone();
	}
	@Override
	protected CalculateDetails clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (CalculateDetails)super.clone();
	}
	public LocalDateTime compute(CalculateDetails calDetails) {
		float timeTaken=calDetails.distance/calDetails.speed;
		int daysTaken=(int)timeTaken/24;
		float min=0;
		for(int i=0;i<=daysTaken;i++) {
			timeTaken=timeTaken+calDetails.restHour;
			min=min+calDetails.restMinute;
		}
		timeTaken=timeTaken+min/60;
		daysTaken=(int)timeTaken/24;
		int hoursTaken=(int)(timeTaken-(float)daysTaken*24);
		float minutesTaken=(timeTaken-(float)daysTaken*24-(float)hoursTaken)*60;
		int minTaken=(int)minutesTaken;
		//System.out.println(daysTaken);
		//System.out.println(hoursTaken);
		//System.out.println(minTaken);
		LocalDate destDate=date.plusDays(daysTaken);
		//System.out.println(time);
		LocalTime destTime=time.plusMinutes(minTaken);
		destTime.plusHours(hoursTaken);
		//time.plusHours(daysTaken*24);
		//destTime=destTime.plusMinutes(minTaken);
		//System.out.println(destTime);
		//System.out.println(destDate);
		LocalDateTime ldt=LocalDateTime.of(destDate, destTime);
		return ldt;
	}
}
