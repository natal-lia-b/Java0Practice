package topic1.linear_programs;

/*6. Для данной области составить линейную программу, которая печатает true,
если точка с координатами (х, у) принадлежит закрашенной области, и false — в противном случае:
(см. Task6.jpg)*/

public class Task6 {
    public static void main(String[] args) {
        checkDot(0, 0);  // true
        checkDot(-10, 1);  // false
        checkDot(1, 1);  // true
        checkDot(4, -3);  // true
    }

    public static void checkDot(int x, int y){
        boolean result = false;
        if ((y < 1 && y > -4 && x > -5 && x < 5) || (y > 0 && y < 5 && x > - 3 && x < 3)) {
            result = true;
        }

        System.out.println(result);
    }
}
