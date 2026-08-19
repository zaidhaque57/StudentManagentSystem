package Two;
//Encapsulation
class Student{

    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

public class Main {
    public static void main(String[]args){

        Student s = new Student();

        s.setName("Aman");
        s.setAge(20);

        System.out.println(s.getName());
        System.out.println(s.getAge());
    }
}
