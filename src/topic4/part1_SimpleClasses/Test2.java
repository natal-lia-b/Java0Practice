package topic4.part1_SimpleClasses;

/**
 * 2. Создйте класс Test2 двумя переменными.
 * Добавьте конструктор с входными параметрами.
 * Добавьте конструктор, инициализирующий члены класса по умолчанию.
 * 7 Добавьте set- и get- методы для полей экземпляра класса.
 */

public class Test2 {
    private int var1;
    private int var2;

    public Test2(int var1, int var2) {
        this.var1 = var1;
        this.var2 = var2;
    }

    public Test2() {
        this.var1 = 27;
        this.var2 = 12;
    }

    private void setVar1(int var1) {
        this.var1 = var1;
    }

    private void setVar2(int var1) {
        this.var1 = var2;
    }

    private int getVar1() {
        return var1;
    }

    private int getVar2() {
        return var2;
    }

    public static void main(String[] args) {
        Test2 test2_1 = new Test2(28, 76);
        System.out.printf("var1 = %d,  var2 = %d", test2_1.getVar1(), test2_1.getVar2());
        Test2 test2_2 = new Test2();
        System.out.printf("%nvar1 = %d,  var2 = %d", test2_2.getVar1(), test2_2.getVar2());
    }
}
