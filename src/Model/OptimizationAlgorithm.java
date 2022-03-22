package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class OptimizationAlgorithm {

    protected List<Student> students;
    protected List<Class> classes;
    protected int studentsWithoutClassCounter;
    protected DataBase db;

    public OptimizationAlgorithm(DataBase dataBase){
        db = dataBase;
    }
    public OptimizationAlgorithm(List<Student> students, List<Class> classes){
        this.students = students;
        this.classes = classes;
        this.studentsWithoutClassCounter = students.size();

    }

    protected abstract void activate();

    protected void reduceStudentsWithoutClassCounter(){
        studentsWithoutClassCounter--;
    }

    protected final  List<Class> findClassesNotFullMinimum(){
        List<Class> notFullClasses = new ArrayList<>();

        for (Class c:classes) {
            if(c.getStudents().size() <   c.getMinStudentsNum() ){
                notFullClasses.add(c);
            }

        }
      //  System.out.println(notFullClasses);
        return notFullClasses;

    }

    protected final List<Student> studentsWithoutClasses(){

        List<Student> studentsList = new ArrayList<>();


        for(Student s: students){

            if(s.getClassroom() == 0){
                studentsList.add(s);
            }
        }

        return studentsList;

    }

    protected final List<Class> findClassesNotFullMaximum(){
        List<Class> notFullClasses = new ArrayList<>();

        for (Class c:classes) {
            if(c.getStudents().size() <   c.getMaxStudentsNum() ){
                notFullClasses.add(c);
            }

        }
//        System.out.println(notFullClasses);
        return notFullClasses;

    }

    /*check if there is students not in the minimum,
   or friend in not full class and enter the left student there  */
    protected void enterLeftStudents(){
        List<Class> noMinimumClasses  = findClassesNotFullMinimum();
        List<Class> noMaximumClasses = findClassesNotFullMaximum();
        List<Student> studentsWithoutClasses = studentsWithoutClasses();
        int i = 0;

        if(!(noMinimumClasses.isEmpty())){
            for(Class c: noMaximumClasses){

                while (c.getStudents().size() <c.getMinStudentsNum()){

                    Student s = studentsWithoutClasses.get(i);

                    if(s.getClassroom() == 0){
                        updateClassStudentsData(c,s);
                        reduceStudentsWithoutClassCounter();
                    }
                    i++;
                }
            }
        }
        for(Student s: studentsWithoutClasses){
            if (s.getClassroom() == 0){

                for(Student friend: s.getFriends()){
                    if(friend != null){
                        Class c = classes.get(friend.getClassroom());
                        if( c.getStudents().size() <  c.getMaxStudentsNum()){
                            updateClassStudentsData(c,s);
                            reduceStudentsWithoutClassCounter();
                            break;
                        }
                    }

                }
            }
            if(s.getClassroom() == 0){
                for(Class c: classes){
                    if(c.getStudents().size() < c.getMaxStudentsNum()){
                        updateClassStudentsData(c,s);
                        reduceStudentsWithoutClassCounter();
                        break;
                    }
                }
            }
        }

    }


    protected void updateClassStudentsData(Class c, Student s){

        if(Objects.equals(s.getGender(), "m")){
            // boysCounter++;
            c.BoysCounterPlusOne();

        }else{
            // girlsCounter++;
            c.girlsCounterPlusOne();
        }
        if(Objects.equals(s.getBehavior(), Level.HIGH)){
            //aBehaviorCounter++;
            c.aBehaviorCounterPlusOne();

        }else if(Objects.equals(s.getBehavior(), Level.MEDIUM)){
            //bBehaviorCounter++;
            c. bBehaviorCounterPlusOne();

        }else{
            //cBehaviorCounter++;
            c.cBehaviorCounterPlusOne();
        }
        if(Objects.equals(s.getGrades(), Level.HIGH)){
            //aGradesCounter++;
            c.aGradesCounterPlusOne();
        }else if(Objects.equals(s.getGrades(), Level.MEDIUM)){
            //bGradesCounter++;
            c.bGradesCounterPlusOne();
        }else{
            //cGradesCounter++;
            c.cGradesCounterPlusOne();
        }

        c.addStudent(s);

    }


}
