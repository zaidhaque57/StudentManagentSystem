package Returns;

public class returnKeyword {

    public static double area(double radius){

        return 3.15 * radius * radius;
    }

    public static void main(String[]args){
        double result = area(5);
        System.out.println(result);
    }
}
