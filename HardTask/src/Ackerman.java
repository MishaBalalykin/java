import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Ackerman extends Functions {
    @Override
    public void distributParamsAndCalculate(LinkedHashMap<String, ArrayList<Double>> map) {
        ArrayList<Double> ack = new ArrayList<>();
        int i = 1;
        for (Map.Entry<String, ArrayList<Double>> hm : map.entrySet()) {
            if (hm.getKey().equals("ACK")) {
                ack.addAll(hm.getValue());
                break;
            }
            i++;
        }
        funcSequence.put(i,calculate(ack));
    }

    @Override
    public double calculate(ArrayList<Double> list) {
        return calculateAckerman(list.get(0),list.get(1));
    }

    private double calculateAckerman(double n, double m){
        if (n==0)return m+1;
        else if (m== 0)return calculateAckerman(n-1,1);
        else return calculateAckerman(n-1,calculateAckerman(n,m-1));
    }



}
