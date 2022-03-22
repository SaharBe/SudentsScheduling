package Model;

import java.util.List;

public interface Parser {
    // parse- parse list into class Student
    DataBase dataToDB(List<List<String>> data, List<List<String>> classData);
    List<List<String>> DbToData(DataBase db);
}
