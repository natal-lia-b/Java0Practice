package topic5.task1;

import java.io.FileInputStream;
import java.io.IOException;

public class TextFile extends File {
    public TextFile() {
    }

    public TextFile(Directory directory, String name) {
        super(directory, name, "txt");
    }

    public TextFile(Directory directory, String name, byte[] content) {
        super(directory, name, "txt", content);
    }

    public void showContent() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(getFile());
        while (fileInputStream.available() > 0) {
            System.out.print((char) fileInputStream.read());
        }
        fileInputStream.close();
    }

}
