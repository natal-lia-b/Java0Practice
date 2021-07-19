package topic4.part1_SimpleClasses;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 4. Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
 * Создайте данные в массив из пяти элементов типа Train,
 * добавьте возможность сортировки элементов массива по номерам поездов.
 * Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
 * Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми пунктами назначения должны быть упорядочены по времени отправления.
 */

public class Train {
    private String destinationPoint;
    private int trainNum;
    private String departureTime;

    public Train(String destinationPoint, int trainNum, String departureTime) {
        this.destinationPoint = destinationPoint;
        this.trainNum = trainNum;
        this.departureTime = departureTime;
    }

    public String getDestinationPoint() {
        return destinationPoint;
    }

    public void setDestinationPoint(String destinationPoint) {
        this.destinationPoint = destinationPoint;
    }

    public int getTrainNum() {
        return trainNum;
    }

    public void setTrainNum(int trainNum) {
        this.trainNum = trainNum;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    @Override
    public String toString() {
        return "Train{" +
                "destination point='" + destinationPoint + '\'' +
                ", train number=" + trainNum +
                ", departure time='" + departureTime + '\'' +
                '}';
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public static void main(String[] args) {
        Train[] trains = new Train[5];
        createTrains(trains);
        System.out.println(Arrays.toString(trains));
        System.out.println("Sorted train by numbers:\n" + Arrays.toString(sortTrainsByNums(trains)));
        System.out.println(getTrainByNum(trains));
        System.out.println("Sorted train by destination points:\n" + Arrays.toString(sortTrainsByDestinationPoint(trains)));
    }

    private static Train[] sortTrainsByDestinationPoint(Train[] trains) {
        Train[] sortedTrains = Arrays.copyOf(trains, trains.length);
        for (int i = 0; i < sortedTrains.length; i++) {
            for (int j = i + 1; j < sortedTrains.length; j++) {
                int compareDestinationPoints = sortedTrains[i].getDestinationPoint().compareTo(sortedTrains[j].getDestinationPoint());
                if (compareDestinationPoints > 0 || (compareDestinationPoints == 0 &&
                        sortedTrains[i].getDepartureTime().compareTo(sortedTrains[j].getDepartureTime()) > 0)) {
                    Train copyTrain = sortedTrains[i];
                    sortedTrains[i] = sortedTrains[j];
                    sortedTrains[j] = copyTrain;
                }
            }
        }
        return sortedTrains;
    }

    private static String getTrainByNum(Train[] trains) {
        int number = getUsersTrainNumber();
        String result = "Train " + number + " is not found.";
        int i = 0;
        while (i < trains.length) {
            if (trains[i].getTrainNum() == number) {
                result = trains[i].toString();
                break;
            }
            i++;
        }
        return result;
    }

    private static int getUsersTrainNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input train number:");
        return scanner.nextInt();
    }

    private static Train[] sortTrainsByNums(Train[] trains) {
        Train[] sortesTrains = Arrays.copyOf(trains, trains.length);
        for (int i = 0; i < sortesTrains.length; i++) {
            for (int j = i + 1; j < sortesTrains.length; j++) {
                if (sortesTrains[i].getTrainNum() > sortesTrains[j].getTrainNum()) {
                    Train copyTrain = sortesTrains[i];
                    sortesTrains[i] = sortesTrains[j];
                    sortesTrains[j] = copyTrain;
                }
            }
        }
        return sortesTrains;
    }

    private static void createTrains(Train[] trains) {
        int i = 0;
        trains[i++] = new Train("Minsk", 723, "20-10");
        trains[i++] = new Train("Brest", 123, "12-15");
        trains[i++] = new Train("Vitebsk", 289, "12-38");
        trains[i++] = new Train("Minsk", 722, "10-30");
        trains[i] = new Train("Grodno", 428, "15-14");
    }
}
