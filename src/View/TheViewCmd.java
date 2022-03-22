package View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TheViewCmd implements TheView {
    DataMediator dm;
    Scanner sc;
    String path = "";

    public TheViewCmd(){
        dm = new CsvMediator();
        sc= new Scanner(System.in);
    }




    // communicate with the user through the cmd
    @Override
    public List<List<String>> getData(){
        List<List<String>> data = new ArrayList<>();
        System.out.println("---Welcome to the student scheduler---\n");
        System.out.println("Please enter the path to the students csv file:");

        //path = sc.nextLine();
        path = ".\\exampleStudents.csv";
        try{
            data = dm.ReceiveInput(path);
        } catch (IOException e){
            System.out.println("IOException: " + e.getMessage());
        }
        if (data.isEmpty())
                System.out.println("Error- empty input.");
        return data;
    }


    @Override
    public void returnOutput(List<List<String>> students) {
        try {
            String address = dm.ReturnOutput(students);
            System.out.println("The results are in " + address + ".");
            System.out.println("Thanks for using the student scheduler");
            System.out.println("---see you next time---");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public int algorithmPick(List<String> algorithms){
        System.out.println("Please pick algorithm number to use:");
        for (int i = 0; i < algorithms.size(); i++){
            System.out.println((i + 1) + ". " + algorithms.get(i) + ".");
        }
        int input = sc.nextInt();
        while (input < 0 || input > algorithms.size()){
            System.out.println("input isn't valid, please enter valid input.");
            input = sc.nextInt();
        }
        return input;
    }

    @Override
    public List<String> GetTypes() {
        return dm.GetTypes();
    }

    @Override
    public List<String> GetHeaders() {
        return dm.GetHeaders();
    }
}
