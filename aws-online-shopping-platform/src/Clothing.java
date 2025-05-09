public class Clothing extends Product {

    String size;

    public  Clothing(String name, double price, String size){
        super(name, price);
        this.size = size;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Size is " + size);
    }
}
