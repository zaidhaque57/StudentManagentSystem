package Two;

class Student{
    private String name;
    private int rollno;
    private String branch;
    private double cgpa;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        if(rollno > 0){
            this.rollno = rollno;
        }else{
            System.out.println("Rollno. must be greater than zero or cannot be negative.");
        }
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public double getCgpa() {
       return cgpa;
    }

    public void setCgpa(double cgpa) {
        if(cgpa > 0 && cgpa <=10){
            this.cgpa = cgpa;
        }else{
            System.out.println("Invalid input please enter number betweeb 1 - 10.");
        }
    }

}

public class Main {
    public static void main(String[]args){

        Student std = new Student();

        std.setName("Zaid Haque");
        std.setRollno(12212);
        std.setBranch("CSE");
        std.setCgpa(8.9);

        System.out.println("+++++++++++++++++++++++++++++++++++");
        System.out.println("      STUDENT DETAIL          ");
        System.out.println("Student Name : " + std.getName());
        System.out.println("Student Rollno : " + std.getRollno());
        System.out.println("Student Branch : " + std.getBranch());
        System.out.println("Student Cgpa : " + std.getCgpa());
    }
}
