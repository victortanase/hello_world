package testsekl;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class LearningJavaUnu {

	
	
	public static void main(String [] args){
		
		LocalDateTime loc = LocalDateTime.of(2017, Month.MAY, 9, 9, 30);
		
		LocalDate locsm = LocalDate.of(2017, Month.MAY,20);
		System.out.println("Time is"+loc.toString());
		loc = loc.plusDays(10);
		System.out.println("Time is"+loc.toString());
		
		Period period = Period.ofMonths(1);
		Duration durata = Duration.ofHours(10);
		LocalDateTime loc3=loc.plus(durata);
		System.out.println(period);
		System.out.println(loc.plus(period));
		System.out.println(loc.plus(durata));
		System.out.println("BW"+ChronoUnit.HOURS.between(loc, loc3));
		
		ZoneId zone =ZoneId.of("US/Eastern");
		ZonedDateTime loc2 = ZonedDateTime.of(2017, 3, 9,  9, 20,  45, 200, zone);
		System.out.println(loc2);
		System.out.println(loc2.toInstant());
		
		ZoneId.getAvailableZoneIds()
		.stream()
		.filter(z ->z.contains("Europe/London"))
		.forEach(System.out::println);
		
	}
}
