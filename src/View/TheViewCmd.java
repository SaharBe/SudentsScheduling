package View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TheViewCmd implements TheView {
    DataMediator dm;
    Scanner sc= new Scanner(System.in);
    // communicate with the user through the cmd
    public List<List<String>> getData(){
        dm = new CsvMediator();
        List<List<String>> data = new ArrayList<>();
        System.out.println("---Welcome to the student scheduler---\n");
        System.out.println("please enter the path to the students file:");
        System.out.println("Enter csv file address");
        String str= sc.nextLine();
        try{
            data = dm.ReceiveInput(str);
        } catch (IOException e){
            System.out.println("IOException: " + e.getMessage());
        }
        if (data.isEmpty())
                System.out.println("Error- empty input.");
        return data;
    }

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
}
