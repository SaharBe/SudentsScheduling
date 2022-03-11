package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SimpleAlgorithm {
    DataBase db;
    List<Class> classes = new ArrayList<>();
    SimpleAlgorithm(DataBase dataBase){
        db = dataBase;
    }

    public void PutStudentsInClasses(int numOfClasses){
        db.ResetOffsets();
        classes.clear();
        for (int i = 0; i < numOfClasses; i++)
            classes.set(i, new Class(i, db.amountsOfTypes(null)/numOfClasses -  1,
                    db.amountsOfTypes(null)/numOfClasses +  1, false, false));
        Set<String> types = db.GetTypes();
        int classIterator = 0, n = classes.size();
        for (String type : types) {
            while(db.HasNext(type)){
                classes.get(classIterator).addStudent(db.Next(type));
                classIterator = (classIterator + 1) % n;
            }
        }
    }
    //need to add uristics for another algorithms and for making friends be together at the same class.


    public List<Class> GetClasses(){
        return classes;
    }
}
