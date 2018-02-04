import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;

class FileReader {
    private LinkedHashMap<String, ArrayList<Double>> func = new LinkedHashMap<>();

    LinkedHashMap<String, ArrayList<Double>> getFunc() {
        return func;
    }

    private void setFunc(LinkedHashMap<String, ArrayList<Double>> func) {
        this.func = func;
    }

    void readFile(String fileName) throws IOException {
        String fileString;
        try {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
                while (reader.ready()) {
                    fileString = reader.readLine();
                    String[] array = fileString.split(" ");
                    ArrayList<Double> funcParams = new ArrayList<>();

                    for (int i = 1; i < array.length; i++) {
                        funcParams.add(Double.parseDouble(array[i]));
                    }
                    func.put(array[0], funcParams);
                }
            }
        }catch(FileNotFoundException e){
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("resultFile.txt")))) {
                writer.write("Не удалось найти файл");
                writer.flush();
            }
        }
        setFunc(func);
    }
}
