package FileHandling;

import java.io.File;
import java.io.IOException;

public class DeleteAFile {
    public static void main(String[]args){

       File file = new File("Student.txt");
       if(file.delete()){
           System.out.println("Deleted");
       }else{
           System.out.println("Connot Deleted");
       }
    }
}
