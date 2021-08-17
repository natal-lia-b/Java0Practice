package topic5.task4;

import topic5.task4.action.FillTreasureCollection;
import topic5.task4.action.TheMostExpensiveTreasure;
import topic5.task4.entity.TreasureCollection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * EPAM Java0Practice. Topic 5. Задача 4.
 *
 * Создать консольное приложение, удовлетворяющее следующим требованиям:
 * • Приложение должно быть объектно-, а не процедурно-ориентированным.
 * • Каждый класс должен иметь отражающее смысл название и информативный состав.
 * • Наследование должно применяться только тогда, когда это имеет смысл.
 * • При кодировании должны быть использованы соглашения об оформлении кода java code convention.
 * • Классы должны быть грамотно разложены по пакетам.
 * • Консольное меню должно быть минимальным.
 * • Для хранения данных можно использовать файлы.
 *
 * Дракон и его сокровища.
 * Создать программу, позволяющую обрабатывать сведения о 100 сокровищах в пещере дракона.
 * Реализовать возможность просмотра сокровищ, выбора самого дорогого по стоимости сокровища и выбора сокровищ на заданную сумму.
 *
 * @author Natallia Bialiatskaya
 * @since 16.08.2021
 */

public class Main {

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        String message = "\nMain menu:\n" +
                "1 - show all dragon treasure,\n" +
                "2 - find the most expensive treasure,\n" +
                "3 - select treasures for a given amount,\n" +
                "0 - exit.\n" +
                "Choose the action: ";
        TreasureCollection treasureCollection = FillTreasureCollection.fill();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while(true) {
                System.out.print(message);
                int inputNumber = Integer.valueOf(bufferedReader.readLine());

                switch (inputNumber) {
                    case 1: {
                        System.out.println(treasureCollection.toString());
                        break;
                    }
                    case 2: {
                        System.out.println(TheMostExpensiveTreasure.find(treasureCollection.getTreasures()));
                        break;
                    }
                    case 0: {
                        return;
                    }
                    default: {
                        System.out.println("Bad input, try again.");
                    }
                }
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
