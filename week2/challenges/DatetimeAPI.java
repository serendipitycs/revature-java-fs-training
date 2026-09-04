import java.time.*;
import java.util.Scanner;

public class DatetimeAPI {
    public static void main (String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println("Today's Date is: " + date);
        System.out.println("The Year is: " + date.getYear());
        System.out.println("The Month is: " + date.getMonth());
        System.out.println("The Day of the month is: " + date.getDayOfMonth());

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your birthday (format YYYY-MM-DD): ");
        String input = scanner.nextLine();

        LocalDate dateInput1 = java.time.LocalDate.parse(input);
        int age = LocalDate.now().compareTo(dateInput1);
        System.out.println("You are " + age + " Years old.");

        System.out.print("Enter your birthday (format YYYY-MM-DD): ");
        String input2 = scanner.nextLine();
        LocalDate dateInput2 = java.time.LocalDate.parse(input2);

        Period untilBDay = LocalDate.now().until(dateInput2.withYear(2026));
        if (untilBDay.isNegative()) {
            untilBDay = LocalDate.now().until(dateInput2.withYear(2027));
        }
        System.out.println("Your birthday is " + untilBDay.getMonths() + " Months and " + untilBDay.getDays() + " Days away!");

    }
    /*
        Today's Date is: 2026-09-04
        The Year is: 2026
        The Month is: SEPTEMBER
        The Day of the month is: 4
        Enter your birthday (format YYYY-MM-DD): 2000-07-10 [input]
        You are 26 Years old.
        Enter your birthday (format YYYY-MM-DD): 2000-07-10 [input]
        Your birthday is 10 Months and 6 Days away!
     */

}
