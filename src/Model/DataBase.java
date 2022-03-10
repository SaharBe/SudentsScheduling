package Model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

public class DataBase {
    // store all peoples by ID
    List<String> attributes;
    private Hashtable<Integer, Student> studentsById = new Hashtable();
    private Hashtable<String, Integer> typesCount = new Hashtable<>();
    private Hashtable<String, List<Integer>> typesList = new Hashtable<>();
    private Hashtable<String, Integer> offsets = new Hashtable<>();



    public void addStudent(Student student){
        studentsById.put(student.getID(), student);
        String key = student.generateKey();
        if (typesCount.get(key) == null){
            typesCount.put(key, 0);
            typesList.put(key, new ArrayList<>());
            offsets.put(key, 0);
        }
        typesCount.put(key, typesCount.get(key) + 1);
        typesList.get(key).add(student.getID());
    }
    // get student by id
    public Student getStudent(int id){ return studentsById.get(id); }
    // get the amount of each type of student.
    public int amountsOfTypes(String type){return typesCount.get(type);}
    //get list of the types
    public Set<String> getTypes(){ return typesCount.keySet();}
    /**
     * iterate through students according to their type
     * @param type the type of the student (null is valid and represent iterating through all students)
     * @return  the next student of this type
     */
    //the suggested way is to use 'offsets' as indicators of the next student of each type
    public Student next(String type){ return null;}
    public boolean hasNext(String type) {return true;}
}
