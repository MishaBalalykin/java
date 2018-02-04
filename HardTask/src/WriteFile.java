import java.io.*;
import java.util.Map;

public class WriteFile {
    void writeFile(String fileName) throws IOException {
        FileReader fileReader = new FileReader();
        fileReader.readFile(fileName);

        Functions functions;
        functions = new Fibonachi();
        functions.distributParamsAndCalculate(fileReader.getFunc());
        functions = new Factorial();
        functions.distributParamsAndCalculate(fileReader.getFunc());
        functions = new Ackerman();
        functions.distributParamsAndCalculate(fileReader.getFunc());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("resultFile.txt")))) {
            writer.write("");
            writer.flush();
        }

        for (Map.Entry<Integer, Double> hm : functions.getFuncSequence().entrySet()){
            String resultString = hm.getKey()+" "+prepareForWriting(hm.getValue());
            try (PrintWriter writer = new PrintWriter(new FileWriter(new File("resultFile.txt"), true))) {
                writer.println(resultString);
                writer.flush();
            }
        }
    }

    private String prepareForWriting(double x) {
        int y;
        if (x % 1 == 0) {
            y = (int) x;
            return y + "";
        } else return x + "";

    }
}
