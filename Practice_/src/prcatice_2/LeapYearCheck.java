package prcatice_2;
import java.util.Scanner;
public class LeapYearCheck {
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Ente the year: ");

        int year = sc.nextInt();
        boolean isLeapYear = false;

        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)){
            isLeapYear = true;
        }

        if (isLeapYear) {
            System.out.println(year + " is a Leap Year.");
        }else{
            System.out.println(year + " is not a leap year.");
        }
    }
}
