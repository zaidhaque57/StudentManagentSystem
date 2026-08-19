package studentgrademanagent;

import javax.xml.transform.Source;
import java.util.Scanner;
public class StudentGradeManagement {

//    input stdeunt name and marks
    public static void inputStudent(String[] names, int[] marks, Scanner sc){
        for(int i = 0; i< names.length; i++) {
            System.out.println("\nStudent: " + (i + 1));

            System.out.print("Enter Name: ");
            names[i] = sc.next();

            System.out.print("Enter Marks: ");
            marks[i] = sc.nextInt();
        }
    }

//    Calculate total marks
    public static int calculateTotal(int[] marks){
        int total = 0;

        for(int i = 0; i < marks.length; i++){
            total += marks[i];
        }

        return total;
    }

//    calculate average
    public static double calculateAverage(int[] marks){
        return (double) calculateTotal(marks)/ marks.length;
    }

//    Find Highest marks
    public static int findHighest(int[] marks){

        int highest = marks[0];

        for(int mark : marks){
            if(mark > highest)
                highest = mark;
        }
        return highest;
    }

//    Find Lowest Marks
    public static int findLowest(int[] marks){

        int lowest = marks[0];

        for(int mark : marks){
            if(mark < lowest)
                lowest = mark;
        }
        return lowest;
    }

//    calculate Grade
    public static char calculateGrade(int mark){

        if(mark>=90)
            return 'A';
        else if(mark>=80)
            return 'B';
        else if (mark>=70)
            return 'C';
        else if (mark>=60)
            return 'D';
        else
            return 'F';
    }

//    Display report
    public static void displayReport(String[] names, int[] marks){

        System.out.println("\n========= Report =========");

        for(int i = 0; i<names.length; i++){
            System.out.println(
                    names[i]
                    + " | Marks: "
                    + marks[i]
                    + " | Grade: "
                    + calculateGrade(marks[i])
            );
        }
        System.out.println("---------------------");
        System.out.println("Total Marks : " + calculateTotal(marks));
        System.out.println("Average : " + calculateAverage(marks));
        System.out.println("Highest : " + findHighest(marks));
        System.out.println("Lowest : " + findLowest(marks));
    }

//    search student by name
    public static void searchStudent(String[] name, int[] marks, String searchnanme){
        boolean found = false;

        for(int i =0; i<name.length; i++){
            if(name[i].equalsIgnoreCase(searchnanme)){
                System.out.print("Found! Student name: " + name[i] + "\n"+ "marks: " +  marks[i] + "\n" +  "Grade: " + calculateGrade(marks[i])+"\n");
                found = true;
            }
        }
        if(!found) {
            System.out.println("\nStudent : " + searchnanme + " not Found.");
        }
    }

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        String[] name = null;
        int[] marks = null;
        boolean exit = false;

        System.out.println("Welcome to the student grade management system!");

//        The programe will keep running as long as exit is false
        while (!exit){
            System.out.println("\n======== Main Menu ========== ");
            System.out.println("1. Enter Student Data");
            System.out.println("2. Display Report ");
            System.out.println("3. Search for a Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice(1-4): ");

            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.print("Enter Number of Student: ");
                    int n = sc.nextInt();
                    name = new String[n];
                    marks = new int[n];
                    inputStudent(name, marks, sc);
                    break;
                case 2:
                    if(name == null || name.length == 0){
                        System.out.println("Error: No Student data found. please select option 1 first.");
                    }else{
                        displayReport(name, marks);
                    }
                    break;
                case 3:
                    if(name == null || name.length == 0){
                        System.out.println("Error: No student data found. please select option 1 First.");
                    }else{
                        System.out.print("Enter the name of the student to search: ");
                        String searchTarget = sc.next();
                        searchStudent(name, marks , searchTarget);
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the system. Goodbye.");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. please select a number between 1 and 4 ");
            }
        }
        sc.close();

    }
}
