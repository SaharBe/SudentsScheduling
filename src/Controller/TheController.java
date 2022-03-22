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
        List<List<String>> data = view.getData();

        model = new TheModel(data, view.GetHeaders());

        List<String> algos = model.algorithemsOptions();
        int pick = view.algorithmPick(algos);
        model.selectAlgorithm(pick);

        data = model.Activate();

        view.returnOutput(data);
    }
}
