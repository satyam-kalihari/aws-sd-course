import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Penguin extends Animal implements Walk, Swim, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private static final List<Animal> allPenguin = new ArrayList<>();

    public Penguin(String name, String color, String food){
        super(name, color, food);
        allPenguin.add(this);
        writeInFile("penguin", this);
        serialize();
    }

    @Override
    public String toString() {
        return "Penguin{" +
                "food='" + food + '\'' +
                ", color='" + color + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public void walkForward(int meter) {

    }

    @Override
    public void walkBackward(int meter) {

    }

    @Override
    public void walkLeft(int meter) {

    }

    @Override
    public void walkRight(int meter) {

    }


    @Override
    public void swimForward(int meter) {

    }

    @Override
    public void swimBackward(int meter) {

    }

    @Override
    public void animalIsEating() {

    }

    public void serialize() {
        Path directoryPath = Paths.get("penguin");
        try{
            if (!Files.exists(directoryPath)){
                Files.createDirectories(directoryPath);
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        try(FileOutputStream fos = new FileOutputStream("penguin/"+this.name+".ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(this);
        }catch (FileNotFoundException e){
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    @Override
    public static void deserialize(String fileName) {
        Dolphin restoredPenguins;
        try(FileInputStream fis = new FileInputStream("penguin/"+fileName+".ser");
            ObjectInputStream ois = new ObjectInputStream(fis)){
            Object restoredObject = ois.readObject();
            restoredPenguins= (Dolphin) restoredObject;
            System.out.println("Data have been retried successfully: "+restoredPenguins);
        }catch (FileNotFoundException | ClassNotFoundException e){
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
