package topic1.linear_programs;

/*5. Дано натуральное число Т, которое представляет длительность прошедшего времени в секундах.
Вывести данное значение длительности в часах, минутах и секундах в следующей форме:
ННч ММмин SSc.*/

public class Task5 {
    final static int SEC_IN_HOUR = 3600;
    final static int SEC_IN_MINUTE = 60;

    public static void main(String[] args) {
        convertSecIntoTime(8015);
        convertSecIntoTime(3666);
    }

    public static void convertSecIntoTime(long t) {
        long hours = t / SEC_IN_HOUR;
        long min = (t - hours * SEC_IN_HOUR) / SEC_IN_MINUTE;
        long sec = t - hours * SEC_IN_HOUR - min * SEC_IN_MINUTE;
        System.out.println(hours + "ч " + min + "мин " + sec + "c.");
    }
}
