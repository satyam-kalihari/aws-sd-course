
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class Animal implements Eat, Serializable {

    String name;
    String color;
    String food;

    public Animal(String name, String color, String food) {
        this.name = name;
        this.color = color;
        this.food = food;
    }

    public void animalHasStartedEating(){
        System.out.println(name + " has started Eating");
    };

    public void writeInFile(String fileName, Animal text){
        Path directoryPath = Paths.get("Animal_data/"+fileName);
        try {
            if (!Files.exists(directoryPath)){
                Files.createDirectories(directoryPath);
            }
            FileWriter fw = new FileWriter(directoryPath+"/"+fileName+".txt", true);
            fw.write(text.toString()+"\n");
            fw.close();

            System.out.println("Data has been saved to "+fileName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void readFromFile(String fileName){
        try(FileReader readerFile = new FileReader("Animal_data/"+fileName+"/"+fileName+".txt")) {
            int data = readerFile.read();
            while (data != -1){
                System.out.print((char) data);
                data = readerFile.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
