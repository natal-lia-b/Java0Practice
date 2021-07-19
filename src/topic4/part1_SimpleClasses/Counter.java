package topic4.part1_SimpleClasses;

/**
 * 5. Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать свое значение на единицу в заданном диапазоне.
 * Предусмотрите инициализацию счетчика значениями по умолчанию и произвольными значениями.
 * Счетчик имеет методы увеличения и уменьшения состояния, и метод позволяющее получить его текущее состояние.
 * Написать код, демонстрирующий все возможности класса.
 */

public class Counter {
    private int minNum;
    private int maxNum;
    private int currentState;

    public Counter() {
        minNum = 10;
        maxNum = 18;
        currentState = 15;
    }

    public Counter(int minNum, int maxNum, int currentState) {
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.currentState = currentState;
    }

    public int getCurrentState() {
        return currentState;
    }

    public void countPlus() {
        currentState = currentState < maxNum ? currentState + 1 : currentState;
    }

    public void countMinus() {
        currentState = currentState > minNum ? currentState - 1 : minNum;
    }

    public int getMinNum() {
        return minNum;
    }

    public int getMaxNum() {
        return maxNum;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "min state = " + minNum +
                ", max state = " + maxNum +
                ", current state = " + currentState +
                '}';
    }

    public static void main(String[] args) {
        Counter counter1 = new Counter();
        System.out.println(counter1.toString());
        increase(counter1, 10);
        decrease(counter1, 10);

        Counter counter2 = new Counter(25, 30, 28);
        System.out.println(counter2.toString());
        increase(counter2, 10);
        decrease(counter2, 10);
    }

    private static void decrease(Counter counter1, int amount) {
        System.out.println("Here we'll try to increase current state (=" + counter1.getCurrentState() + ") " + amount + " times:");
        for (int i = 0; i < amount; i++) {
            counter1.countPlus();
            System.out.println(counter1.currentState);
        }
    }

    private static void increase(Counter counter1, int amount) {
        System.out.println("Here we'll try to decrease current state (=" + counter1.getCurrentState() + ") " + amount + " times:");
        for (int i = 0; i < amount; i++) {
            counter1.countMinus();
            System.out.println(counter1.currentState);
        }
    }
}
