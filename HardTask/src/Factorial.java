import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Factorial extends Functions {
    @Override
    public void distributParamsAndCalculate(LinkedHashMap<String, ArrayList<Double>> map) {
        ArrayList<Double> fuct = new ArrayList<>();
        int i = 1;
        for (Map.Entry<String, ArrayList<Double>> hm : map.entrySet()) {
            if (hm.getKey().equals("F")) {
                fuct.addAll(hm.getValue());
                break;
            }
            i++;
        }
        funcSequence.put(i, calculate(fuct));
    }

    @Override
    public double calculate(ArrayList<Double> list) {
        return calculateFactorial(list.get(0));
    }

    private double calculateFactorial(double i) {
        if (i == 0) return 1.0;
        return i * calculateFactorial(i - 1);
    }
}
