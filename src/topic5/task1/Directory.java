package topic5.task1;

import java.util.ArrayList;
import java.util.List;

public class Directory {

    private boolean isRoot;
    private String name;
    private Directory parentDirectory;
    private List<Directory> directories = new ArrayList<>();
    private List<File> files = new ArrayList<>();

    public Directory() {
    }

    public Directory(String name) {
        this.name = name;
        isRoot = false;
    }

    public Directory(String name, boolean isRoot) {
        this.name = name;
        this.isRoot = isRoot;
    }

    public void addFile(File file) {
        files.add(file);
    }

    public Directory getParentDirectory() {
        return parentDirectory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParentDirectory(Directory parentDirectory) {
        this.parentDirectory = parentDirectory;
    }

    public boolean isRoot() {
        return isRoot;
    }

    public void setRoot(boolean root) {
        isRoot = root;
    }

    public List<Directory> getDirectories() {
        return directories;
    }

    public void setDirectories(List<Directory> directories) {
        this.directories = directories;

        for (Directory directory : directories) {
            directory.parentDirectory = this;
        }
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    @Override
    public String toString() {
        return isRoot ? "" : parentDirectory.name +
                name + '\\';
    }
}
