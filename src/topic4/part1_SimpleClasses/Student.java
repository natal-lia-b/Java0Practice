package topic4.part1_SimpleClasses;

/**
 * 3. Создайте класс с именем Student, содержащий поля:
 * фамилия и инициалы, номер группы, успеваемость (массив из пяти элементов).
 * Создайте массив из десяти элементов такого типа.
 * Добавьте возможность вывода фамилий и номеров групп студентов, имеющих оценки, равные только 9 или 10.
 */

public class Student {
    private String surname;
    private String groupNum;
    private int[] marks;

    public Student(String surname, String groupNum, int[] marks) {
        this.surname = surname;
        this.groupNum = groupNum;
        this.marks = marks;
    }

    private boolean isFine() {
        boolean isFine = true;
        int i = 0;
        while (i < marks.length) {
            if (marks[i] < 9) {
                isFine = false;
                break;
            }
            i++;
        }
        return isFine;
    }

    public void printIfFine() {
        if (isFine()) {
            System.out.printf("%-20s%-8s%n", surname, groupNum);
        }
    }

    public static void main(String[] args) {
        Student[] students = new Student[10];
        students[0] = new Student("Borzou0 N.0.", "ASU930", new int[]{9, 10, 9, 10, 9});
        students[1] = new Student("Borzou1 N.1.", "ASU931", new int[]{5, 6, 7, 8, 9});
        students[2] = new Student("Borzou2 N.2.", "ASU932", new int[]{8, 8, 9, 8, 9});
        students[3] = new Student("Borzou3 N.3.", "ASU933", new int[]{10, 6, 9, 8, 5});
        students[4] = new Student("Borzou4 N.4.", "ASU934", new int[]{10, 9, 9, 10, 9});
        students[5] = new Student("Borzou5 N.5.", "ASU935", new int[]{9, 6, 7, 8, 9});
        students[6] = new Student("Borzou6 N.6.", "ASU936", new int[]{9, 9, 9, 9, 9});
        students[7] = new Student("Borzou7 N.7.", "ASU937", new int[]{3, 4, 5, 6, 5});
        students[8] = new Student("Borzou8 N.8.", "ASU938", new int[]{9, 10, 10, 10, 10});
        students[9] = new Student("Borzou9 N.9.", "ASU939", new int[]{8, 6, 8, 8, 8});

        for (Student student : students) {
            student.printIfFine();
        }
    }
}
