package Model;

import java.util.*;

public class DataBase {
    // store all peoples by ID
    List<String> attributes;
    private Hashtable<Integer, Student> studentsById = new Hashtable();
    Iterator<Integer> allStudentsIterator;
    private Hashtable<String, Integer> typesCount = new Hashtable<>();
    private Hashtable<String, List<Integer>> typesList = new Hashtable<>();
    private Hashtable<String, Integer> offsets = new Hashtable<>();
    //private List<Class> classes = new ArrayList<>();

/**
    public void AddClass(Class classroom){
        classes.add(classroom);
    }

    public void Initialize(){
        classes.clear();
    }

    public void AddStudentToClass()
*/
    public void AddStudent(Student student){
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
    public Student GetStudent(int id){ return studentsById.get(id); }
    // get the amount of each type of student (null means of all students).
    public int amountsOfTypes(String type){
        if (type == null)
            return studentsById.size();
        return typesCount.get(type);
    }
    //get list of the types
    public Set<String> GetTypes(){ return typesCount.keySet();}
    /**
     * iterate through students according to their type
     * @param type the type of the student (null is valid and represent iterating through all students)
     * @return  the next student of this type
     */
    //the suggested way is to use 'offsets' as indicators of the next student of each type
    public Student Next(String type){
        if (!HasNext(type))
            return null;
        if (type == null)
            return GetStudent(allStudentsIterator.next());
        int id, offset = offsets.get(type);
        offsets.put(type, offset + 1);
        id = typesList.get(type).get(offset);
        return studentsById.get(id);
    }
    public boolean HasNext(String type){
        if (type == null)
            return allStudentsIterator.hasNext();
        if (offsets.get(type) < typesCount.get(type))
            return true;
        return false;
    }
    //should reset offsets of all types
    public void ResetOffsets(){
        allStudentsIterator = studentsById.keySet().iterator();
        for (String key : offsets.keySet())
            offsets.put(key, 0);
    }
}
