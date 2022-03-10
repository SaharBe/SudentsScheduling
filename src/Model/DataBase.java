package Model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class DataBase {
    // store all peoples by ID
    List<String> attributes;
    private Hashtable<Integer, Person> peoplesById = new Hashtable();
    private Hashtable<String, Integer> typesCount = new Hashtable<>();
    private Hashtable<String, List<Integer>> typesList = new Hashtable<>();
    private Hashtable<String, Integer> offsets = new Hashtable<>();



    public void addStudent(Student student){
        peoplesById.put(student.getID(), student);
        String key = student.generateKey();
        if (typesCount.get(key) == null){
            typesCount.put(key, 0);
            typesList.put(key, new ArrayList<>());
            offsets.put(key, 0);
        }
        typesCount.put(key, typesCount.get(key) + 1);
        typesList.get(key).add(student.getID());
    }
    // owning all the Students and do operations on them (iterating for now)
    public Student getStuden(int id){ return null; }
    public int amountsOfTypes(String type){return 1;}
    public String[] getTypes(){ return null;}
    // need to implement iterators
    public Student next(String type){ return null;}
    public boolean hasNext(String type) {return true;}
}
