package LambdaFunction;

import java.util.function.Function;

public class FunctionalInterface {
    public static void main(String[]args){
        @java.lang.FunctionalInterface
                interface Greeting{

            void sayHello();
        }

        Greeting g = () -> System.out.println("Hello Java");
        g.sayHello();
    }
}
