package Model;

import java.util.ArrayList;
import java.util.List;

public class TheModel {
    // operate the parser and the DB and activate the algorithms
    private DataBase dataBase;
    private OptimizationAlgorithm optimizationAlgorithem;
    List<String> attributes;
    Parser parser;

    public TheModel(List<List<String>> input, List<String> attrs){
        parser = new BasicParser(attrs);
        // init DB with input
        dataBase = parser.dataToDB(input);
        optimizationAlgorithem = new GenericOptimizationAlgo(dataBase);
    }

    public List<String> algorithemsOptions(){
        List<String> algos = new ArrayList<>();
        algos.add("Generic Algorithm- classes more balanced");
        algos.add("Greedy Algorithm- focus on friends");
        return null;
    }
    public void selectAlgorithm(int pick){
        if (pick == 1)
            optimizationAlgorithem = new GenericOptimizationAlgo(dataBase);
        if (pick == 2)
            optimizationAlgorithem = new GreedyAlgorithmForFriends(dataBase);
    }

    public List<List<String>> Activate(){

        //activate the algorithm
        return parser.DbToData(dataBase);
    }
    // method-> activate algorithm-> return result
}
