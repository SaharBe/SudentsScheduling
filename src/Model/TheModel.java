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


    public void selectAlgorithm(int pick){

    }

    public List<List<String>> Activate(){
        //activate the algorithm
        return parser.DbToData(dataBase);
    }
    // method-> activate algorithm-> return result
}
