package Controller;

import Model.TheModel;
import View.TheView;
import View.TheViewCmd;

public class TheController {
    TheModel model;
    // turn into Singleton
    TheView view;

    public void StartProgram(){
        view = new TheViewCmd();
        // view-> receive input from user
        // pass input to parser
        // insert parsed input into database in model
        // model = new TheModel(algorithm name, list from view);
        // model-> activate optimization algorithm
        // reparse input from algorithm
        // return result to user
    }
}
