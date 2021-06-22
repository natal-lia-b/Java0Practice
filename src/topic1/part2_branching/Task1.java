package topic1.part2_branching;

/* 1. Даны два угла треугольника (в градусах). Определить, существует ли такой треугольник,
*  и если да, то будет ли он прямоугольным.*/

public class Task1 {
    public static void main(String[] args) {
        checkTriangle(20, 175);  // false
        checkTriangle(90, 30);  // true
        checkTriangle(60, 30);  // true
        checkTriangle(100, 80);  // false
    }

    public static void checkTriangle(double angle1, double angle2) {
        double angle3 = 180 - angle1 - angle2;
        System.out.println(angle1 + "  " + angle2 + "  " + angle3);
        if (angle3 > 0) {
            System.out.println("The triangle exists");
            if ((angle1 - (int) angle1 == 0 && angle1 == 90) ||
                    (angle2 - (int) angle2 == 0 && angle2 == 90) ||
                    (angle3 - (int) angle3 == 0 && angle3 == 90)) {
                System.out.println("The triangle is rectangular");
            }
        } else {
            System.out.println("The triangle doesn't exists");
        }
        System.out.println();
    }
}
