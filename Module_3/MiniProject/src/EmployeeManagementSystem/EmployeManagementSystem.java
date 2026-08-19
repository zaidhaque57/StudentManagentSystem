package EmployeeManagementSystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id , String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("ID: %-4d | Name: %-12s | Dept: %-15s |Salary: ₹%.2f", id, name, department, salary);
    }
}

public class EmployeManagementSystem {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(101, "Zaid", "Engineer", 750000));
        employees.add(new Employee(102, "Rahul", "Marketing", 55000));
        employees.add(new Employee(103, "priya", "Sales", 65000));
        employees.add(new Employee(104, "Sneha", "Finace", 650000));

        System.out.println("==== All Employees ===");
        employees.forEach(emp -> System.out.println(emp));

        System.out.println("\n==== Sorted Employees ===");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .forEach(System.out::println);

        System.out.println("\n==== Sorted By Salary ===");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .forEach(System.out::println);

        System.out.println("\n==== Sorted By Name ===");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getName).reversed())
                .forEach(System.out::println);

        System.out.println("\n=== Employees By Salary ===");
        employees.stream()
                .filter(emp -> emp.getSalary() > 50000)
                .forEach(System.out::println);

    }
}
