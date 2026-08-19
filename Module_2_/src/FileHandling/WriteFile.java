package FileHandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public static void main(String[]args) throws IOException{

        try{

            FileWriter writer = new FileWriter("notes.txt");

            writer.write("Welcome to java File Handling");

            writer.close();

            System.out.println("Data Written Successfuly");
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }

//        Appened line

        FileWriter fw = new FileWriter("notes.txt");

        fw.write("\nLearning java is fun");
    }
}
