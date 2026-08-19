package VehicleSystem;

public class Main {
    public static void main(String []args){

        Car myCar = new Car();
        Bike myBike = new Bike();
        Bus myBus = new Bus();

        System.out.println("=== Starting Individualy ===");
        myCar.Start();
        myBike.Start();
        myBus.Start();
    }
}
