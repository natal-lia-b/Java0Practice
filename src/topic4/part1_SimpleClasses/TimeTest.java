package topic4.part1_SimpleClasses;

/**
 * 6. Составьте описание класса для представления времени.
 * Предусмотрте возможности установки времени и изменения его отдельных полей
 * (час, минута, секунда) с проверкой допустимости вводимых значений.
 * В случае недопустимых значений полей поле устанавливается в значение 0.
 * Создать методы изменения времени на заданное количество часов, минут и секунд.
 */

public class TimeTest {
    private int hour;
    private int minute;
    private int second;

    private final int HOUR_MAX_AVAILABLE = 23;
    private final int HOURS_TOTAL = 24;
    private final int MINUTE_SECOND_MAX_AVAILABLE = 59;
    private final int MINUTES_SECONDS_TOTAL = 60;
    private final int TIME_MIN = 0;

    public static void main(String[] args) {
        TimeTest timeTest = new TimeTest(10, 30, 30);
        System.out.println(timeTest.toString());

        timeTest.changeSecond(61);
        System.out.println("changeSecond(61)=" + timeTest.toString());
        timeTest.changeMinute(61);
        System.out.println("changeMinute(61)=" + timeTest.toString());
        timeTest.changeHour(25);
        System.out.println("changeHour(25)=" + timeTest.toString());

        timeTest.setTime(10, 30, 30);
        timeTest.changeSecond(-61);
        System.out.println("changeSecond(-61)=" + timeTest.toString());
        timeTest.changeMinute(-61);
        System.out.println("changeMinute(-61)=" + timeTest.toString());
        timeTest.changeHour(-25);
        System.out.println("changeHour(-25)=" + timeTest.toString());

        timeTest.setTime(10, 30, 30);
        timeTest.changeTime(25, 61, 61);
        System.out.println("changeTime(25, 61, 61)=" + timeTest.toString());

        timeTest.setTime(10, 30, 30);
        timeTest.changeTime(-25, -61, -61);
        System.out.println("changeTime(-25, -61, -61)=" + timeTest.toString());
    }

    public TimeTest(int hour, int minute, int second) {
        this.hour = checkedHour(hour);
        this.minute = checkedMinuteOrSecond(minute);
        this.second = checkedMinuteOrSecond(second);
    }

    @Override
    public String toString() {
        return hour + " hours " + minute + " minutes " + second + " seconds";
    }

    private int checkedHour(int hour) {
        return hour < TIME_MIN || hour > HOUR_MAX_AVAILABLE ? 0 : hour;
    }

    private int checkedMinuteOrSecond(int minute) {
        return minute < TIME_MIN || minute > MINUTE_SECOND_MAX_AVAILABLE ? 0 : minute;
    }

    public void changeHour(int hour) {
        int newHour = this.hour + hour;
        this.hour = (HOURS_TOTAL + newHour % HOURS_TOTAL) % HOURS_TOTAL;
    }

    public void changeMinute(int minute) {
        int newMinute = this.minute + minute;
        int hoursToChange = newMinute / MINUTES_SECONDS_TOTAL;
        int minutesToChange = newMinute % MINUTES_SECONDS_TOTAL;

        if (newMinute < TIME_MIN && minutesToChange != 0) {
            hoursToChange--;
        }
        this.minute = (MINUTES_SECONDS_TOTAL + minutesToChange) % MINUTES_SECONDS_TOTAL;

        if (hoursToChange != 0) {
            changeHour(hoursToChange);
        }
    }

    public void changeSecond(int second) {
        int newSecond = this.second + second;
        int minutesToChange = newSecond / MINUTES_SECONDS_TOTAL;
        int secondsToChange = newSecond % MINUTES_SECONDS_TOTAL;

        if (newSecond < TIME_MIN && secondsToChange != 0) {
            minutesToChange--;
        }
        this.second = (MINUTES_SECONDS_TOTAL + secondsToChange) % MINUTES_SECONDS_TOTAL;
        if (minutesToChange != 0) {
            changeMinute(minutesToChange);
        }
    }

    public void changeTime(int hours, int minutes, int seconds) {
        changeSecond(seconds);
        changeMinute(minutes);
        changeHour(hours);
    }

    public void setTime(int hours, int minutes, int seconds) {
        this.hour = checkedHour(hours);
        this.minute = checkedMinuteOrSecond(minutes);
        this.second = checkedMinuteOrSecond(seconds);
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = checkedHour(hour);
    }

    public int getMinute() {
        return checkedMinuteOrSecond(minute);
    }

    public void setMinute(int minute) {
        this.minute = checkedMinuteOrSecond(minute);
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = checkedMinuteOrSecond(second);
    }
}
