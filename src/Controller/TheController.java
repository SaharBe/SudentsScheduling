package Controller;

import Model.BasicParser;
import Model.Parser;
import Model.TheModel;
import View.TheView;
import View.TheViewCmd;

import java.util.List;

public class TheController {
    TheModel model;
    // turn into Singleton
    TheView view;
    Parser parser;

    public void StartProgram(){
        view = new TheViewCmd();
        parser = new BasicParser();
        // view-> receive input from user
        List<List<String>> data = view.getData();
        // pass input to parser

        // insert parsed input into database in model
        // model = new TheModel(algorithm name, list from view);
        // model-> activate optimization algorithm
        // reparse input from algorithm
        // return result to user
    }
}
