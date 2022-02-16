package Model;

public class Student {

    private final int id;
    private final String name;
    private String gender;
    private final boolean englishLeadership;
    private final boolean englishWeakness;
    private final Level behavior;
    private final Level grades;
    private Student[] friends; // about the lists => is it right to give them to the constructor?
    private final Student[] beWith;
    private final Student[] notBeWith;
    private int classroom;
    private int numOfFriendsWith = 0;


    public Student(int id,String name, String gender, boolean englishLeadership,boolean englishWeakness,Level behavior
    ,Level grades, Student[] friends, Student[] beWith,Student[] notBeWith){
        this.id = id;
        this.name = name;
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

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setFriends( Student[] friends){
        this.friends = friends;

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

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return "id:"+ id + " name:" + name ;
    }


}
