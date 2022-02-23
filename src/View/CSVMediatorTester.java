package View;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class CSVMediatorTester {
    public void Test(){
        //Scanner sc= new Scanner(System.in);
        CsvMediator exam = new CsvMediator();
        System.out.println("---Testing CSV Mediator---\n");
        System.out.println("Open exampleStudents.csv");
        // for receiving different paths:
        //System.out.println("Enter csv file address");
        //String str= sc.nextLine();
        String str = ".\\exampleStudents.csv";
        List<List<String>> data;
        try{
            System.out.println("Reading file...");
            data = exam.ReceiveInput(str);
            System.out.println("Writing file...");
            exam.ReturnOutput(data);
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
