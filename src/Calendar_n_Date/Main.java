package DateFormat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        Date startDate = format.parse(read.readLine());
        Date endDate = format.parse(read.readLine());

        int workDays = 0;


        while (startDate.compareTo(endDate) != 1) {
            Date theDate = startDate;
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(theDate);

            if (isWorkDay(theDate) && isWeekDay(theDate)) {
                workDays++;
            }

            calendar.add(Calendar.DAY_OF_MONTH, 1);
            startDate = calendar.getTime();
        }
        System.out.println(workDays);
    }

    public static boolean isWorkDay(Date date) {

        Calendar calendar = Calendar.getInstance();         // създава календар
        calendar.setTime(date);                             // задава датата
        int day = calendar.get(Calendar.DAY_OF_MONTH);      // връща деня от месеца като число

        switch (calendar.get(Calendar.MONTH)) {
            case Calendar.JANUARY:
                return day != 1;
            case Calendar.MARCH:
                return day != 3;
            case Calendar.MAY:
                return day != 1 && day != 6 && day != 24;
            case Calendar.SEPTEMBER:
                return day != 6 && day != 22;
            case Calendar.NOVEMBER:
                return day != 1;
            case Calendar.DECEMBER:
                return day != 24 && day != 25 && day != 26;
        }
        return true;
    }

    public static boolean isWeekDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY);
    }

    /*
    input1:
    11-04-2016
    22-04-2016

    output:
    10

    ------------
    input2:
    11-04-2016
    14-04-2016

    output2:
    4
     */
}
