package Model;

import java.util.List;


public class GreedyAlgorithmForFriends extends OptimizationAlgorithm {

    private  List<Student> students;
    private  List<Class> classes;
    private int studentsWithoutClassCounter;

    public GreedyAlgorithmForFriends(List<Student> students, List<Class> classes){
        super(students, classes);
        this.students = students;
        this.classes = classes;
        this.studentsWithoutClassCounter = students.size();

    }

    public GreedyAlgorithmForFriends(DataBase db){
        super(db);

    }

    public  void activate(){
        System.out.println("in process...");
    }









//    public void func(){
//
//        while( (findClassesNotFullMinimum().size() > 0 ) && (studentsWithoutClasses().size() >0)) {
//            for (Class c : classes) {
//
//                for(Student s: studentsWithoutClasses()){
//                    int counter = 0;
//                    List<Student> waitingList = new LinkedList<>();
//
//                    if((c.getStudents().size() + waitingList.size() + s.getBeWith().size() + 1) < c.getMaxStudentsNum()){
//                        if(s.getNotBeWith().size() > 0){
//                            List<Student> notBeWith = s.getNotBeWith();
//                            for(Student student: notBeWith){
//                                if(student.getClassroom() == c.getId() || waitingList.contains(student) ){
//                                    break;
//                                }
//                            }
//                            //add students, his "must be", and his one friend to the waiting list
//                            waitingList.add(s);
//                            if(s.getBeWith().size() > 0){
//                                List<Student> beWith = s.getBeWith();
//                                for(Student b : beWith){
//                                    waitingList.add(b);
//                                }
//                            }
//
//
//                        }
//                    }
//
//                    /*   void recursFunc(s):
//                       if there is a place to enter the "be with" and at list one friend and there is no "not be":
//                            enter s to the queue
//                       if can not enter the minimum from his"gang" (the must be and at list one friend)-
//                            break;
//
//               if there is no "not be with":
//                    until his "gang" exist:
//                        enter him and his friends and be with to a queue:
//                            check if at list one friend can enter also to the class,
//                    * */
//
//
//
//                }
//
//
//            }
//        }
//
//
//    }


}
