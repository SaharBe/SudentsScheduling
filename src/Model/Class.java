package Model;

public class Class {

    private int id;
    private Student[] students;
    private int minStudentsNum;
    private int maxStudentsNum;
    private boolean isForEnglishLeadershipStudents; //ask if get its from the user
    private boolean isForEnglishWeaknessStudents; //ask if get its from the user

    Class(int id, Student[] students,int minStudentsNum, int maxStudentsNum){
        this.id = id;
        this.students = students;
        this.maxStudentsNum = maxStudentsNum;
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

    public int getMinStudentsNum() {
        return minStudentsNum;
    }

    public void setMinStudentsNum(int minStudentsNum) {
        this.minStudentsNum = minStudentsNum;
    }

    public int getMaxStudentsNum() {
        return maxStudentsNum;
    }

    public void setMaxStudentsNum(int maxStudentsNum) {
        this.maxStudentsNum = maxStudentsNum;
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
