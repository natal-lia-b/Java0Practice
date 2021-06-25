package topic1.part3_cycles;

/*8. Даны два числа. Определить цифры, входящие в запись как первого так и второго числа.*/

public class Task8 {
    public static void main(String[] args) {
        defineEqualNumerals(12569, 851);
        defineEqualNumerals(11177, 1717);
    }

    public static void defineEqualNumerals(int a, int b) {
        int minNumber = a;
        int maxNumber = b;
        if (a > b) {
            minNumber = b;
            maxNumber = a;
        }

        while (minNumber > 0) {
            int lastDigit = minNumber % 10;
            minNumber = minNumber / 10;

            int maxNumberCopy= maxNumber;
            while (maxNumberCopy > 0) {
                if (maxNumberCopy % 10 == lastDigit) {
                    System.out.print(lastDigit);
                    break;
                }
                maxNumberCopy = maxNumberCopy / 10;
            }
        }
        System.out.println();
    }
}
