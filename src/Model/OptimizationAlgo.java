package Model;
import java.util.HashMap;
import java.util.List;
import java.util.*;

public class OptimizationAlgo implements OptimizationAlgorithm {

    private final List<Student> students;
    private List<Class> classes;


    public OptimizationAlgo(List<Student> students, List<Class> classes){
        this.students = students;
        this.classes = classes;
    }

    public int getNumOfStudents(){
        return students.size();
    }

    public int getNumOfBoys(){
        int boysCounter = 0;
        for(Student s: students){
            if (s.getGender().equals("m") || s.getGender().equals("M")){
                boysCounter++;
            }
        }
        return boysCounter;
    }

    public int getNumOfGirls(){
        return (getNumOfStudents() - getNumOfBoys());
    }

    public int[] getNumOfBehavior(){
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
        int sum[] = { HighCounter, MediumCounter,LowCounter };

        return sum;

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

    public void isPassedTheAverage(int average, int num){

    }

    public void firstEntry(){
        HashMap<String, Integer> data =  averageClassData();
        System.out.println("data: "+data);
        int studentsWithoutClassCounter = students.size();

        /*
         * while  there studentCounter >0  and still not pass the min amount:
         * update the counters of this class
         *  see next children, if he stands on the criteria
         *enter him to this class
         *
         * */
        for ( Class c : classes)
        {
            int aGradesCounter = 0;
            int bGradesCounter = 0;
            int cGradesCounter = 0;

            int aBehaviorCounter = 0;
            int bBehaviorCounter = 0;
            int cBehaviorCounter = 0;

            int boysCounter = 0;
            int girlsCounter = 0;

            while (studentsWithoutClassCounter >0 && c.getStudents().size() < c.getMinStudentsNum()){

                for(Student s : students){

                    if(s.getClassroom() == 0){ //if this student has no class yet
                        //System.out.println(s.getBehavior());

//                        if(data.get("Behavior-MEDIUM"))
                        //System.out.println(data.get("Behavior-MEDIUM"));
//                        if(Objects.equals(s.getGender(), "m") ){
//                            data.get("Boys");
//                        }
                        if((((Objects.equals(s.getGender(), "m") && boysCounter < data.get("Boys")) ||
                           (Objects.equals(s.getGender(), "f") && girlsCounter < data.get("Girls"))) &&
                           (( Objects.equals(s.getBehavior(), Level.HIGH) && aBehaviorCounter < data.get("Behavior-HIGH")) ||
                           (Objects.equals(s.getBehavior(), Level.MEDIUM) && bBehaviorCounter < data.get("Behavior-MEDIUM"))||
                           (Objects.equals(s.getBehavior(), Level.LOW) && cBehaviorCounter < data.get("Behavior-LOW"))))&&
                           ((Objects.equals(s.getGrades(), Level.HIGH) && aGradesCounter < data.get("Grade-HIGH")) ||
                           (Objects.equals(s.getGrades(), Level.MEDIUM) && bGradesCounter < data.get("Grade-MEDIUM")) ||
                           (Objects.equals(s.getGrades(), Level.LOW) && cGradesCounter < data.get("Behavior-LOW"))) ){

                            if(Objects.equals(s.getGender(), "m")){
                                boysCounter++;

                            }else{
                                girlsCounter++;
                            }
                            if(Objects.equals(s.getBehavior(), Level.HIGH)){
                                aBehaviorCounter++;

                            }else if(Objects.equals(s.getBehavior(), Level.MEDIUM)){
                                bBehaviorCounter++;
                            }else{
                                cBehaviorCounter++;
                            }
                            if(Objects.equals(s.getGrades(), Level.HIGH)){
                                aGradesCounter++;
                            }else if(Objects.equals(s.getGrades(), Level.MEDIUM)){
                                bGradesCounter++;
                            }else{
                                cGradesCounter++;
                            }

                            c.addStudent(s);
                            studentsWithoutClassCounter--;
                        }



                    }


                }
            }
            System.out.println(c.getStudents());

        }


    }

}








