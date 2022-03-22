package Model;

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
    }

    // method-> activate algorithm-> return result
}
