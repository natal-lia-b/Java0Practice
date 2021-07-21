package topic4.part1_SimpleClasses.task9;

import java.util.Arrays;

/**
 * 9. Создать класс Book, спецификация которого приведена ниже.
 * Определить конструкторы, set- и get- методы и метод toString().
 * Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и методами.
 * Задать критерии выбора данных и вывести эти данные на консоль.
 * Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
 * Найти и вывести:
 * a) список книг заданного автора;
 * b) список книг, выпущенных заданным издательством;
 * c) список книг, выпущенных после заданного года.
 */

public class Book {
    private static int idClass = 1;
    private int id;
    private String name;
    private String[] authors;
    private String publishingHouse;
    private int publishingYear;
    private int pagesAmount;
    private double cost;
    private int bindingType;

    public Book(String name, String[] authors, String publishingHouse, int publishingYear, int pagesAmount, double cost, int bindingType) {
        this.id = idClass++;
        this.name = name;
        this.authors = authors;
        this.publishingHouse = publishingHouse;
        this.publishingYear = publishingYear;
        this.pagesAmount = pagesAmount;
        this.cost = cost;
        this.bindingType = bindingType;
    }

    public Book(String name, String[] authors, String publishingHouse, int publishingYear) {
        this.id = idClass++;
        this.name = name;
        this.authors = authors;
        this.publishingHouse = publishingHouse;
        this.publishingYear = publishingYear;
    }

    public static void main(String[] args) {
        Book book = new Book("Java", new String[]{"G. Shilds"}, "PiterPub", 2020);
        System.out.println(book.toString());
        Book book2 = new Book("Java2", new String[]{"G. Shilds2"}, "PiterPub2", 2021);
        System.out.println(book2.toString() + book2.id);
    }

    @Override
    public String toString() {
        return id + "[\'" + name +
                "\', authors = " + Arrays.toString(authors) +
                " (" + publishingHouse + ", " +
                publishingYear + ")]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public int getPagesAmount() {
        return pagesAmount;
    }

    public void setPagesAmount(int pagesAmount) {
        this.pagesAmount = pagesAmount;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getBindingType() {
        return bindingType;
    }

    public void setBindingType(int bindingType) {
        this.bindingType = bindingType;
    }
}
