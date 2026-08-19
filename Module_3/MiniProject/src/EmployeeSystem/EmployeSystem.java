package EmployeeSystem;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class EmployeSystem {
    public static void main(String[]args){
        List<Employee> employees = Arrays.asList(
                new Employee(101, "Zaid", "Engineer", 750000),
                new Employee(102, "Rhaul", "HR", 55500),
                new Employee(103, "Rohan", "Finance", 455500)
        );

        System.out.println("=== Employee earning > ₹50,000 ===");
        employees.stream()
                .filter(emp -> emp.getSalary() > 50000)
                .forEach(System.out::println);

        System.out.println("\n=== Employee sorted by salary ===");
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .forEach(System.out::println);

        long totalEmployee = employees.stream().count();
        System.out.println("\n=== Total Employee Count ===");
        System.out.println("Count: " + totalEmployee);

        Optional<Employee> higestEarner = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));

        System.out.println("\n=== Higest Earner ===");
        higestEarner.ifPresent(System.out::println);

        double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);

        System.out.println("==== Average Salary ====");
        System.out.println("Average Salary: " + averageSalary);
    }
}
