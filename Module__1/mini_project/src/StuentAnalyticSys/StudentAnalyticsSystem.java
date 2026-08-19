package StuentAnalyticSys;

import java.util.Scanner;
import java.util.Arrays;

public class StudentAnalyticsSystem {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        System.out.println("==== SETUP ===");
        System.out.println("Enter the total number of students: ");
        int n = sc.nextInt();

        int [] marks = new int[n];
        System.out.println("Enter the marks for" + n + " Students: ");
        for(int i = 0; i < n ; i++){
            System.out.println("Student " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }

        int choice;
        do {
            System.out.println("\n====Student Analytics====");
            System.out.println("1. Display Marks");
            System.out.println("2. Search Marks");
            System.out.println("3. Sort Marks");
            System.out.println("4. Average & Pass/Fail Stats");
            System.out.println("5. Topper");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice){
                case 1:
                    displayMarks(marks);
                    break;
                case 2:
                    System.out.println("Enter the exact marks to seacrh for: ");
                    int target = sc.nextInt();
                    searchMarks(marks, target);
                    break;
                case 3:
                    Arrays.sort(marks);
                    System.out.println("Success: Marks have been sorted from lowest to highest.");
                    displayMarks(marks);
                    break;
                case 4:
                    displayAverageAndPassFail(marks);
                    break;
                case 5:
                    findTopper(marks);
                    break;
                case 6:
                    System.out.println("Exiting Analytics System. Goodbye.");
                    break;
                default:
                    System.out.println("Invalid choice. please select a number between 1 and 6.");
            }
        }while(choice !=6);

        sc.close();
    }

    private static void displayMarks(int[] marks) {
        System.out.print("Current Marks: ");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println(); // Move to the next line
    }

    private static void searchMarks(int[] marks, int target) {
        boolean found = false;
        for(int i = 0; i< marks.length; i++) {
            if (marks[i] == target){
                System.out.println("Found A Student Scored " + target + " (Internal index: " + i + " )");
                found = true;
            }
        }
        if (!found){
            System.out.println("No Student found with a marks of " + target + " . ");
        }
    }

    private static void displayAverageAndPassFail(int[] marks) {
        int sum = 0;
        int passCount = 0;
        int failCount = 0;
        int passingMarks = 40;

        for (int mark : marks){
            sum += mark;

            if (mark >= passingMarks){
                passCount++;
            }else {
                failCount++;
            }
        }

        double average = (double) sum / marks.length;

        System.out.println("---- Class Statistics ----");
        System.out.printf("Class Average: %.2f\n", average);
        System.out.println("Passed: " + passCount + " Student(s)");
        System.out.println("Failed: " + failCount + " Studennt(s)");
    }

    private static void findTopper(int[] marks){
        int highest = marks[0];
        for(int i = 1; i <  marks.length; i++){
            if(marks[i] > highest){
                highest = marks[i];
            }
        }
        System.out.println("The Topper Scored: " + highest);
    }
}

