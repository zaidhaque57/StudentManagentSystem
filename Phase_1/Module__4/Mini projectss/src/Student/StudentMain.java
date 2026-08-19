package Student;

public class StudentMain {
    public static void main(String[]args){

        Student s1 = new Student();
        s1.name = "Aman";
        s1.rollNo = 12;
        s1.branch = "cse";
        s1.cgpa = 8.2;

        System.out.println("Name : " + s1.name);
        System.out.println("RollNO : " + s1.rollNo);
        System.out.println("Bramch : " + s1.branch);
        System.out.println("CGPA : " + s1.cgpa);
    }

}
