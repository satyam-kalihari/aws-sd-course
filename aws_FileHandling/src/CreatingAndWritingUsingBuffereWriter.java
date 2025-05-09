import java.io.*;
import java.util.Scanner;

public class CreatingAndWritingUsingBuffereWriter {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the file name: ");;
        String fileName = keyboard.next();
        keyboard.close();

        File file = new File("Documents/"+ fileName+".txt");
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))){
            String fileContent = "Writing third time to append using BuffereWritter in test3.txt";
            writer.write(fileContent);
            System.out.println("File has been created and content has been written.");
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
