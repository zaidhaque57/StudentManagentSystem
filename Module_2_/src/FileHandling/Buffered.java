package FileHandling;

import java.io.*;

//     BufferedReader

public class Buffered {
    public static void main(String[] args) throws IOException {

//        BufferedReader reader = new BufferedReader(new FileReader("notes.txt"));
//
//        String line;
//
//        while((line = reader.readLine()) != null){
//            System.out.println(line);
//        }
//
//        reader.close();


//        BufferWriter

        BufferedWriter writer = new BufferedWriter(new FileWriter("notes.txt"));

        writer.write("Hello java");
        writer.newLine();

        writer.write("Bufferred Writer");

        writer.close();

    }

}
