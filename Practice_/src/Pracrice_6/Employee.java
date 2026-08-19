package Pracrice_6;

public class Employee {
    public String name;
    public double salary;
    public String role;

    public Employee(){
        this.name = "";
        this.salary = 0.0;
    }

    Employee(String name, double salary, String role){
        this.name = name;
        this.salary = salary;
        this.role = role;
    }

    public void work() {
        System.out.println(name + " is doing employe task");
    }

    public void displayDetail(){
        System.out.println("Name : " + name + " | Salary : " + salary + " | Role : " + role);
    }
}
