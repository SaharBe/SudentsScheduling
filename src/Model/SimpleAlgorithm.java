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
        TypeIterator typeIterator = db.typeIterator();
        classes.clear();
        for (int i = 0; i < numOfClasses; i++)
            classes.set(i, new Class(i, db.amountsOfTypes(null)/numOfClasses -  1,
                    db.amountsOfTypes(null)/numOfClasses +  1, false, false));
        Set<String> types = db.GetTypes();
        int classIndex = 0, n = classes.size();
        for (String type : types) {
            while(typeIterator.hasNext(type)){
                classes.get(classIndex).addStudent(db.GetStudent(typeIterator.next(type)));
                classIndex = (classIndex + 1) % n;
            }
        }
        for (Class c : classes) {
            db.AddClass(c);
        }
    }
    //need to add uristics for another algorithms and for making friends be together at the same class.


    public List<Class> GetClasses(){
        return classes;
    }
}
