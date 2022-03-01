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

    //leaf parser will receive the person from the basic parser and will add the specific attributes.
    protected Person createPerson(List<String> values){
        boolean gender = true;
        if (isGender)
            gender = Boolean.parseBoolean(values.get(2));
        Person person =  prototype.create(Integer.parseInt(values.get(0)), values.get(1), gender);
        int i = isGender ? 3 : 2, n = attributes.size();
        for (; i < n; i++){
            person.setAttribute(attributes.get(i), values.get(i));
        }
        return person;
    }

    @Override
    public DataBase dataToDB(List<List<String>> data) {
        DataBase db = new DataBase();
        for (List<String> datum : data) {
            Person person = createPerson(datum);     //add to DB
            db.add(person);
        }
        return null;
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
