package Model;

import java.util.ArrayList;
import java.util.List;

public class OptimizationAlgorithm {

    protected final List<Student> students;
    protected final List<Class> classes;
    protected int studentsWithoutClassCounter;


    public OptimizationAlgorithm(List<Student> students, List<Class> classes){
        this.students = students;
        this.classes = classes;
        this.studentsWithoutClassCounter = students.size();

    }

    public final  List<Class> findClassesNotFullMinimum(){
        List<Class> notFullClasses = new ArrayList<>();

        for (Class c:classes) {
            if(c.getStudents().size() <   c.getMinStudentsNum() ){
                notFullClasses.add(c);
            }

        }
        System.out.println(notFullClasses);
        return notFullClasses;

    }

    public final List<Student> studentsWithoutClasses(){

        List<Student> studentsList = new ArrayList<>();


        for(Student s: students){

            if(s.getClassroom() == 0){
                studentsList.add(s);
            }
        }

        return studentsList;

    }

}
