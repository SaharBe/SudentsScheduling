import Controller.TheController;
import Model.Class;
import Model.*;
import View.*;
import java.util.*;


public class Main {

    public static void main(String[] args) {
//        if() {
//            TheController controller = new TheController();
//            controller.StartProgram();
//            CSVMediatorTester csvMediatorTester = new CSVMediatorTester();
//            csvMediatorTester.Test();
//            System.out.println("test" );
//            return;
//        }


        Student alis = new Student(8,"alis",false,false,false,Level.LOW, Level.MEDIUM);

        Student bob = new Student(9,"bob",true, false,true,Level.HIGH, Level.MEDIUM);

        Student coco = new Student(10,"coco",true,true,false,Level.HIGH, Level.LOW);

        Student davis = new Student(11, "davis",true, true,false,Level.LOW, Level.LOW);

        Student helena = new Student(12, "helena",false, false,false,Level.MEDIUM, Level.MEDIUM);

        Student emma = new Student(13, "emma",false, false,false,Level.MEDIUM, Level.HIGH);

        Student mia = new Student(14, "mia",false, true,false,Level.LOW, Level.HIGH);

        Student zoe = new Student(15, "zoe",false, false,false,Level.HIGH, Level.LOW);

        Student f = new Student(16, "f",true, true,false,Level.HIGH, Level.HIGH);

        Student g = new Student(17, "g",false, false,false,Level.MEDIUM, Level.MEDIUM);

        Student h = new Student(18, "h",true, false,false,Level.HIGH, Level.MEDIUM);

        Student k = new Student(19, "k",false, false,false,Level.HIGH, Level.MEDIUM);

        Student[] alisArr ={emma,h,bob};
        Student[] bobArr ={coco,alis,emma};
        Student[] cocoArr = {bob, k, h};
        Student[] davisArr = {mia, coco, h};
        Student[] helenaArr = {k, emma, davis};
        Student[] emmaArr = {alis, f, null};
        Student[] miaArr = {alis, f, null};
        Student[] zoeArr = {f,g, null};
        Student[] fArr = {zoe, g,null};
        Student[] gArr = {f,zoe, null};
        Student[] hArr = {helena, alis, bob};
        Student[] kArr = {null, null, null};

        alis.setFriends(alisArr);
        bob.setFriends(bobArr);
        coco.setFriends(cocoArr);
        davis.setFriends(davisArr);
        helena.setFriends(helenaArr);
        emma.setFriends(emmaArr);
        mia.setFriends(miaArr);
        zoe.setFriends(zoeArr);
        f.setFriends(fArr);
        g.setFriends(gArr);
        h.setFriends(hArr);
        k.setFriends(kArr);

        List<Student> notBeWithOne = new LinkedList<>();
        notBeWithOne.add(davis);
        notBeWithOne.add(emma);

        List<Student> notBeWithTwo = new LinkedList<>();
        notBeWithTwo.add(f);

        List<Student> beWithOne = new LinkedList<>();
        beWithOne.add(bob);

        List<Student> beWithTwo = new LinkedList<>();
        beWithOne.add(mia);



        alis.setBeWith(beWithOne);
        alis.setNotBeWith(notBeWithTwo);

        h.setNotBeWith(notBeWithOne);
        h.setBeWith(beWithTwo);





        Class one = new Class(1,4,5, true, false);
        Class two = new Class(2,4,5, true, false);
        Class three =  new Class(3,4,5, false, true);

        List<Student> students = new ArrayList<>();
        students.add(alis);
        students.add(bob);
        students.add(coco);
        students.add(davis);
        students.add(helena);
        students.add(emma);
        students.add(mia);
        students.add(zoe);
        students.add(f);
        students.add(g);
        students.add(h);
        students.add(k);


        List<Class> classes = new ArrayList<>();
        classes.add(one);
        classes.add(two);
        classes.add(three);

        DataBase db = new DataBase();
        db.AddClass(one);




//       GenericOptimizationAlgo opt = new GenericOptimizationAlgo(db ,students, classes);
////
//      opt.activate();
        GreedyAlgorithmForFriends opt = new GreedyAlgorithmForFriends(students, classes);
        opt.activate();

       for(Class c: classes){
           System.out.println(c.getId() + " "+ c.getStudents());
       }






    }
}
