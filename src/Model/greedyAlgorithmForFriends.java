package Model;


//while not full (get the minimum) && all the students has no class:
//for each class
        /* for each student s that not has class yet:
            //init queue and counter
                   void recursFunc(s):
                       if there is a place to enter the "be with" and at list one friend and there is no "not be":
                            enter s to the queue
                       if can not enter the minimum from his"gang" (the must be and at list one friend)-
                            break;

               if there is no "not be with":
                    until his "gang" exist:
                        enter him and his friends and be with to a queue:
                            check if at list one friend can enter also to the class,
        * */

    /*if there are classes that not get the minimum:
    if it is not will over the maximum,
    , enter students just with one friend & must be with.
    * */

//if still there are students without class,
    /*  check if he has "must be with"
            if true:
                if he already had a class & it is not full:
                    add our student
                if he had no
    * */
// loop over all the classes that not got the minimum,
    /*
    //  and check if there is any friend/must be
    * */

import java.util.ArrayList;
import java.util.List;


public class greedyAlgorithmForFriends implements OptimizationAlgorithm {

    private final List<Student> students;
    private final List<Class> classes;
    private int studentsWithoutClassCounter;

    public greedyAlgorithmForFriends(List<Student> students, List<Class> classes){
        this.students = students;
        this.classes = classes;
        this.studentsWithoutClassCounter = students.size();

    }

    public List<Student> studentsWithoutClasses(){

        List<Student> studentsList = new ArrayList<>();


        for(Student s: students){

            if(s.getClassroom() == 0){
                studentsList.add(s);
            }
        }

        return studentsList;

    }




    public void func(){

        while(/*not full (get the minimum) && all the students has no class:*/){

        }

        for (Class c:classes) {


        }

    }


}
