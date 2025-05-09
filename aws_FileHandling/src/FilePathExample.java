import java.io.File;

public class FilePathExample {
    public static void main(String[] args) {
        String noteAddress = "Documents/note.txt";
        String diagramAddress = "Documents/images/diagram.png";

        checkForFileOrDirectory(noteAddress);
        checkForFileOrDirectory(diagramAddress);
    }

    public static void checkForFileOrDirectory(String path){
        File file = new File(path);

        System.out.println("Path: " + file.getAbsolutePath());

        if(file.exists()){
            if(file.isFile()){
                System.out.println("The " + path + " is a File\n");
            }
            else {
                    System.out.println("The " + path + " is a Directory name.");
            }
        }
        else {
            System.out.println("The path provided does not exists.");
        }
    }
}
