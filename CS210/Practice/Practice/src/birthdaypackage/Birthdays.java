// CS210 Assignment #4 "Birthdays"
// Pierre Ellie

import java.util.*;

public class Birthdays {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        //asks for the day of the year
        System.out.println("Please enter today's date (month day) :");
        String dateNow = console.nextLine();
        //splits up the console grab into two variables
        String dateNowDay = findDay(dateNow);
        String dateNowMonth = findMonth(dateNow);
        //finds the number of days into the year the day is 
        int dateNowOfYear = getDayofYear(Integer.parseInt(dateNowMonth), Integer.parseInt(dateNowDay));
        System.out.println("Today is " + dateNowMonth + "/" + dateNowDay + "/2021, day #" + dateNowOfYear + " of the year.");
        //asks for the first birthday
        System.out.println("Please enter person #1's birthday (month day) :");
        String datePerson1 = console.nextLine();
        //splits up the console grab into two variables
        String datePerson1Day = findDay(datePerson1);
        String datePerson1Month = findMonth(datePerson1);
        //finds the number of days into the year the day is
        int datePerson1OfYear = getDayofYear(Integer.parseInt(datePerson1Month), Integer.parseInt(datePerson1Day));
        System.out.println(datePerson1Month + "/" + datePerson1Day + "/2021 falls on day #" + datePerson1OfYear + " of 365.");
        //finds out when the next birthday is or if it's today
        int nextBDayPerson1 = nextBDay(datePerson1OfYear, dateNowOfYear);
        if (nextBDayPerson1 == 0) {
            System.out.println("Happy Birthday! :)");
        }else{
            System.out.println("Your next birthday is in " + nextBDayPerson1 + " day(s)");
        }
        //asks for the second birthday
        System.out.println("Please enter person #2's birthday (month day) :");
        String datePerson2 = console.nextLine();
        //splits up the console grab into two variables
        String datePerson2Day = findDay(datePerson2);
        String datePerson2Month = findMonth(datePerson2);
        //finds the number of days into the year the day is 
        int datePerson2OfYear = getDayofYear(Integer.parseInt(datePerson2Month), Integer.parseInt(datePerson2Day));
        System.out.println(datePerson2Month + "/" + datePerson2Day + "/2021 falls on day #" + datePerson2OfYear + " of 365.");
        //finds out when the next birthday is or if it's today
        int nextBDayPerson2 = nextBDay(datePerson2OfYear, dateNowOfYear);
        if (nextBDayPerson2 == 0) {
            System.out.println("Happy Birthday! :)");
        }else{
            System.out.println("Your next birthday is in " + nextBDayPerson2 + " day(s)");
        }
        //finds out which birthday comes sooner or if they are the same
        if (nextBDayPerson1 > nextBDayPerson2) {
            System.out.println("Person #2's birthday is sonner.");
        } else {
            if (nextBDayPerson1 < nextBDayPerson2) {
                System.out.println("Person #1's birthday is sonner.");
            } else {
                System.out.println("Wow, you share the same birtday! ^_^");
            }

        }
        //the fun fact
        System.out.println("Did you know that May 14th 2021 is Fintastic Friday: a day that is meant to give sharks a voice. May 14th is also National Buttermilk biscuit day, yum!");
    }
    //nextBDay takes in the birthday and the date of the year and finds out how many days until the next occurance of that birthday
    public static int nextBDay(int bDay, int dateOfYear) {
        int nextDay;
        if (dateOfYear > bDay) {
            nextDay = (365 - dateOfYear + bDay);
        } else {
            nextDay = bDay - dateOfYear;
        }
        return nextDay;
    }
    //findDay splits the input given by the user to grab the first number which is the day
    public static String findDay(String date) {
        String dateNowDay = "";
        for (int i = 0; i < date.length(); i++) {
            if (date.charAt(i) == ' ') {
                dateNowDay = date.substring(i + 1, date.length());
            }
        }
        return dateNowDay;
    }
    //findMonth splits the input given by the user to grab the second number which is the month
    public static String findMonth(String date) {
        String dateNowMonth = "";
        for (int i = 0; i < date.length(); i++) {
            if (date.charAt(i) == ' ') {
                dateNowMonth = date.substring(0, i);

            }
        }
        return dateNowMonth;
    }
    //getDayofYear is a method that finds the day of the year based on the inputed month and day of the month
    public static int getDayofYear(int month, int dayOfMonth) {
        double N1 = Math.floor(275 * month / 9);
        double N2 = Math.floor((month + 9) / 12);
        double N3 = (1 + Math.floor((2021 - 4 * Math.floor(2021 / 4) + 2) / 3));
        double N = N1 - (N2 * N3) + dayOfMonth - 30;
        int A = (int) N;
        return A;
    }
}
