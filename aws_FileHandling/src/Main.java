import java.io.*;

public class Main {
    public static void main(String[] args) {
        File file = new File("Documents/note.txt");
        
        //FOR READING A FILE
        try (FileInputStream inputStream = new FileInputStream(file)){
            byte[] fileContentAsByte = inputStream.readAllBytes();
            for (byte b : fileContentAsByte) {
                System.out.print((char) b);
            }
        }catch (FileNotFoundException e){
            System.err.println("Sorry can't find the file.");
        }catch (IOException e){
            System.out.println(e);
        }
    }
}