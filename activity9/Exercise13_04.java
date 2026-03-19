package activity9;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Exercise13_04 {

    public static void main(String[] args) {

        int month = Integer.parseInt(args[0]);
        int year = Integer.parseInt(args[1]);

        GregorianCalendar cal = new GregorianCalendar(year, month - 1, 1);

        System.out.println("\n" + getMonthName(month) + " " + year);
        System.out.println("-------------------------");
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        int startDay = cal.get(Calendar.DAY_OF_WEEK);
        int totalDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        for (int i = 1; i < startDay; i++) {
            System.out.print("    ");
        }

        for (int day = 1; day <= totalDays; day++) {
            System.out.printf("%3d ", day);

            if ((day + startDay - 1) % 7 == 0) {
                System.out.println();
            }
        }
    }

    public static String getMonthName(int month) {
        String[] months = {
            "January", "February", "March", "April",
            "May", "June", "July", "August",
            "September", "October", "November", "December"
        };
        return months[month - 1];
    }
}
