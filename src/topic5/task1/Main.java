package topic5.task1;

import java.util.ArrayList;
import java.util.List;

/**
 * EPAM Java0Practice. Topic 5. Task 1.
 * Создать объект класса Текстовый файл, используя классы Файл, Директория.
 * Методы: создать, переименовать, вывести на консоль содержимое, дополнить, удалить.
 *
 * @author Natallia Bialiatskaya
 * @since 11.08.2021
 */

public class Main {

    public static void main(String[] args) {

        Directory rootDirectory = new Directory("V:\\", true);
        Directory directory = new Directory("Projects");
        List<Directory> list1 = new ArrayList<>();
        list1.add(directory);

        rootDirectory.setDirectories(list1);

        try {
            TextFile txtFile = new TextFile(directory, "txtFile", "content of my text file.\nSecond string.\n".getBytes());
            directory.addFile(txtFile);

            txtFile.create();
            System.out.println(txtFile.getFullName() + ":");
            txtFile.showContent();
            txtFile.rename("newTxtFile");
            txtFile.append("Hello, World!");

            System.out.println("\n" + txtFile.getFullName() + ":");
            txtFile.showContent();
            txtFile.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
