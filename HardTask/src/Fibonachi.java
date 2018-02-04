import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Fibonachi extends Functions {

    @Override
    public void distributParamsAndCalculate(LinkedHashMap<String, ArrayList<Double>> map) {
        ArrayList<Double> fib = new ArrayList<>();
        int i = 1;
        for (Map.Entry<String, ArrayList<Double>> hm : map.entrySet()){
            if (hm.getKey().equals("FIB")){
                fib.addAll(hm.getValue());
                break;
            }
            i++;
        }
        funcSequence.put(i, calculate(fib));


    }

    @Override
    public double calculate(ArrayList<Double> list) {
        return calculateFibonachi(list.get(0));
    }

    private double calculateFibonachi(double i){
        if (i == 1) return 1.0;
        if (i == 2) return 1.0;
        return calculateFibonachi(i - 1) + calculateFibonachi(i - 2);
    }


}
