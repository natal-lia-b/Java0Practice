package topic4.part1_SimpleClasses.task9;

import java.util.Scanner;

public class Books {
    private Book[] booksArray;

    public Books(Book[] booksArray) {
        this.booksArray = booksArray;
    }

    public Books() {
    }

    public static void main(String[] args) {
        Books books = createBooks();
        System.out.println("Books = \n" + books.toString());

        System.out.print("Input author's name: ");
        Scanner scanner = new Scanner(System.in);
        String filter = scanner.nextLine();
        books.printBooksByAuthor(filter);

        System.out.print("\nInput publishing house: ");
        filter = scanner.nextLine();
        books.printBooksByPublishingHouse(filter);

        System.out.print("\nInput year: ");
        int filterYear = scanner.nextInt();
        books.printBooksAfterYear(filterYear);
    }

    public void printBooksAfterYear(int filterYear) {
        for (Book book : booksArray) {
            if (book.getPublishingYear() > filterYear) {
                System.out.println(book.toString());
            }
        }
    }

    public void printBooksByPublishingHouse(String filter) {
        for (Book book : booksArray) {
            if (book.getPublishingHouse().equalsIgnoreCase(filter)) {
                System.out.println(book.toString());
            }
        }
    }

    public void printBooksByAuthor(String filter) {
        for (Book book : booksArray) {
            for (String oneAuthor : book.getAuthors()) {
                if (oneAuthor.equalsIgnoreCase(filter)) {
                    System.out.println(book.toString());
                    break;
                }
            }
        }
    }

    private static Books createBooks() {
        Book[] array = new Book[5];
        int i = 0;
        array[i++] = new Book("Java8", new String[]{"G3. Shilds"}, "PiterPub3", 2008);
        array[i++] = new Book("Java", new String[]{"G1. Shilds"}, "PiterPub1", 2000);
        array[i++] = new Book("Java1.6", new String[]{"G3. Shilds"}, "PiterPub5", 2020);
        array[i++] = new Book("Java15", new String[]{"G44. Shilds"}, "PiterPub4", 2015);
        array[i] = new Book("Java11", new String[]{"G2. Shilds"}, "PiterPub4", 2005);
        return new Books(array);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Book book : booksArray) {
            result.append(book.toString().concat("\n"));
        }
        return result.toString();
    }

    public Book[] getBooksArray() {
        return booksArray;
    }

    public void setBooksArray(Book[] booksArray) {
        this.booksArray = booksArray;
    }
}
