import java.util.Scanner;

public class MainMenu {
    public static void menu(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the choice: \n1. Enter data\n2. Show all animal\nexit");
        int choice = keyboard.nextInt();

        if (choice == 1){
            System.out.println("Insert data to: \n1. Tiger\n2. Dolphin");
            choice = keyboard.nextInt();

            String name;
            System.out.println("Enter the name: ");
            name = keyboard.next();

            String color;
            System.out.println("Enter the color: ");
            color = keyboard.next();

            String food;
            System.out.println("Enter the food: ");
            food = keyboard.next();

            if (choice == 1){
                Tiger t1;
                t1 = new Tiger(name, color, food);
                menu();
            } else if (choice == 2) {
                Dolphin d1;
                d1 = new Dolphin(name, color, food);
                menu();
            }else {
                System.out.println("please enter a valid choice");
                menu();
            }
        }
        else if (choice == 2) {

            System.out.println("Read data to: \n1. Tiger\n2. Dolphin");
            choice = keyboard.nextInt();
            if (choice == 1){
//                Tiger.getAllTiger();
                Animal.readFromFile("tiger");
//                Tiger.deserialize("pippo");
                menu();
            } else if (choice == 2) {
//                Dolphin.getAllDolphins();
                Animal.readFromFile("dolphin");
//                Dolphin.deserialize("lara");
                menu();
            }else {
                System.out.println("please enter a valid choice");
                menu();
            }

        } else if (choice == 3) {
            return;
        } else {
            System.out.println("please enter a valid choice");
            menu();
        }
    }
}
