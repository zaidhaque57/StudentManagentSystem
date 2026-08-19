package LambdaFunction;

import java.lang.FunctionalInterface;

public class FunctionalInterfaceWithParameters {
    public static void main(String[]args){
        @FunctionalInterface
                interface Square{
            int Calculate(int number);
        }
        Square sq = number -> number * number;
        System.out.println(sq.Calculate(5));
    }
}
