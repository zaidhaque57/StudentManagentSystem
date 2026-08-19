package Pracrice_6;

public class Developer extends Employee {

    public Developer(String name, double salary, String role){
        super(name,salary,role);
    }

    public void work(){
        System.out.println(name + " is waiting java code, dubugging, and testing software.");
    }
}
