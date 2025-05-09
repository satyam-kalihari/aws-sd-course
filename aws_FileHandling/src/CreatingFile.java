
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CreatingFile {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the file name: ");
        String fileName = keyboard.next();
        keyboard.close();

        File file = new File("src/"+fileName+".txt");
        try{
            boolean isFileCreated = file.createNewFile();
            System.out.println(fileName+" has been created.");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
