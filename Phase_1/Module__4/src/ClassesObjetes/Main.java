package ClassesObjetes;

class Student {

    String name;
    int age;

    void display() {
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
    }
}

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student();
        s1.name = "Aman";
        s1.age = 20;

        Student s2 = new Student();
        s2.name = "Rahul";
        s2.age = 21;

        s1.display();
        s2.display();
    }
}