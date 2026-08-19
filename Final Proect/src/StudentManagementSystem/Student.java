package StudentManagementSystem;

public class Student {

    private int id;
    private String name;
    private String course;
    private int age;
    private double marks;

    public Student(
            int id,
            String name,
            int age,
            String course,
            double marks){

        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {

        return id + " | " +
                name + " | " +
                course + " | " +
                age + " | " +
                marks;
    }
}
