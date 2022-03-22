package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class BasicParser implements Parser {
    List<String> attributes;

    public BasicParser(List<String> attrs){
        attributes = attrs;
    }

    private Level stringToLevel(String s){
        if (s.toLowerCase().equals("a"))
            return Level.HIGH;
        if (s.toLowerCase().equals("b"))
            return Level.MEDIUM;
        return Level.LOW;
    }

    //leaf parser will receive the person from the basic parser and will add the specific attributes.
    protected Student createStudent(List<String> values){
        Student student = new Student(Integer.parseInt(values.get(0)), values.get(1), Boolean.parseBoolean(values.get(2)),
                Boolean.parseBoolean(values.get(3)), Boolean.parseBoolean(values.get(4)), stringToLevel(values.get(5)),
                stringToLevel(values.get(6)), values);

        return student;
    }

    protected void createStudentsFriendsList(Student s,List<Student> students){
        Student friendOne = null;
        Student friendTwo = null;
        Student friendThree = null;
        for(Student student: students){
            if(student.getID() == Integer.parseInt(s.getOriginalStudentData().get(7))){
                friendOne = student;
            }
            else if(student.getID() == Integer.parseInt(s.getOriginalStudentData().get(8))){
                friendTwo = student;
            }else if(student.getID() == Integer.parseInt(s.getOriginalStudentData().get(9))){
                friendThree = student;
            }
        }
        Student[] friendsArr = {friendOne,friendTwo,friendThree};
        s.setFriends(friendsArr);

    }

    protected void createStudentMustBeWithList(Student s,List<Student> students){
        Student beWith = null;
        if(Integer.parseInt(s.getOriginalStudentData().get(10)) == 0){
            beWith = null;
        }
        else{
            for(Student student: students){

                if(student.getID() == Integer.parseInt(s.getOriginalStudentData().get(10))){
                    beWith = student;
                    break;
                }

            }
        }
        List<Student> mustBeWith = new LinkedList<>();
        mustBeWith.add(beWith);
        s.setBeWith(mustBeWith);
    }

    protected void createStudentMustNotBeWithList(Student s,List<Student> students){
        Student notBeWith = null;
        if(Integer.parseInt(s.getOriginalStudentData().get(11)) == 0){
            notBeWith = null;
        }
        else{
            for(Student student: students){

                if(student.getID() == Integer.parseInt(s.getOriginalStudentData().get(11))){
                    notBeWith = student;
                    break;
                }

            }
        }
        List<Student> mustNotBeWith = new LinkedList<>();
        mustNotBeWith.add(notBeWith);
        s.setNotBeWith(mustNotBeWith);
    }

    protected Class createClass(List<String> values){
        Class c = new Class(Integer.parseInt(values.get(0)), Integer.parseInt(values.get(1)),
                Integer.parseInt(values.get(2)), Boolean.parseBoolean(values.get(3)),
                Boolean.parseBoolean(values.get(4)));

        return c;
    }

    @Override
    public DataBase dataToDB(List<List<String>> data, List<List<String>> classData){
        DataBase db = new DataBase();
        for (List<String> datum : data){
            db.AddStudent(createStudent(datum));    //add to data base.
        }

        for(List<String> datum : classData){
            db.AddClass(createClass(datum));
        }

        for(Student student: db.getStudents()){
            createStudentsFriendsList(student,db.getStudents());
            createStudentMustBeWithList(student,db.getStudents());
            createStudentMustNotBeWithList(student,db.getStudents());
        }

        return db;
    }



    @Override
    public List<List<String>> DbToData(DataBase db) {
        //convert from the DB to the data
        int k, i = 1, n = db.GetClassCount();
        Class c;
        List<List<String>> output = new ArrayList<>();
        Iterator<Class> iterator = db.iterator();
        while (iterator.hasNext()){
            String s = "Class " + i + ":";
            output.add(new ArrayList<>(){{add(s);}});
            c = iterator.next();
            Iterator<Student> inClassIterator = c.iterator();
            while (inClassIterator.hasNext()){
                Student student = inClassIterator.next();
                ArrayList<String> studentS = new ArrayList<String>();
                //add all parameters/
                studentS.add(String.valueOf(student.getID()));
                studentS.add(student.getName());
                studentS.add(String.valueOf(student.getGender()));
                studentS.add(String.valueOf(student.isEnglishLeadership()));
                studentS.add(String.valueOf(student.isEnglishWeakness()));
                studentS.add(String.valueOf(student.getBehavior()));
                studentS.add(String.valueOf(student.getGrades()));
                studentS.add(String.valueOf(student.getFriends()[0]));
                studentS.add(String.valueOf(student.getFriends()[1]));
                studentS.add(String.valueOf(student.getFriends()[2]));
                studentS.add(String.valueOf(student.getBeWith().get(0)));
                studentS.add(String.valueOf(student.getNotBeWith().get(0)));
                output.add(studentS);
            }
            i++;

        }
        return output;
    }
}
