import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) {
        //Программа выполняющая Run-length encoding декодирование строки (3a1b2c2d->aaabccdd).

        /*
        * Программа разбивает входную строку на массив букв и массив чисел
        * Потом с помощью вложенного for каждую букву выводит то количество раз,которое хранится в массиве чисел
        * */

        System.out.println(decoder("12a1b23c2d"));
        System.out.println(decoder("3a1b2c2d"));
        System.out.println(decoder("2d"));
    }

    private static String decoder(String s) {
        String[] symbols = s.replaceAll("[0-9]", "").split("");
        String[] nums = s.split("[a-z,A-Z]");
        ArrayList<Integer> num = new ArrayList<>();
        String resultString = "";

        for (String string: nums){
            num.add(Integer.parseInt(string));
        }

        for (int i = 0; i<symbols.length; i++){
            for (int j = 0; j<num.get(i);j++){
                resultString+=symbols[i];
            }
        }

        return resultString;
    }
}