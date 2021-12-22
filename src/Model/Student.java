package Model;

public class Student {

    private int id;
    private String gender;
    private boolean englishLeadership;
    private boolean englishWeakness;
    private Level behavior;
    private Level grades;
    private Student[] friends;
    private Student[] beWith;
    private Student[] notBeWith;
    private int classroom;
    private int numOfFriendsWith = 0;


    Student(int id, String gender, boolean englishLeadership,boolean englishWeakness,Level behavior
    ,Level grades, Student[] friends, Student[] beWith,Student[] notBeWith){
        this.id = id;
        this.gender = gender;
        this.englishLeadership = englishLeadership;
        this.englishWeakness = englishWeakness;
        this.behavior = behavior;
        this.grades = grades;
        this.friends = friends;
        this.beWith = beWith;
        this.notBeWith = notBeWith;
    }

    public int getId(){
        return id;
    }

    public String getGender() {
        return gender;
    }


    public boolean isEnglishLeadership() {
        return englishLeadership;
    }

    public Level getBehavior() {
        return behavior;
    }

    public Level getGrades() {
        return grades;
    }

    public Student[] getFriends() {
        return friends;
    }

    public Student[] getBeWith() {
        return beWith;
    }

    public Student[] getNotBeWith() {
        return notBeWith;
    }

    public int getClassroom() {
        return classroom;
    }

    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }

    public int getFriendsWith() {
        return numOfFriendsWith;
    }

    public void setFriendsWith(int friendsWith) {
        this.numOfFriendsWith = friendsWith;
    }

    public boolean isEnglishWeakness() {
        return englishWeakness;
    }
}
