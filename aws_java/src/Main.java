public class Main{

    public static void main(String[] args){
//        Car colorado = new Car();
//        colorado.make = "Chevrolet";
//        colorado.model = "Colorado";
//        colorado.color = "Red";
//
//        System.out.println(colorado);

        Camera myFavoriteCamera = new Camera();
        myFavoriteCamera.takePicture("portrait");
        myFavoriteCamera.takePicture(12);
        myFavoriteCamera.takePicture("landscape", 24);//compile time polymorphism
    }
}