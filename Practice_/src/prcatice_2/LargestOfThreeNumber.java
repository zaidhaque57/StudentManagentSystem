package prcatice_2;

public class LargestOfThreeNumber {
    public static void main(String[]args){

        int num1 = 10;
        int num2 = 12;
        int num3 = 9;

        if (num1 >= num2 && num1 >= num3){
            System.out.println("The Num1 Greatest");
        }else if (num2 >= num1 && num2 >= num3){
            System.out.println("The Num2 Greatest");
        }else{
            System.out.println("The Num3 Greatest");
        }
    }
}
