package Model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TheModel {
    // operate the parser and the DB and activate the algorithms
    public DataBase dataBase;
    private OptimizationAlgorithm optimizationAlgorithem;
    List<String> attributes;
    Parser parser;
    Parser classParser;

    public TheModel(List<List<String>> input,List<List<String>> classesInput, List<String> attrs, List<String> clsAttrs){
        parser = new BasicParser(attrs);
        classParser = new BasicParser(clsAttrs);
        // init DB with input
        dataBase = parser.dataToDB(input, classesInput);


//        optimizationAlgorithem = new GenericOptimizationAlgo(dataBase);
//        optimizationAlgorithem = new GreedyAlgorithmForFriends(dataBase);
    }

    public List<String> algorithemsOptions(){
        List<String> algos = new LinkedList<>();

        algos.add("Generic Algorithm- classes more balanced");
        algos.add("Greedy Algorithm- focus on friends");
        return algos;
    }
    public void selectAlgorithm(int pick){
        if (pick == 1){
            GenericOptimizationAlgo genericOpt = new GenericOptimizationAlgo(dataBase);
            genericOpt.activate();
        }
        if (pick == 2){
            GreedyAlgorithmForFriends greedyOpt = new GreedyAlgorithmForFriends(dataBase);
            greedyOpt.activate();
        }


    }

    public List<List<String>> Activate(){

        //activate the algorithm
        return parser.DbToData(dataBase);
    }
    // method-> activate algorithm-> return result
}
