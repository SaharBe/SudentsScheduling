package Model;

import java.util.List;

public class TheModel {
    // operate the parser and the DB and activate the algorithms
    private DataBase dataBase;
    private OptimizationAlgorithem optimizationAlgorithem;

    public TheModel(OptimizationAlgorithem opt, List<List<String>> input){
        optimizationAlgorithem = opt;
        // init DB with input
    }

    // method-> activate algorithm-> return result
}
