package Model;
import java.util.*;

public class Class {

    private final int id;
    private final int minStudentsNum;
    private final int maxStudentsNum;
    private List<Student> students  = new LinkedList<>();
    private final boolean isForEnglishLeadershipStudents;
    private final boolean isForEnglishWeaknessStudents;

    private int aGradesCounter = 0;
    private int bGradesCounter = 0;
    private int cGradesCounter = 0;
    private int aBehaviorCounter = 0;
    private int bBehaviorCounter = 0;
    private int cBehaviorCounter = 0;
    private int boysCounter = 0;
    private int girlsCounter = 0;

    public Class(int id, int minStudentsNum, int maxStudentsNum, boolean isForEnglishLeadershipStudents, boolean isForEnglishWeaknessStudents){
        this.id = id;
        this.maxStudentsNum = maxStudentsNum;
        this.minStudentsNum = minStudentsNum;
        this.isForEnglishLeadershipStudents = isForEnglishLeadershipStudents;
        this.isForEnglishWeaknessStudents = isForEnglishWeaknessStudents;
    }

    public void aGradesCounterPlusOne(){
        aGradesCounter++;
    }

    public void bGradesCounterPlusOne(){
        bGradesCounter++;
    }

    public void cGradesCounterPlusOne(){
        cGradesCounter++;
    }

    public void aBehaviorCounterPlusOne(){
        aBehaviorCounter++;
    }

    public void bBehaviorCounterPlusOne(){
        bBehaviorCounter++;
    }

    public void cBehaviorCounterPlusOne(){
        cBehaviorCounter++;
    }

    public void BoysCounterPlusOne(){
        boysCounter++;
    }

    public void girlsCounterPlusOne(){
        girlsCounter++;
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



    public boolean isForEnglishWeaknessStudents() {

        return isForEnglishWeaknessStudents;
    }

    public int getaGradesCounter() {
        return aGradesCounter;
    }

    public int getbGradesCounter() {
        return bGradesCounter;
    }

    public int getcGradesCounter() {
        return cGradesCounter;
    }

    public int getaBehaviorCounter() {
        return aBehaviorCounter;
    }

    public int getbBehaviorCounter() {
        return bBehaviorCounter;
    }

    public int getcBehaviorCounter() {
        return cBehaviorCounter;
    }

    public int getBoysCounter() {
        return boysCounter;
    }

    public int getGirlsCounter() {
        return girlsCounter;
    }
}
