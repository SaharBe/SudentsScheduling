package Model;

public class Class {

    private int id;
    private Student[] students;

    Class(int id, Student[] students){
        this.id = id;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }
}
