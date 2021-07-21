package topic4.part1_SimpleClasses.task10;

import java.sql.Time;
import java.util.Scanner;

public class Airlines {

    private Airline[] airlines = new Airline[5];

    public Airlines(Airline[] airlines) {
        this.airlines = airlines;
    }

    public Airlines() {
    }

    public static void main(String[] args) {
        Airlines airlines = createAirlines();
        System.out.println(airlines.toString());

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input destination point: ");
        String filter = scanner.nextLine();
        airlines.filterByDestinationPoint(filter);

        System.out.print("\nInput week day (Sun, Mon, Tue, Wed, Thu, Fri, Sat): ");
        filter = scanner.nextLine();
        airlines.filterByWeekDay(filter);

        System.out.print("\nInput week day (Sun, Mon, Tue, Wed, Thu, Fri, Sat): ");
        filter = scanner.nextLine();
        airlines.filterByWeekDayAndTime(filter, inputTime());
    }

    private static Time inputTime() {
        Scanner scanner = new Scanner(System.in);
        int hour, minute;
        do {
            System.out.print("Input hour: ");
            hour = scanner.nextInt();
            if (hour < 0 || hour > 23) {
                System.out.println("Wrong hour format, try again.");
            }
        } while (hour < 0 || hour > 23);

        do {
            System.out.print("Input minute: ");
            minute = scanner.nextInt();
            if (minute < 0 || minute > 59) {
                System.out.println("Wrong minute format, try again.");
            }
        } while (minute < 0 || minute > 59);
        return new Time(hour, minute, 0);
    }

    public void filterByWeekDayAndTime(String filter, Time time) {
        for (Airline airline : airlines) {
            for (WeekDays weekDay : airline.getWeekDays()) {
                if (weekDay.getName().equals(filter) && (airline.getTime().after(time))) {
                    System.out.println(airline.toString());
                    break;
                }
            }
        }
    }

    public void filterByWeekDay(String filter) {
        for (Airline airline : airlines) {
            for (WeekDays weekDay : airline.getWeekDays()) {
                if (weekDay.getName().equals(filter)) {
                    System.out.println(airline.toString());
                    break;
                }
            }
        }
    }

    public void filterByDestinationPoint(String filter) {
        for (Airline airline : airlines) {
            if (airline.getDestinationPoint().equals(filter)) {
                System.out.println(airline.toString());
            }
        }
    }

    private static Airlines createAirlines() {
        Airline[] array = new Airline[5];
        int i = 0;
        array[i++] = new Airline("Minsk", "FR1258", new Time(12, 15, 0),
                new WeekDays[]{WeekDays.MON, WeekDays.THU});
        array[i++] = new Airline("Vilnius", "BY8520", new Time(20, 28, 0),
                new WeekDays[]{WeekDays.TUE, WeekDays.THU, WeekDays.SAT, WeekDays.SUN});
        array[i++] = new Airline("Paris", "GR9639", new Time(23, 10, 0),
                new WeekDays[]{WeekDays.FRI, WeekDays.MON, WeekDays.WED});
        array[i++] = new Airline("Minsk", "RT4521", new Time(15, 35, 0),
                new WeekDays[]{WeekDays.TUE, WeekDays.THU, WeekDays.SAT});
        array[i] = new Airline("Balbasovo", "YT0123", new Time(4, 36, 0),
                new WeekDays[]{WeekDays.MON, WeekDays.TUE, WeekDays.WED});
        return new Airlines(array);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Airline airline : airlines) {
            result.append(airline.toString().concat("\n"));
        }
        return result.toString();
    }

    public Airline[] getAirlines() {
        return airlines;
    }

    public void setAirlines(Airline[] airlines) {
        this.airlines = airlines;
    }
}
