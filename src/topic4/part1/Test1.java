package topic4.part1;

/**
 * 1. Создайте класс Test1 двумя переменными.
 * Добавьте метод вывода на экран и методы изменения этих переменных.
 * Добавьте метод, который находит сумму значений этих переменных,
 * и метод, который находит наибольшее значение из этих двух переменных.
 */

public class Test1 {
    private int var1;
    private int var2;

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.setVar1(28);
        test1.setVar2(76);
        test1.printVars();
        System.out.println(test1.sum());
        System.out.println(test1.max());
    }

    public void printVars() {
        System.out.println(var1);
        System.out.println(var2);
    }

    public void setVar1(int var1) {
        this.var1 = var1;
    }

    public void setVar2(int var2) {
        this.var2 = var2;
    }

    public int sum() {
        return var1 + var2;
    }

    public int max(){
        return var1 > var2 ? var1 : var2;
    }
}
