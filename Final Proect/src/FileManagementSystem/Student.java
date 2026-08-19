package FileManagementSystem;

public class Student {
    private int rollNo;
    private String name;
    private int age;
    private String Course;
    private double marks;
    private char grade;

    public Student(int rollNo, String name, int age , String course , double marks){
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.Course = Course;
        this.marks = marks;
        this.grade = CalculateGrade(marks);
    }

    public Student(int rollNo, String name, int age, String course, double marks, char grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        Course = course;
        this.marks = marks;
        this.grade = grade;
    }

    public static char CalculateGrade(double marks){
        if (marks >= 90) return  'A';
        if (marks >= 80) return 'B';
        if (marks >= 70) return 'C';
        if (marks >= 60) return 'D';
        return 'F';
    }

    public int getRollNo() {return rollNo;}
    public void setRollNo(int rollNo) {this.rollNo = rollNo;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}

    public String getCourse() {return Course;}
    public void setCourse(String course) {Course = course;}

    public double getMarks() {return marks;}
    public void setMarks(double marks) {this.marks = marks;
        this.marks = marks;
        this.grade = grade;
    }
    public char getGrade() {return grade;}

    @Override
    public String toString() {
        return String.format("%-5d %-15s %-10s %-6.1f %c", rollNo, name, age , Course,marks, grade);
    }
}