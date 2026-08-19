package practice_5;

class Employee{

    private String name;
    private double salary;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSalary(double salary) {
        if(salary > 0){
            this.salary = salary;
        }else{
            System.out.println("Error: Salary cannot be negative.update failed");
        }
    }

    public double getSalary() {
        return salary;
    }

}

public class Main {
    public static void main(String[]args){

        Employee emp = new Employee();

        emp.setName("Zaid Haque");
        emp.setSalary(20000.0);

        System.out.println("Employe Name : " + emp.getName());
        System.out.println("Employe Salary : ₹" + emp.getSalary());
    }
}
