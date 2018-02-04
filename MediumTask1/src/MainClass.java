import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class MainClass {

    /*
    * Чтобы протестировать программу, необходимо ввести несколько чисел, разделяя ввод клавишей Enter.
    * Чтобы остановить ввод необходимо нажать клавишу 'q'.
    * После этого необходимо ввести номер n-й по величине элемент набора чисел.
    * После чего программа выведет этот элемент.
    * Если на этапе ввода последовательности чисел будут введены не корректные данные, например, буква(за исключением 'q'),
    * то будет выведено сообщение об ошибке и предложено повторить ввод.
    * */
    static int size = 0;
    public static void main(String[] args) throws IOException {
        getNNum(sortList(readNumSet()), readN());
    }

    private static ArrayList readNumSet() throws IOException {
        ArrayList<Integer> numList = new ArrayList<>();
        String num;
        System.out.println("Введите набор чисел, чтобы прекратить ввод введите \"q\"");

        BufferedReader numsReader = new BufferedReader(new InputStreamReader(System.in));

        while (!(num = numsReader.readLine()).equals("q")) {
            try {
                numList.add(Integer.parseInt(num));
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не корректные данные, попробуйте снова");
                readNumSet();
                break;
            }
        }
        numList = new ArrayList<>(new HashSet<Integer>(numList));
        size = numList.size();
        return numList;
    }

    private static int readN() {
        int n = 0;
        System.out.println("Введите n-ое по величине элемент набора чисел");
        try (BufferedReader nReader = new BufferedReader(new InputStreamReader(System.in))) {

            try {
                n = Integer.parseInt(nReader.readLine());
                while (n>size){
                    System.out.println("Вы ввели слишком большое число, попробуйте снова, число не должно быть больше "+ size);
                    n = Integer.parseInt(nReader.readLine());
                }
            } catch (NumberFormatException e) {
                while (true){
                    System.out.println("Вы ввели не корректные данные, попробуйте снова");
                    try {
                        n = Integer.parseInt(nReader.readLine());
                        while (n>size){
                            System.out.println("Вы ввели слишком большое число, попробуйте снова, число не должно быть больше "+ size);
                            n = Integer.parseInt(nReader.readLine());
                        }
                        break;
                    }catch (NumberFormatException ex) {

                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return n;
    }

    private static ArrayList sortList(ArrayList<Integer> listNum) {
        for (int i = 0; i < listNum.size() - 1; i++) {
            for (int j = 0; j < listNum.size() - 1; j++) {
                if (listNum.get(j) < listNum.get(j + 1)) {
                    int temp = listNum.get(j);
                    listNum.set(j, listNum.get(j + 1));
                    listNum.set(j + 1, temp);
                }
            }
        }
        return listNum;
    }

    private static void getNNum(ArrayList<Integer> list, int n) throws IOException {
        /*ArrayList<Integer> list = new ArrayList<Integer>(set);
        list = sortList(list);*/
        System.out.println("n-й по величине элемент = "+list.get(n - 1)+" n = "+n);
    }
}
