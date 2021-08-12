package topic5.task1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class File {

    private Directory directory;
    private String name;
    private String extension;
    private byte[] content;
    private java.io.File file;

    public File() {
    }

    public File(Directory directory, String name, String extension) {
        this.directory = directory;
        this.name = name;
        this.extension = extension;
    }

    public File(Directory directory, String name, String extension, byte[] content) {
        this.directory = directory;
        this.name = name;
        this.extension = extension;
        this.content = content;
    }

    public void append(String string) throws IOException {
        byte[] contentToAppend = string.getBytes();
        int oldLength = content.length;
        content = Arrays.copyOf(content, oldLength + contentToAppend.length);
        System.arraycopy(contentToAppend, 0, content, oldLength, contentToAppend.length);

        writeContent(content);
    }

    public void delete() throws SecurityException {
        if (!file.delete()) {
            System.out.println("File isn't deleted.");
        }
    }

    public void create() throws NullPointerException, IOException {
        this.file = new java.io.File(getFullName());
        if (!file.createNewFile()) {
            System.out.println("File isn't created.");
        }

        writeContent(content);
    }

    private void writeContent(byte[] content) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(content);
        fos.close();
    }

    public String getFullName() {
        return directory.toString() + getNameWithExtention();
    }

    private String getNameWithExtention() {
        return name + "." + extension;
    }

    public void rename(String name) {
        try {
            setName(name);
            java.io.File newFile = new java.io.File(getFullName());
            if (file.renameTo(newFile)) {
                file = newFile;
            } else {
                System.out.println("File isn't renamed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public java.io.File getFile() {
        return file;
    }

    public void setFile(java.io.File file) {
        this.file = file;
    }

    public Directory getDirectory() {
        return directory;
    }

    public void setDirectory(Directory directory) {
        this.directory = directory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return directory.equals(file.directory) &&
                name.equals(file.name) &&
                extension.equals(file.extension) &&
                Arrays.equals(content, file.content);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(directory, name, extension);
        result = 31 * result + Arrays.hashCode(content);
        return result;
    }

    @Override
    public String toString() {
        return name + "." + extension;
    }
}
