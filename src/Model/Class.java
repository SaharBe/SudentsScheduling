package Model;
import java.util.*;

public class Class {

    private final int id;
    private final int minStudentsNum;
    private final int maxStudentsNum;
    private List<Student> students  = new LinkedList<>();
    private boolean isForEnglishLeadershipStudents;
    private boolean isForEnglishWeaknessStudents;

    public Class(int id, int minStudentsNum, int maxStudentsNum){
        this.id = id;
        this.maxStudentsNum = maxStudentsNum;
        this.minStudentsNum = minStudentsNum;
    }

    public int getId() {
        return id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getMinStudentsNum() {
        return minStudentsNum;
    }

    public int getMaxStudentsNum() {
        return maxStudentsNum;
    }

    public void addStudent(Student student){
        student.setClassroom(this.id);
        students.add(student);
    }

    public void  deleteStudent(Student student){
        students.remove(student);
    }


    public boolean isForEnglishLeadershipStudents() {
        return isForEnglishLeadershipStudents;
    }

    public void setForEnglishLeadershipStudents(boolean forEnglishLeadershipStudents) {
        isForEnglishLeadershipStudents = forEnglishLeadershipStudents;
    }

    public boolean isForEnglishWeaknessStudents() {

        return isForEnglishWeaknessStudents;
    }

    public void setForEnglishWeaknessStudents(boolean forEnglishWeaknessStudents) {
        isForEnglishWeaknessStudents = forEnglishWeaknessStudents;
    }
}
