package Array;
import java.util.Scanner;
public class TakingArrayInput {
    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] marks = new int[5];

        for(int i = 0; i< marks.length; i++){
            System.out.print("Enter marks: ");
            marks[i] = sc.nextInt();
        }
        System.out.println("\nMarks");

        for(int i = 0; i < marks.length; i++){
            System.out.println(marks[i]);
        }
        sc.close();
    }

}
