package topic1.part2_branching;

/*4. Заданы размеры А, В прямоугольного отверстия и размеры х, у, z кирпича.
Определить, пройдет ли кирпич через отверстие.*/

public class Task4 {
    public static void main(String[] args) {
        checkBrick(4, 9, 10, 2, 3);  // yes
        checkBrick(4, 9, 10, 12, 5);  // no
    }

    public static void checkBrick(int a, int b, int x, int y, int z) {
        if ((a >= x && b >= y) || (a >= y && b >= x) ||
                (a >= x && b >= z) || (a >= z && b >= x) ||
                (a >= y && b >= z) || (a >= z && b >= y))  {
            System.out.println("The brick can be gone through the hole");
        } else {
            System.out.println("The brick can't be gone through the hole");
        }
    }
}
