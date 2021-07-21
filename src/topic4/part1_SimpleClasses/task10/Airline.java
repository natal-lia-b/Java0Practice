package topic4.part1_SimpleClasses.task10;

import java.sql.Time;

/**
 * 10. Создать класс Airline, спецификация которого приведена ниже.
 * Определить конструкторы, set- и get- методы и метод toString().
 * Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и методами.
 * Задать критерии выбора данных и вывести эти данные на консоль.
 * Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
 * Найти и вывести:
 * a) список рейсов для заданного пункта назначения;
 * b) список рейсов для заданного дня недели;
 * c) список рейсов для заданного дня недели, время вылета для которых больше заданного.
 */

public class Airline {

    private String destinationPoint;
    private String flightNumber;
    private int airlineType;
    private Time time;
    private WeekDays[] weekDays;

    public Airline(String destinationPoint, String flightNumber, int airlineType, Time time, WeekDays[] weekDays) {
        this.destinationPoint = destinationPoint;
        this.flightNumber = flightNumber;
        this.airlineType = airlineType;
        this.time = time;
        this.weekDays = weekDays;
    }

    public Airline(String destinationPoint, String flightNumber, Time time, WeekDays[] weekDays) {
        this.destinationPoint = destinationPoint;
        this.flightNumber = flightNumber;
        this.time = time;
        this.weekDays = weekDays;
    }

    @Override
    public String toString() {
        StringBuilder days = new StringBuilder();
        for (WeekDays day : weekDays) {
            days.append(day.getName().concat(", "));
        }
        if (days.length() > 0) {
            days.delete(days.length() - 2, days.length());
        }
        return "[" + flightNumber +
                " to " + destinationPoint +
                " at " + time +
                " on " + days +
                ']';
    }

    public String getDestinationPoint() {
        return destinationPoint;
    }

    public void setDestinationPoint(String destinationPoint) {
        this.destinationPoint = destinationPoint;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getAirlineType() {
        return airlineType;
    }

    public void setAirlineType(int airlineType) {
        this.airlineType = airlineType;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public WeekDays[] getWeekDays() {
        return weekDays;
    }

    public void setWeekDays(WeekDays[] weekDays) {
        this.weekDays = weekDays;
    }
}
