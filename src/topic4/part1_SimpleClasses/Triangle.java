package topic4.part1_SimpleClasses;

/**
 * 7. Описать класс, представляющий треугольник.
 * Предусмотреть методы для создания объектов, вычисления площади, периметра и точки пересечения медиан.
 */

public class Triangle {
    private double x1;
    private double y1;

    private double x2;
    private double y2;

    private double x3;
    private double y3;

    public static void main(String[] args) {
        Triangle triangle = new Triangle(0, 0, 1, 2, 2, 1);
        System.out.println(triangle.toString());
        System.out.printf("Perimeter = %8.4f\n", triangle.perimeter());
        System.out.printf("Square    = %8.4f\n", triangle.square());
        double[] meridianCoordinates = triangle.medianCoordinates();
        System.out.printf("Meridian coordinates: x = %8.4f, y = %8.4f", meridianCoordinates[0], meridianCoordinates[1]);
    }

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        double side1 = getSide(x1, y1, x2, y2);
        double side2 = getSide(x2, y2, x3, y3);
        double side3 = getSide(x1, y1, x3, y3);
        if (correctSides(side1, side2, side3) && correctSides(side2, side3, side1) && correctSides(side3, side1, side2)) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.x3 = x3;
            this.y3 = y3;
        }
    }

    public double[] medianCoordinates() {
        double[] coordinatesMeridian = new double[2];
        coordinatesMeridian[0] = (x1 + x2 + x3) / 3;
        coordinatesMeridian[1] = (y1 + y2 + y3) / 3;
        return coordinatesMeridian;
    }

    private double getSide(double x1, double y1, double x2, double y2) {
        return Math.pow(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2), 0.5);

    }

    public double perimeter() {
        return getSide(x1, y1, x2, y2) + getSide(x2, y2, x3, y3) + getSide(x1, y1, x3, y3);
    }

    public double square() {
        double p = perimeter() / 2;
        return Math.pow(p * (p - getSide(x1, y1, x2, y2)) * (p - getSide(x2, y2, x3, y3)) * (p - getSide(x1, y1, x3, y3)), 0.5);
    }

    private boolean correctSides(double side1, double side2, double side3) {
        boolean correctSides = side1 + side2 > side3;
        if (!correctSides) {
            System.out.println("Side " + side3 + " is greater than sum of " + side1 + " and " + side2 + ". Triangle is not created.");
        }
        return correctSides;
    }

    @Override
    public String toString() {
        return "Triangle {" +
                "dot1(" + x1 +
                ", " + y1 +
                "), dot2(" + x2 +
                ", " + y2 +
                "), dot3(" + x3 +
                ", " + y3 +
                ")}";
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public double getX3() {
        return x3;
    }

    public void setX3(double x3) {
        this.x3 = x3;
    }

    public double getY3() {
        return y3;
    }

    public void setY3(double y3) {
        this.y3 = y3;
    }
}
