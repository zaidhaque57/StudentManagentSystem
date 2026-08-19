package prcatice_2;
import java.util.Scanner;

public class AgeCategory {
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your Age: ");

        int age = sc.nextInt();

        if (age >= 60 ){
            System.out.println(age + " Senior Citizen");
        }else if (age >= 20){
            System.out.println(age + " Adult");
        }else if (age >= 13){
            System.out.println(age + " Teenager");
        }else{
            System.out.println(age + " Child");
        }
    }
}
