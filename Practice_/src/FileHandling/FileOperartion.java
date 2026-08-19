package FileHandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileOperartion {
    public static void main(String[] args) {

        createFile("student.txt");

        writeStudentData("student.txt", "Zaid", 20, "CSE");

        System.out.println("--- Reading student.txt ---");
        readFile("student.txt");

        writeNote("notes.txt", "These are important Lecture notes");
        copyFile("notes.txt", "backup.txt");

        System.out.println("---- Reading backup.txt ----");
        readFile("backup.txt");
    }

    public static void createFile(String fileName) {
        try {
            File file = new File(fileName);
            // FIX 1: Capital 'F' in createNewFile()
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An Error Occurred while creating the file.");
        }
    }

    public static void writeStudentData(String fileName, String name, int age, String course) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Course: " + course + "\n");
            System.out.println("Student data written successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while writing data");
        }
    }

    public static void readFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }
            sc.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void writeNote(String fileName, String content) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content + "\n");
        } catch (IOException e) {
            System.out.println("Error writing note");
        }
    }

    public static void copyFile(String SourceFileName, String destionationFileName) {
        try {
            File file = new File(SourceFileName);
            // FIX 2: Pass 'file' into Scanner instead of 'SourceFile'
            Scanner reader = new Scanner(file);
            FileWriter writer = new FileWriter(destionationFileName);

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                writer.write(line + "\n");
            }
            reader.close();
            writer.close();
            System.out.println("File copied from " + SourceFileName + " to " + destionationFileName);
        } catch (IOException e) {
            System.out.println("Error during copying file: " + e.getMessage());
        }
    }
}