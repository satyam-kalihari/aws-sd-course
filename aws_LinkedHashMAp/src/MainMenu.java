import java.util.Map;
import java.util.Scanner;
import java.util.LinkedHashMap;

public class MainMenu {

    static String name;

    public static void menu(LinkedHashMap<String, String> libraryData) {
        Scanner keyboard = new Scanner(System.in);
        int choice;
        boolean test =true;

        while (test){

            System.out.println("Enter the choice \n1> Borrow \n2>Return \n3>Check \n4> Display all");
            choice = keyboard.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter name: ");
                    name = keyboard.next();

                    System.out.println("Enter book name: ");
                    String bookName = keyboard.next();

                    if (libraryData.containsValue(bookName)){
                        System.out.println("Sorry, the book has already been borrowed");
                    }else {
                        String putData = libraryData.put(name, bookName);
                    }
                    break;

                case 2:
                    System.out.println("Enter name: ");
                    name = keyboard.next();

                    if (libraryData.containsKey(name)){
                        String removedEntry = libraryData.remove(name);
                    }else {
                        System.out.println("They haven’t borrowed any book.");
                    }
                    break;


                case 3:
                    System.out.println("Enter name: ");
                    name = keyboard.next();

                    if (libraryData.containsKey(name)){
                        String getData = libraryData.get(name);

                        System.out.println("Tittle of the book: "+getData);
                    }else {
                        System.out.println("They haven’t borrowed any book.");
                    }
                    break;


                case 4:
                    for (Map.Entry<String, String> entry: libraryData.entrySet()){
                        System.out.println("Name: "+entry.getKey()+" Tittle of book: "+entry.getValue());
                    }
                    break;


                default:
                    test = false;
                    break;
            }
        }

    }

}
