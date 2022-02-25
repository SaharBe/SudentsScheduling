package Model;

import java.util.List;

public class BasicParser implements Parser {

    //leaf parser will receive the student from the basic parser and will add the advanced attributes.
    protected Student createStudent(List<String> values){
        return new Student(Integer.parseInt(values.get(0)), values.get(1), values.get(2));
    }
    @Override
    public DataBase dataToDB(List<List<String>> data) {
        DataBase db = new DataBase();
        for(int i = 0; i < data.size(); i++){
            createStudent(data.get(i));     //add to DB
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
