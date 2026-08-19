package LambdaFunction;

import java.util.function.Predicate;

public class predicateExample {
    public static void main(String []args){

        Predicate<Integer> isEven = n -> n % 2 ==0;

        System.out.println(isEven.test(5));
        System.out.println(isEven.test(7));
        System.out.println(isEven.test(6));
        System.out.println(isEven.test(10));
    }
}
