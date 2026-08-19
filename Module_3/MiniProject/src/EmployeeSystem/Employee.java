package EmployeeSystem;

class Employee {
    private int id;
    private String name;
    private String Department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        Department = department;
        this.salary = salary;
    }

    public int getId() {return id;}
    public String getName() {return name;}
    public String getDepartment() {return Department;}
    public double getSalary() {return salary;}

    public String toString() {
        return String.format("ID: %d | Name: %s | Dept: %s | Salary: %.2f",id, name, Department, salary);
    }
}
