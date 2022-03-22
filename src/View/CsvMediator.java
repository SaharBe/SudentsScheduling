package View;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CsvMediator implements DataMediator {
    private final String COMMA_DELIMITER = ",";
    private List<String> headers = null;
    private List<String> types = null;


    private void readHeaders(BufferedReader br) throws IOException{
        String line;
        // learn headers
        line = br.readLine();
        headers = Arrays.asList(line.split(COMMA_DELIMITER));
        line = br.readLine();
        types = Arrays.asList(line.split(COMMA_DELIMITER));
    }


    private List<List<String>> extractStudentsFromCSV(BufferedReader br) throws IOException{
        List<List<String>> students = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(COMMA_DELIMITER);
            students.add(Arrays.asList(values));
        }
        return students;
    }

    // receive data at csv format and transform it into list of lists
    @Override
    public List<List<String>> ReceiveInput(String file_address) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file_address))) {
            readHeaders(br);        // learn headers
            return extractStudentsFromCSV(br);
        }
    }


    // receive list of strings and transform it into csv line
    private String convertToCSV(List<String> student_data) {
        if (student_data.size() == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        sb.append(student_data.get(0));
        for (int i = 1; i < student_data.size(); i++)
            sb.append(COMMA_DELIMITER).append(student_data.get(i));
        sb.append('\n');
        return  sb.toString();
    }


    private String findNewAddress(){
        String name = ".\\output(";
        String suffix =").csv";
        int i = 0;
        while((Files.exists(Paths.get(name + i + suffix)))){
            i++;
        }
        return name + i + suffix;
    }

    @Override
    public String ReturnOutput(List<List<String>> classes) throws IOException {
        String address = findNewAddress();
        File file = new File(address);
        try (PrintWriter writer = new PrintWriter(address)){
            writer.write(convertToCSV(headers));
            for (List<String> list:classes) {
                String line = convertToCSV(list);
                writer.write(line);
            }
        }
        return address;
    }

    @Override
    public List<String> GetTypes() { return types; }

    @Override
    public List<String> GetHeaders(){
        return headers;
    }
}
