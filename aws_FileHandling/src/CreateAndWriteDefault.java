import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CreateAndWriteDefault {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the file name: ");
        String fileName = keyboard.next();
        keyboard.close();

        File file = new File("Documents/"+fileName+".txt");
        try(FileOutputStream outputStream = new FileOutputStream(file, true)) {
            String fileContent = "Writing third time on this file to append.";
            byte[] fileContentInBytes = fileContent.getBytes();
            outputStream.write(fileContentInBytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
