package Model;

import java.util.LinkedList;
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
        mainIterate();
        enterLeftStudents();
    }

    public int getFriendsNum(Student s){
        int friendsCounter = 0;
        for(Student friend: s.getFriends()){
            if(friend != null){
                friendsCounter++;

            }
        }
        return friendsCounter;
    }

    public boolean isThereEnemiesInList(Student s, List<Student> list){
        List<Student> enemies = s.getNotBeWith();
        if(enemies.size() == 0){
            return false;
        }
        for(Student enemy: enemies){
            for(Student student: list){
                    if(enemy.getID() == student.getID()){
                        return true;
                    }
            }
        }
        return false;

    }

    public void addStudentToClass(Class c, Student s){
        updateClassStudentsData( c,  s);
        reduceStudentsWithoutClassCounter();
    }

    public Class getClassFromID(int id){
        for(Class c: classes){
            if(c.getId() == id){
                return c;
            }
        }
        return null;
    }



    public void mainIterate(){
        List<Student> studentsWithoutClasses = studentsWithoutClasses();
        List<Class> classNoFullMinimum  = findClassesNotFullMinimum();

        for(Class c: classNoFullMinimum){
//            List<Student> waitingList = new LinkedList<>();
            for(Student s: studentsWithoutClasses){
                if(s.getClassroom() == 0){
                    int studentSum;
                    if(s.getNotBeWith().size() > 0){
                        if(isThereEnemiesInList(s, c.getStudents()) ){
                            break;
                        }

                    }
                    if(s.getBeWith().size() > 0){
                        for(Student mustBeWith: s.getBeWith()){
                            if(mustBeWith.getClassroom() != 0){
                                Class mustBeClass = getClassFromID(mustBeWith.getClassroom());
                                updateClassStudentsData(mustBeClass, s);
                                reduceStudentsWithoutClassCounter();
                                break;
                            }
                            if(isThereEnemiesInList( mustBeWith, c.getStudents())){
                                break;
                            }
                        }

                    }


                    if(getFriendsNum(s) > 0){
                        studentSum = s.getBeWith().size() + 2;
                    }else{
                        studentSum = s.getBeWith().size() +1;
                    }
                    if((studentSum + c.getStudents().size()) < c.getMinStudentsNum()){
                        for(int i=0; i< getFriendsNum(s); i++){
                            Student friend = s.getFriends()[i];
                            if(!(isThereEnemiesInList( friend, c.getStudents()) ) &&
                                    friend.getClassroom() == 0){
                                //add to waiting list all the gang
                                addStudentToClass(c, s);
                                addStudentToClass(c, friend);
                                for(Student beWith: s.getBeWith()){
                                    addStudentToClass(c, beWith);
                                }
                                break;


                            }
                        }

                    }

                }

            }
        }

    }

}
