package Model;

import java.util.List;

public class TheModel {
    // operate the parser and the DB and activate the algorithms
    private DataBase dataBase;
    private OptimizationAlgorithm optimizationAlgorithem;

    public TheModel(OptimizationAlgorithm opt, List<List<String>> input){
        optimizationAlgorithem = opt;
        // init DB with input
    }

    // method-> activate algorithm-> return result
}
