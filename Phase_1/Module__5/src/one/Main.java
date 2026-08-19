package one;//All type Constructor use in programe.

class Student{

    String name;
    int age;

    Student(){
        name = "unknown";
        age = 0;
    }

    Student(String name){
        this.name = name;
        age = 18;

    }

    Student(String name, int age){

        this.name = name;
        this.age = age;
    }

    void display(){
        System.out.println("Name : " + name);
        System.out.println("age : " + age);
    }
}
public class Main{
    public static void main(String[]args){

        Student s1 = new Student();
        Student s2 = new Student("zaid");
        Student s3 = new Student("Rahul",18);

       s1.display();
       s2.display();
       s3.display();
    }
}
