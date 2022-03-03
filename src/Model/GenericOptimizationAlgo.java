package Model;
import java.util.HashMap;
import java.util.List;
import java.util.*;

public class GenericOptimizationAlgo extends OptimizationAlgorithm {

    private final List<Student> students;
    private final List<Class> classes;
    private int studentsWithoutClassCounter;


    public GenericOptimizationAlgo(List<Student> students, List<Class> classes){
        super(students,  classes);
        this.students = students;
        this.classes = classes;
        this.studentsWithoutClassCounter = students.size();

    }

    public void reduceStudentsWithoutClassCounter(){
        studentsWithoutClassCounter--;
    }

    public int getNumOfStudents(){
        return students.size();
    }

    public int getNumOfBoys(){
        int boysCounter = 0;
        for(Student s: students){
            if (s.getGender()){
                boysCounter++;
            }
        }
        return boysCounter;
    }

    public int getNumOfGirls(){
        return (getNumOfStudents() - getNumOfBoys());
    }



    public HashMap<String,Integer> getNumOfGrades(){
        int HighCounter = 0;
        int MediumCounter = 0;
        int LowCounter = 0;

        for(Student s: students){
            if (s.getGrades() == Level.HIGH){
                HighCounter++;
            }
            if(s.getGrades() == Level.MEDIUM){
                MediumCounter++;
            }
            if(s.getGrades() == Level.LOW){
                LowCounter++;
            }
        }

        HashMap<String,Integer> sums =new HashMap<String, Integer>();
        sums.put("HIGH", HighCounter);
        sums.put("MEDIUM", MediumCounter);
        sums.put("LOW", LowCounter);

        return sums;
    }

///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
    public HashMap<String,Integer> getNumOfBehaviors(){
        int HighCounter = 0;
        int MediumCounter = 0;
        int LowCounter = 0;

        for(Student s: students){
            if (s.getBehavior() == Level.HIGH){
                HighCounter++;
            }
            if(s.getBehavior() == Level.MEDIUM){
                MediumCounter++;
            }
            if(s.getBehavior() == Level.LOW){
                LowCounter++;
            }
        }

        HashMap<String,Integer> sums =new HashMap<String, Integer>();
        sums.put("HIGH", HighCounter);
        sums.put("MEDIUM", MediumCounter);
        sums.put("LOW", LowCounter);

        return sums;
    }
///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////

    public int averageCalc(int studentsNum, int classNum){
        return studentsNum/classNum;
    }

    /*have to return:
    * average a b c behavior
    * average a b c grades
    * average boy amount
    * average girls amount*/
    public  HashMap<String, Integer> averageClassData() {

        HashMap<String, Integer> allAverage = new HashMap<String, Integer>();
        int numOfClasses = classes.size();

        int boysAve = getNumOfBoys()/numOfClasses;
        int girlsAve = getNumOfGirls()/numOfClasses;
        allAverage.put("Boys", boysAve);
        allAverage.put("Girls", girlsAve);

        HashMap<String, Integer> grades = getNumOfGrades();
        Set<Map.Entry<String, Integer>> entrySet = grades.entrySet();
        Iterator it = entrySet.iterator();

        while (it.hasNext()) {
            Map.Entry me = (Map.Entry) it.next();
            int ave = averageCalc((Integer)me.getValue(), numOfClasses);
            allAverage.put("Grade-"+me.getKey(),ave);
        }

        HashMap<String, Integer> behavior = getNumOfBehaviors();
        entrySet = behavior.entrySet();
        it = entrySet.iterator();

        while (it.hasNext()) {
            Map.Entry me = (Map.Entry) it.next();
            int ave = averageCalc((Integer)me.getValue(), numOfClasses);
            allAverage.put("Behavior-"+me.getKey(),ave);
        }
        return allAverage;

    }

