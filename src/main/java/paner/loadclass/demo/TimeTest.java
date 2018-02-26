package paner.loadclass.demo;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by www-data on 16/12/16.
 */
public class TimeTest {

    public static void main(String args[]){


        System.out.println("test");
        System.out.println(getWeekOfYear("2016-01-12"));

    }

    private static String getWeekOfYear(String dateStr){
        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd");
        DateTime dateTime = DateTime.parse(dateStr,format);
        return dateTime.weekOfWeekyear().getAsString();

    }
}
