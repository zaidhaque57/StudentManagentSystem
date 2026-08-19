package StreamFunction;

import java.util.ArrayList;
import java.util.Pedicat;

public class CreatingaStream {
    public static void main(String []args){

        ArrayList<String> names = new ArrayList<>();

        names.add("Rahul");
        names.add("zaid");
        names.add("priya");

//        names.stream()
//                .forEach(System.out::println);

//        System.out.println(names);

//        using filter
        names.stream()
                .filter(names -> {
                    return names == "zaid";
                })
                .forEach(System.out::println);

    }

}
