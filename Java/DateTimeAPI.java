import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateTimeAPI {
    public static void main(String[] args) {
        Date oldDate = new Date();
        System.out.println("Date() : " + oldDate);

        Calendar oldDate1 = Calendar.getInstance();
        System.out.println("Calendar.getInstance() : " + oldDate1.getTime());

        /**
         * New Date-Time API
         * 
         * **/

        // LocalDate Class ->

        LocalDate localDate = LocalDate.now();
        System.out.println("LocalDate.now() : " + localDate);

        // LocalTime
        
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM dd, yyyy || HH:mm:ss");
        String currentDateTime = localDateTime.format(format);
        System.out.println("LocalDateTime.now() : " + currentDateTime);

    }
    
}
