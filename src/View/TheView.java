package View;

import java.util.List;

public interface TheView {
    // communicate with the user
    public List<List<String>> getData();
    // ask user what algorithm to use
    public int algorithmPick(List<String> algorithms);
}
