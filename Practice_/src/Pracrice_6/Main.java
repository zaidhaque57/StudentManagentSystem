package Pracrice_6;

public class Main {
    public static void main(String[]args){

//        Create a Manager
        Manager mgr = new Manager("Alice", 15000,"senior Manager");
        mgr.displayDetail();
        mgr.work();
        System.out.println("-------------------------------------");

        mgr.name = "juli"; mgr.salary = 10000; mgr.role = "Junior Manager";
        mgr.displayDetail();
        mgr.work();
        System.out.println("-------------------------------------------------");


//        Create a Developer
        Developer dev = new Developer("Alex", 200000,"Developer");
        dev.displayDetail();
        dev.work();

    }
}
