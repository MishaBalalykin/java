import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public abstract class Functions {
    protected static HashMap<Integer,Double> funcSequence = new HashMap<>();

    public HashMap<Integer, Double> getFuncSequence() {
        return funcSequence;
    }

    public abstract void distributParamsAndCalculate(LinkedHashMap<String, ArrayList<Double>> map);
    abstract double calculate(ArrayList<Double> list);
}
