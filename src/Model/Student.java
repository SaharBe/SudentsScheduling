package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Student {

    private final int id;
    private final String name;
    private String gender;
    private Map<String, String> attributes;
    //list of relevant keys

    ///remove:
    private  boolean englishLeadership;
    private  boolean englishWeakness ;
    private  Level behavior;
    private  Level grades;
    private Student[] friends;
    private final List<Student> beWith = new ArrayList<>();
    private final List<Student> notBeWith = new ArrayList<>();
    //.
    private int classroom;
    // ?
    private int numOfFriendsWith = 0;





    public Student(int id,String name, String gender){
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public Student(int id,String name, String gender, boolean englishLeadership,boolean englishWeakness,Level behavior
    ,Level grades){
        this.id = id;
        this.name = name;
        this.gender = gender;

       //remove:
        this.englishLeadership = englishLeadership;
        this.englishWeakness = englishWeakness;
        this.behavior = behavior;
        this.grades = grades;
//        this.friends = friends;
//        this.beWith = beWith;
//        this.notBeWith = notBeWith;
  }


    public int getId(){
        return id;
    }

    public String getGender() {
        return gender;
    }

    public void setAttribute(String key, String value){
        attributes.put(key, value);

    }

    public String getAttribute(String key){
        return attributes.get(key);
    }


    public boolean isAttributeExist(String attribute){
        return true;
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

    public Level getAttribute() {
        return behavior;
    }

    public Level getGrades() {
        return grades;
    }

    public Student[] getFriends(){
        return friends;
    }

    public List<Student> getBeWith() {
        return beWith;
    }

    public List<Student> getNotBeWith() {
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
