package Controller;

import Model.BasicParser;
import Model.Parser;
import Model.Student;
import Model.TheModel;
import View.TheView;
import View.TheViewCmd;

import java.util.List;

public class TheController {
    TheModel model;
    // turn into Singleton
    TheView view;

    public void StartProgram(){
        view = new TheViewCmd();
        // view-> receive input from user
        List<List<String>> data = view.getData();

        model = new TheModel(data, view.GetHeaders());

        // model-> activate optimization algorithm
        // reparse input from algorithm
        // return result to user
    }
}
