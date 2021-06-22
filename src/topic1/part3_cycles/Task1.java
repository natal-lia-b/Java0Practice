package topic1.part3_cycles;

/*1. Напишите программу, где пользователь вводит любое целое положительное число.
А программа суммирует все числа от 1 до введенного пользователем числа.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Task1 {
    public static void main(String[] args) {
        sumNumbers();
    }

    public static void sumNumbers() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            long number = Integer.parseInt(reader.readLine());
            if (number < 1) {
                System.out.println("Number less then 1, sum can't be found.");
            } else {
                long sum = 0;
                for (long i = 1; i < number; i++) {
                    sum += i; 
                }
                System.out.println("Sum = " + sum);
            }
        } catch (Exception e) {
            System.out.println("Incorrect number, sum cannot be found.");
        }
    }
}
