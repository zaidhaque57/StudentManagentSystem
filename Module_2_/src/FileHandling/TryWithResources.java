package FileHandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TryWithResources {
    public static void main(String[]args) throws IOException{

        try(FileWriter writer = new FileWriter("notes.txt")){
            writer.write("Hello");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