    public void updateClassStudentsData(Class c, Student s){

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

    public boolean averageConditions(Student s, Class c,HashMap<String, Integer> data){

        /** check if attribute exist before accessing it */
        return (((Objects.equals(s.getGender(), "m") && c.getBoysCounter() < data.get("Boys")) ||
                (Objects.equals(s.getGender(), "f") && c.getGirlsCounter() < data.get("Girls"))) &&
                ((Objects.equals(s.getBehavior(), Level.HIGH) && c.getaBehaviorCounter() < data.get("Behavior-HIGH")) ||
                        (Objects.equals(s.getBehavior(), Level.MEDIUM) && c.getbBehaviorCounter() < data.get("Behavior-MEDIUM")) ||
                        (Objects.equals(s.getBehavior(), Level.LOW) && c.getcBehaviorCounter() < data.get("Behavior-LOW")))) &&
                ((Objects.equals(s.getGrades(), Level.HIGH) && c.getaGradesCounter() < data.get("Grade-HIGH")) ||
                        (Objects.equals(s.getGrades(), Level.MEDIUM) && c.getbGradesCounter() < data.get("Grade-MEDIUM")) ||
                        (Objects.equals(s.getGrades(), Level.LOW) && c.getcGradesCounter() < data.get("Behavior-LOW")));
    }


    public void firstEntry(){ ///enter english students to relevant classes.

        List<Class> leadershipClasses = new ArrayList<>();
        List<Class> weaknessClasses = new ArrayList<>();

        List<Student> leadershipStudents = new ArrayList<>();
        List<Student> weaknessStudents = new ArrayList<>();

        int numOfLeaderStudents;
        int numOfWeakStudents;



        for(Class c: classes){
            if(c.isForEnglishLeadershipStudents()){
                leadershipClasses.add(c);
            }
            if(c.isForEnglishWeaknessStudents()){
                weaknessClasses.add(c);
            }
        }

        for (Student s: students){
            if(s.isEnglishLeadership()){
                leadershipStudents.add(s);
            }
            if(s.isEnglishWeakness()){
                weaknessStudents.add(s);
            }
        }
        numOfLeaderStudents =leadershipStudents.size();
        numOfWeakStudents = weaknessStudents.size();

        int leadersInClass = numOfLeaderStudents/ leadershipClasses.size();
        int weakInClass = numOfWeakStudents/ weaknessClasses.size();

        int j =0;
        for(Class c: leadershipClasses){
            //enter num of leader students
            for(int i=0; i<leadersInClass;i++){

               // c.addStudent(leadershipStudents.get(j));
                updateClassStudentsData(c,leadershipStudents.get(j));
                reduceStudentsWithoutClassCounter();
                j++;
            }

            System.out.println(c.getStudents());
        }

        j=0;
        for(Class c: weaknessClasses){
            //enter num of leader students
            for(int i=0; i<weakInClass;i++){

               // c.addStudent(weaknessStudents.get(j));
                updateClassStudentsData(c,weaknessStudents.get(j));
                reduceStudentsWithoutClassCounter();
                j++;
            }

            System.out.println(c.getStudents());
        }

    }

    public void enterFriends(){
        /*if class is english class:
        * for each student in class- check if it is possible to enter his first friend --> check if it can iterate on the new students we enter..
        * then loop the seconds friends of everyone and the third... */

        for(Class c: classes){

            if(c.isForEnglishWeaknessStudents() || c.isForEnglishLeadershipStudents()){
                for(int i=0; i<3; i++){

                    Queue<Student> queue = new LinkedList<>();
                    for(Student s: c.getStudents()){
                        queue.add(s);
                    }
                    while(!queue.isEmpty()){
                        Student s = queue.remove();
                        Student newStudent = s.getFriends()[i];

                        if( newStudent != null && newStudent.getClassroom() == 0 &&  c.getStudents().size() <  c.getMaxStudentsNum()){
                            if(averageConditions(newStudent, c, averageClassData())){
                                queue.add(newStudent);
                                updateClassStudentsData(c,s.getFriends()[i]);
                                reduceStudentsWithoutClassCounter();
                            }

                        }


                    }

                }
            }
        }

    }

    /*
     * while  there studentCounter >0  and still not pass the min amount:
     * update the counters of this class
     *  see next children, if he stands on the criteria
     *enter him to this class
     *
     * */
    public void secondEntry(){

        for ( Class c : classes)
        {
            if ((studentsWithoutClassCounter > 0)){

                for(Student s : students){

                    if((s.getClassroom() == 0) && (c.getStudents().size() < c.getMaxStudentsNum())){

                        if(averageConditions(s, c, averageClassData())){

                            updateClassStudentsData(c,s);
                            reduceStudentsWithoutClassCounter();
                        }

                    }

                }
            }

            System.out.println("In the Class: "+c.getStudents());

        }


    }


//    public  List<Class> findClassesNotFullMinimum(){
//        List<Class> notFullClasses = new ArrayList<>();
//
//        for (Class c:classes) {
//            if(c.getStudents().size() <   c.getMinStudentsNum() ){
//                notFullClasses.add(c);
//            }
//
//        }
////        System.out.println(notFullClasses);
//        return notFullClasses;
//
//    }

    public List<Class> findFullClasses(){
        List<Class> FullClasses = new ArrayList<>();

        for (Class c:classes) {
            if(c.getStudents().size() ==   c.getMaxStudentsNum() ){
                FullClasses.add(c);
            }

        }
        System.out.println(FullClasses);
        return FullClasses;

    }

    public void enterLeftStudents(){
        /*if all the classes get the minimum and there are classes that not get the maximum:
                loop over that classes, and for all student without class, check if the can be there
        *   */
        //if all the classes get the minimum:
            //iterate on his friends, if there is a friend in class that doesn't get the maximum - enter him there.
        //
        /*if there are classes that not get the minimum, enter the students there*/

    }

}

