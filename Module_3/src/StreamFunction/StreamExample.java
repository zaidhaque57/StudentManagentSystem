package StreamFunction;

import java.util.ArrayList;

public class StreamExample {
    public static void main(String []args){
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        numbers.stream()
                .filter(n -> n > 20)
                .forEach(System.out::println);
    }
}
