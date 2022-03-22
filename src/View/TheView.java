package View;

import java.util.List;

public interface TheView {
    // communicate with the user
    public List<List<String>> getData();

    void returnOutput(List<List<String>> students);
    // ask user what algorithm to use
    public int algorithmPick(List<String> algorithms);

    List<String> GetTypes();


    List<String> GetHeaders();

    //public void returnResult(String result);
}
