import java.util.Scanner;

public class Main {

    String studentName;
    int mathMarks, scienceMarks, englishMarks;
    int totalMarks;
    double averageMarks;
    String finalGrade;

    public void inputStudent(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student's Name: ");
        studentName = sc.nextLine();

        System.out.print("Enter maths marks (0-100:) ");
        mathMarks = sc.nextInt();

        System.out.print("Enter science marks (0-100): ");
        scienceMarks = sc.nextInt();

        System.out.print("Enter english marks (0-100): ");
        englishMarks = sc.nextInt();
    }
    public void calulateTotal(){
        totalMarks = mathMarks + scienceMarks + englishMarks;
    }
    public void calculateAverage(){
        averageMarks = totalMarks / 3.0;
    }
    public void calculateGrade(){
        if(averageMarks>=90){
            finalGrade = "A+";
        }else if (averageMarks>=80){
            finalGrade = "A";
        }else if(averageMarks>=70){
            finalGrade = "B";
        }else if(averageMarks>=60){
            finalGrade = "C";
        }else{
            finalGrade = "Fail";
        }
    }

    public void displayResult(){
        System.out.println("\n===============================");
        System.out.println("        STUDENT RESULT           ");
        System.out.println("===============================");
        System.out.println("Name " + studentName);
        System.out.println("Total " + totalMarks+"/" + "300");
        System.out.println("Average " + String.format("%.2f",averageMarks)+ "%");
        System.out.println("Garde " + finalGrade);
        System.out.println("===============================");
    }
    public static void main(String[]args){

        Main student = new Main();

        student.inputStudent();
        student.calulateTotal();
        student.calculateAverage();
        student.calculateGrade();
        student.displayResult();
    }
}
