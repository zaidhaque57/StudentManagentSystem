package FileHandling;

import java.io.File;
import java.io.IOException;

public class CreateFile {
    public static void main(String[]args){

//        try{
//            File file = new File("notes.txt");
//
//            if (file.createNewFile()){
//                System.out.println("File Created Successfully");
//            }else {
//                System.out.println("File Already Exists");
//            }
//        }catch (IOException e){
//            System.out.println("Error: " + e.getMessage());
//        }

        File file = new File("notes.txt");

        System.out.println(file.exists());
        System.out.println(file.getName());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.length());
    }
}
