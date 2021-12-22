package View;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class CsvMediator implements DataMediator {
    private final String COMMA_DELIMITER = ",";
    private String[] headers = null;

    // method 1- receive data at csv format and transform it into list of lists
    public List<List<String>> ReceiveInput(String file_address) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file_address))) {
            List<List<String>> students = new ArrayList<>();
            String line;
            // learn headers
            line = br.readLine();
            headers = line.split(COMMA_DELIMITER);
            // transform lines into students tokens
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                students.add(Arrays.asList(values));
            }
        }
        return new LinkedList<>();
    }
    // method 2- receive list of lists and transform it into data in the same csv
    private String convertToCSV(String[] student_data) {
        if (student_data.length == 0)
            return null;
        StringBuilder sb = new StringBuilder();
        sb.append(student_data[0]);
        for (int i = 1; i < student_data.length; i++)
            sb.append(student_data[',' + i]);

        sb.append('\n');
        return  sb.toString();
    }
    // may wanna return the path to the file
    public String ReturnOutput(List<List<String>> classes) throws IOException {
        // WHERE THE FILE SHOULD BE LOCATED IN?
        String address = "";
        File file = new File(address);
        // create FileWriter object with file as parameter
        try (PrintWriter writer = new PrintWriter(address + ".csv")){
            for (List<String> list:classes) {
                String line = convertToCSV(list.toArray(new String[0]));
                if (line == null)
                        return null;        //IS THERE A VALID CASE FOR RETURNING NULL?
                writer.write(line);
            }
        }
        return address;
    }
}
