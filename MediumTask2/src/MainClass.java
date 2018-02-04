import java.util.LinkedHashMap;
import java.util.Map;

public class MainClass {
    public static void main(String[] args) {
        //2) Программа выполняющая Run-length encoding кодирование строки (aaabccdd -> 3a1b2c2d)

        /*
        * Программа будет записывать закодированные данные именно в той последовательности,
        * в которой они были введены благодаря LinkedHashMap
        * */

        System.out.println(coder("aaaqqqq LLLLbccdd"));
        System.out.println(coder("aaabccdd"));
    }

    private static String coder(String s) {
        String resultString = "";
        int count = 1;
        int lastCount = 0;
        char[] symbols = s.toCharArray();
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < symbols.length - 1; i++) {
            if (i < symbols.length - 2) {
                if (symbols[i] == symbols[i + 1]) {
                    count++;
                } else {
                    map.put(symbols[i], count);
                    count = 1;
                    lastCount = i + 1;
                }
            } else {
                map.put(symbols[i], symbols.length - lastCount);
            }
        }

        for (Map.Entry<Character, Integer> symbol : map.entrySet()) {
            resultString += symbol.getValue().toString() + symbol.getKey().toString();
        }

        return resultString;
    }
}
