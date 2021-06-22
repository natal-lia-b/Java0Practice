package topic1.branching;

/* 3. Даны три точки А(х1,у1), В(х2,у2) и С(х3,у3).
Определить, будут ли они расположены на одной прямой.*/

public class Task3 {
    public static void main(String[] args) {
        isStraightLine(1, 2, 2, 4, 3, 6);
    }

    // equation of a straight line passing through two points:
    // (x - x1) / (x2 - x1) = (y - y1) / (y2 - y1)
    public static void isStraightLine (int x1, int y1, int x2, int y2, int x3, int y3) {
        double precision = 0.001;
        System.out.println((x3 - x1) * (y2 - y1) - (x2 - x1) * (y3 - y1) <= precision);
    }
}
