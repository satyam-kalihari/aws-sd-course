import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Tiger extends Animal implements Walk, Serializable{

    private static final List<Tiger> allTiger = new ArrayList<>();
    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Tiger{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", food='" + food + '\'' +
                '}';
    }

    public Tiger(String name, String color, String food){
        super(name, color, food);
        allTiger.add(this);
        writeInFile("tiger", this);
        serialize();
    }

    public void animalHasStartedEating(){
        System.out.println("Tiger has started eating.");
    };

    public void animalIsEating(){
        System.out.println("Tiger its other animals.");
        System.out.println("So, " + name + " is eating " + food + ".");
    };

    @Override
    public void walkForward(int meter) {
        System.out.println("Tiger has walked " + meter + " meter forward.");
    }

    @Override
    public void walkBackward(int meter) {
        System.out.println("Tiger has walked " + meter + " meter backward.");
    }

    @Override
    public void walkLeft(int meter) {
        System.out.println("Tiger has walked " + meter + " meter to the left.");
    }

    @Override
    public void walkRight(int meter) {
        System.out.println("Tiger has walked " + meter + " meter to the right.");
    }

    public static void getAllTiger(){
        for (Tiger tiger : allTiger){
            System.out.println("Tiger name: "+tiger.name+", color: "+tiger.color+", food: "+tiger.food);
        }
    }


    public void serialize(){
        Path directoryPath = Paths.get("tiger");
        try{
            if (!Files.exists(directoryPath)){
                Files.createDirectories(directoryPath);
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        try(FileOutputStream fos = new FileOutputStream("tiger/"+this.name+".ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(this);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }


    public static void deserialize(String fileName) {
        Animal restoredTiger;
        try(FileInputStream fis = new FileInputStream("tiger/"+fileName+".ser");
        ObjectInputStream ois = new ObjectInputStream(fis);){
            Object restoredObject = ois.readObject();
            restoredTiger = (Animal) restoredObject;
            System.out.println("Data have been retried successfully: "+restoredTiger);
        }catch (FileNotFoundException | ClassNotFoundException e){
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
