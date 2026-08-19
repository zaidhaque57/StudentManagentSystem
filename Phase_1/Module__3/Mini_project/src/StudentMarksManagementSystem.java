import java.util.Scanner;

public class StudentMarksManagementSystem {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

//      Ask how many student there are
        System.out.print("Enter number of student: ");
        int totalStudent = sc.nextInt();

//        store their  marks in an array
        double[] marks = new double[totalStudent];

        System.out.print("\nEnter the marks for " + totalStudent + " Students: \n");
        for(int i = 0; i<totalStudent; i++){
            System.out.print("Student " + (i + 1 ) + ": ");
            marks[i] = sc.nextDouble();
        }

//        display all marks
        System.out.println("\n-------Displaying All Marks---------");
        for(int i=0; i<marks.length; i++){
            System.out.printf("Student %d: %.2f\n", (i+1), marks[i]);
        }

        double total = 0;
        double hightest = marks[0];
        double lowest = marks[0];

        for(int i = 0; i<marks.length; i++){
            total += marks[i];

//            find hightest
            if(marks[i] > hightest){
                hightest =marks[i];
            }

            if(marks[i] < lowest){
                lowest =marks[i];
            }
        }

        double average = total / totalStudent;

//        Displaying Calulate Statistic
        System.out.println("\n=======Marks Statistics========");
        System.out.printf("Total Marks:   %.2f\n", total);
        System.out.println("Average Marks= " + average);
        System.out.println("Hightest Marks= " + hightest);
        System.out.println("Lowest Marks= " + lowest);

//        Search for a particular marks
        System.out.print("\nEnter a specific mark to search for: ");
        double searchTarget = sc.nextDouble();

        boolean found = false;
        System.out.println("Searching result....");

        for(int i = 0; i <marks.length; i++){
            if(marks[i] == searchTarget){
                System.out.println("Found Student " + (i + 1) +" has a mark of " + searchTarget);
                found = true;
            }
        }

        if(!found){
            System.out.println("The Marks " + searchTarget + " was not found in the records.");
        }
        sc.close();
    }

}
