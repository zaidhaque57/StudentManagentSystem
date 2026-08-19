package FileHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadingAFile {
    public static void main(String[]args){

        try{
            File file = new File("notes.txt");
            Scanner sc = new Scanner(file);

            while(sc.hasNextLine()){
                String line = sc.nextLine();
                System.out.println(line);
            }
            sc.close();
        }catch(Exception e){
            System.out.println("Error : " +e.getMessage());
        }
    }
}

