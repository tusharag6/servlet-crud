package pojo;

public class Student {
    private String name;
    private String sic;
    private String dept;
    private String marks;
    private int id;

    // Constructors
    public Student() {
    }

    public Student(String name, String sic, String dept, String marks) {
        this.name = name;
        this.sic = sic;
        this.dept = dept;
        this.marks = marks;
    }

    // Getters and Setters

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

    public String getSic() {
        return sic;
    }

    public void setSic(String sic) {
        this.sic = sic;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    // toString method (optional, for debugging or logging)
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sic='" + sic + '\'' +
                ", dept='" + dept + '\'' +
                ", marks='" + marks + '\'' +
                '}';
    }
}
