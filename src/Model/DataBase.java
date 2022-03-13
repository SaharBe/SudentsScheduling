package Model;

import java.util.*;

public class DataBase implements Iterable<Class>{
    // store all peoples by ID
    List<String> attributes;
    private Hashtable<Integer, Student> studentsById = new Hashtable();
    private Iterator<Integer> allStudentsIterator;
    private Hashtable<String, Integer> typesCount = new Hashtable<>();
    private Hashtable<String, List<Integer>> typesList = new Hashtable<>();
    private Hashtable<String, Integer> offsets = new Hashtable<>();
    private List<Class> classes = new ArrayList<>();
    private int classOffset = 0;


    public void AddClass(Class classroom){
        classes.add(classroom);
    }

    public void InitializeClasses(){
        classes.clear();
    }

    public int GetClassCount() { return classes.size();}

    public Class GetClass(int num) { return classes.get(num);}

    public void SetClasses(List<Class> classes){
        this.classes = classes;
    }

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


    public StudentsIterator studentsIterator(){
        return new StudentsIterator(studentsById);
    }

    public TypeIterator typeIterator(){
        return new TypeIterator(typesList);
    }

    @Override
    public Iterator<Class> iterator() {
        return classes.iterator();
    }
}
