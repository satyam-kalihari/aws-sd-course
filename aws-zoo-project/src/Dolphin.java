import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Dolphin extends Animal implements Swim, Serializable {

    private static final List<Dolphin> allDolphin = new ArrayList<>();
    @Serial
    private static final long serialVersionUID = 1L;


    public Dolphin(String name, String color, String food){
        super(name, color, food);
        allDolphin.add(this);
        writeInFile("dolphin", this);
        serialize();
    }

    @Override
    public String toString() {
        return "Dolphin{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", food='" + food + '\'' +
                '}';
    }

    public void animalIsEating(){
        System.out.println("Dolphin its sea food.");
        System.out.println("So, " + name + " is eating " + food + ".");
    }

    @Override
    public void swimForward(int meter){
        System.out.println(name + " has swam " + meter + " forward.");
    }

    @Override
    public void swimBackward(int meter) {
        System.out.println(name + " has swam " + meter + " backward.");
    }

    public static void getAllDolphins(){
        for (Dolphin dolphin : allDolphin){
            System.out.println("Dolphin name: "+dolphin.name+", color: "+dolphin.color+", food: "+dolphin.food);
        }
    }


    public void serialize() {
        Path directoryPath = Paths.get("dolphin");
        try{
            if (!Files.exists(directoryPath)){
                Files.createDirectories(directoryPath);
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        try(FileOutputStream fos = new FileOutputStream("dolphin/"+this.name+".ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(this);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    @Override
    public static void deserialize(String fileName) {
        Dolphin restoredDolphin;
        try(FileInputStream fis = new FileInputStream("dolphin/"+fileName+".ser");
            ObjectInputStream ois = new ObjectInputStream(fis);){
            Object restoredObject = ois.readObject();
            restoredDolphin = (Dolphin) restoredObject;
            System.out.println("Data have been retried successfully: "+restoredDolphin);
        } catch (ClassNotFoundException | IOException e){
            throw new RuntimeException(e);
        }
    }
}
