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
        String vowels = vowelsOnly("Udacity Course");
        System.out.println(vowels);
        System.out.println(formattedDateTime);
        FindTarget.main();
    }
    static void stringBuilderEx(){
        StringBuilder str = new StringBuilder("Good Morning");
        str.insert(1, "Friend ");
        System.out.println(str);
    }

    /**
     *
     * @return vowels in the argument
     */
    static String vowelsOnly(String wVowels){
        StringBuilder vowels = new StringBuilder();
        String baseVowels = "aeiou";
        String[] chars = wVowels.split("");

        for(String str : chars){
            if(!baseVowels.contains(str.toLowerCase())) continue;
            vowels.append(str);
        }

        return String.valueOf(vowels);
    }
}
