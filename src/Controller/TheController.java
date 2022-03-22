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
        String stdPath = ".\\exampleStudents.csv";
        String clsPath = ".\\exampleClasses.csv";

        view = new TheViewCmd();
        List<List<String>> data = view.getData(stdPath);
        List<String> dataHeaders = view.GetHeaders();
        List<List<String>> classesDate = view.getData(clsPath);
        List<String> classesHeaders = view.GetHeaders();

        model = new TheModel(data,classesDate, dataHeaders, classesHeaders);

        List<String> algos = model.algorithemsOptions();
        int pick = view.algorithmPick(algos);
        model.selectAlgorithm(pick);

        data = model.Activate();

        view.returnOutput(data);
    }
}
