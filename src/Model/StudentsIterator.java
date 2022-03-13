package Model;

import java.util.Hashtable;
import java.util.Iterator;

public class StudentsIterator implements Iterator<Student> {
    private Hashtable<Integer, Student> studentsById;
    Iterator<Integer> helperIterator;

    public StudentsIterator(Hashtable<Integer, Student> studentsByIdDict){
        studentsById = studentsByIdDict;
        helperIterator = studentsById.keySet().iterator();
    }

    @Override
    public boolean hasNext() {
        if (helperIterator.hasNext())
            return true;
        return false;
    }

    @Override
    public Student next() {
        return studentsById.get(helperIterator.next());
    }
}
