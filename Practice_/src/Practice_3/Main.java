package Practice_3;

class Car {
    String brand;
    String model;
    double price;

    void display() {
        System.out.println("Brand Name : " + brand);
        System.out.println("Model Name : " + model);
        System.out.println("Price : " + price);
    }
}
public class Main{
    public static void main(String[]args){

        Car c1 = new Car();
        c1.brand = "Kia";
        c1.model = "Carem";
        c1.price = 39999.23;

        c1.display();
    }

}
