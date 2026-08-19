package Nested_if;

public class CheckEligible {
    public static void main(String[]args){

        int age = 22;
        boolean hasLicense = true;

        if(age >= 18){
            if(hasLicense){
                System.out.println("You can drive");
            }
        }
    }
}
