package Model;

import java.util.List;

public class BasicParser implements Parser {
    Person prototype;
    List<String> attributes;
    boolean isGender = false;

    public BasicParser(Person object, List<String> attrs){
        prototype = object;
        attributes = attrs;
        if (attributes.get(2).toLowerCase().equals("gender"))
            isGender = true;
    }

    private Level stringToLevel(String s){
        if (s.toLowerCase().equals("a"))
            return Level.HIGH;
        if (s.toLowerCase().equals("b"))
            return Level.MEDIUM;
        return Level.LOW;
    }

    //leaf parser will receive the person from the basic parser and will add the specific attributes.
    protected Student createStudent(List<String> values){
        Student student = new Student(Integer.parseInt(values.get(0)), values.get(1), Boolean.parseBoolean(values.get(2)),
                Boolean.parseBoolean(values.get(3)), Boolean.parseBoolean(values.get(4)), stringToLevel(values.get(5)),
                stringToLevel(values.get(6)));
        //check about english weakness

        //add friends (after checking their positions).

        return student;
    }

    @Override
    public DataBase dataToDB(List<List<String>> data) {
        DataBase db = new DataBase();
        for (List<String> datum : data)
            db.AddStudent(createStudent(datum));    //add to data base.

        return db;
    }

    @Override
    public List<List<String>> DbToData(DataBase db) {
        //convert from the DB to the data
        return null;
    }
    /**
    // parse the basic attributes that always should be given
    public void tmp(List<List<String>> students, List<String> keys){
        DataBase db = new DataBase();
        for (int i = 0; i < students.size(); i++){
            db.addStudent(createStudent(keys, students.get(i)));
        }
    }
     */
}
