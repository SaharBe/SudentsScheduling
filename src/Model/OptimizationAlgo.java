package Model;
import java.util.HashMap;
import java.util.List;
import java.util.*;

public class OptimizationAlgo implements OptimizationAlgorithm {

    private List<Student> students;
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

    /*have to return:
    * average a b c behavior
    * average a b c grades
    * average boy amount
    * average girls amount*/
    public void averageClassData() {

        HashMap<String, Integer> allAverage = new HashMap<String, Integer>();
        int numOfClasses = classes.size();

        int aBehavior;
        int bBehavior;
        int cBehavior;
        int aGrades;
        int bGrades;
        int cGrades;
        int boysNum;
        int girlsNum;

        HashMap<String, Integer> grades = getNumOfGrades();
//        Iterator gradesIterator = grades.entrySet().iterator();

        // Iterating through Hashmap
        // Getting a Set of Key-value pairs
        Set entrySet = grades.entrySet();

        // Obtaining an iterator for the entry set
        Iterator it = entrySet.iterator();

        // Iterate through HashMap entries(Key-Value pairs)
        System.out.println("HashMap Key-Value Pairs : ");
        while (it.hasNext()) {
            Map.Entry me = (Map.Entry) it.next();
            System.out.println(" Grade Key is: " + me.getKey() + " & " + " av value for evert class: " + me.getValue());
            int x =(Integer)me.getValue()/numOfClasses;
            System.out.println(x);
        }



    }







}
