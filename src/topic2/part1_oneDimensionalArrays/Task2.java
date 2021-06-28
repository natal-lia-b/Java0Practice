package topic2.part1_oneDimensionalArrays;

import java.util.Scanner;

/** 2. Дана последовательность действительных чисел а1 ,а2 ,..., ап. Заменить все ее члены, большие данного Z, этим
 числом. Подсчитать количество замен.*/

public class Task2 {

    public static void main(String[] args) {
        double[] array = {1, -10, 18, 0.2, 25, -36, 12.5, 5};
        System.out.println("Enter number and press <Enter>:");
        Scanner scan = new Scanner(System.in);
        double z = scan.nextDouble();
        System.out.println("Count = " + count(z, array));
    }

    static int count(double z, double[] array){
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > z) {
                array[i] = z;
                count++;
            }
            System.out.println("array[" + i + "] = " + array[i]);
        }
        return count;
    }
}
