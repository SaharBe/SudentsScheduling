import Controller.TheController;
import Model.Class;
import Model.*;
import View.*;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        if(false) {
            TheController controller = new TheController();
            controller.StartProgram();
            CSVMediatorTester csvMediatorTester = new CSVMediatorTester();
            csvMediatorTester.Test();
            System.out.println("test" );
            return;
        }


        Student alis = new Student(8,"alis","f",false,false,Level.LOW, Level.MEDIUM);

        Student bob = new Student(9,"bob","m", false,true,Level.HIGH, Level.MEDIUM);

        Student coco = new Student(10,"coco","m",true,false,Level.HIGH, Level.LOW);

        Student davis = new Student(11, "davis","m", true,false,Level.LOW, Level.LOW);

        Student helena = new Student(12, "helena","f", false,false,Level.MEDIUM, Level.MEDIUM);

        Student emma = new Student(13, "emma","f", false,false,Level.MEDIUM, Level.HIGH);

        Student mia = new Student(14, "mia","f", true,false,Level.LOW, Level.HIGH);

        Student zoe = new Student(15, "zoe","f", false,false,Level.HIGH, Level.LOW);

        Student f = new Student(16, "f","m", true,false,Level.HIGH, Level.HIGH);

        Student g = new Student(17, "g","m", false,false,Level.MEDIUM, Level.MEDIUM);

        Student h = new Student(18, "h","m", false,false,Level.HIGH, Level.MEDIUM);

        Student k = new Student(19, "k","f", false,false,Level.HIGH, Level.MEDIUM);

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


        System.out.println("this is me: "+ alis.getClassroom());


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
        opt.enterFriends();
        opt.secondEntry();
        System.out.println(f.getFriends()[2]);

        List<Class> d = opt.findClassesNotFull();
        List<Class> gg = opt.findFullClasses();

        if(gg.size() == 0){
            System.out.println("do: "+gg);
        }






    }
}
