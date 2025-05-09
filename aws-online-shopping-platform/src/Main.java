public class Main {

    public static void main(String[] args) {
        Electronics laptop = new Electronics("ASUS", 69999, 24);
        Clothing shirt = new Clothing("kakashi", 1299, "xs");

        ShoppingCart cart = new ShoppingCart();

        cart.addItem(laptop);
        cart.addItem(shirt);
    }
}