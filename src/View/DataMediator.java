package View;

import java.io.IOException;
import java.util.List;

public interface DataMediator {
    // method 1- receive data at some format and transform it into list of lists
    List<List<String>> ReceiveInput(String address) throws IOException;
    // method 2- receive list of lists and transform it into data in the same format
    String ReturnOutput(List<List<String>> classes) throws IOException;
}
