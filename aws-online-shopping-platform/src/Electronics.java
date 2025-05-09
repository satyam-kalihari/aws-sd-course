public class Electronics extends  Product {

    int warrantyPeriodInMonths;

    Electronics(String name, double price, int warrantyPeriodInMonths){
        super(name, price);
        this.warrantyPeriodInMonths = warrantyPeriodInMonths;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Warranty period is " + warrantyPeriodInMonths + " months.");
    }
}
