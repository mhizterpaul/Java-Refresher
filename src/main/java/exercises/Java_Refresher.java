package exercises;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
//import java.util.Date;

public class Java_Refresher {
    public static void main(String[] args){
        //Date myDate = new Date();
        long milliSec = 1561554154352L;
        Instant instant = Instant.ofEpochMilli(milliSec);
        ZonedDateTime utc = instant.atZone(ZoneId.of("UTC"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, dd MM yyyy HH:mm:ss z");
        String formattedDateTime = utc.format(formatter);
        stringBuilderEx();
        System.out.println(formattedDateTime);
    }
    static void stringBuilderEx(){
        StringBuilder str = new StringBuilder("Good Morning");
        str.insert(1, "Friend ");
        System.out.println(str);
    }
}
