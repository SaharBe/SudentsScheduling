import Model.Class;
import Model.*;
import View.*;
import java.util.*;


public class Main {

    public static void main(String[] args) {
       // TheController controller = new TheController();
        //controller.StartProgram();
       // CSVMediatorTester csvMediatorTester = new CSVMediatorTester();
       // csvMediatorTester.Test();
    //    System.out.println("test" );


        Student alis = new Student(1,"alis","f",false,false,Level.LOW, Level.MEDIUM,null,null,null);

        Student bob = new Student(2,"bob","m", false,true,Level.HIGH, Level.MEDIUM, null,null,null );

        Student coco = new Student(3,"coco","m",true,false,Level.HIGH, Level.LOW, null, null,null);

        Student davis = new Student(4, "davis","m", true,false,Level.LOW, Level.LOW, null, null, null);

        Student helena = new Student(5, "helena","f", false,false,Level.MEDIUM, Level.MEDIUM, null, null, null);

        Student emma = new Student(6, "emma","f", false,false,Level.MEDIUM, Level.HIGH, null, null, null);

        Student mia = new Student(7, "mia","f", true,false,Level.LOW, Level.HIGH, null, null, null);

        Student zoe = new Student(8, "zoe","f", false,false,Level.HIGH, Level.LOW, null, null, null);

        Student f = new Student(9, "f","m", true,false,Level.HIGH, Level.HIGH, null, null, null);

        Student g = new Student(10, "g","m", false,false,Level.MEDIUM, Level.MEDIUM, null, null, null);

        Student h = new Student(11, "h","m", false,false,Level.HIGH, Level.MEDIUM, null, null, null);

        Student k = new Student(12, "k","f", false,false,Level.HIGH, Level.MEDIUM, null, null, null);

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


        Class one = new Class(1,3,5, true, false);
        Class two = new Class(2,3,5, true, false);
        Class three =  new Class(3,3,5, false, true);

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

        OptimizationAlgo opt = new OptimizationAlgo(students, classes);

        System.out.println(opt.getNumOfGrades());
        System.out.println(opt.getNumOfBehaviors());

        System.out.println("gg"+classes.size());
        HashMap<String, Integer> la = opt.averageClassData();
        System.out.println(la);

        opt.firstEntry();
        opt.secondEntry();
        System.out.println(f.getFriends()[2]);






    }
}
