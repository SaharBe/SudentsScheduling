package Model;

import java.util.List;

public interface Parser {
    // parse- parse list into class Student
    public DataBase dataToDB(List<List<String>> data);
    public List<List<String>> DbToData(DataBase db);
}
