import java.util.*;

public class MainClass {

    /*1) Программа, возвращающая 2-й по величине элемент набора чисел.*/
    /*
    * Если значения в наборе не могут повторяться, то можно воспользоваться массивом,
    * отсортировать в порядке убывания его и вернуть его первый элемент(начиная с 0)
    * Если значения в наборе повторяются, то можно воспользоваться TreeSet,
    * преобразовать его к массиву и вернуть его предпоследний элемент
    * Ниже представлен исходный код
    * */

    public static void main(String[] args) {
        TreeSet<Double> numSet = new TreeSet<>();
        double[] nums = {6.7, 4.7, 5.3, 0.1, 0.5, 26, 53};
        double[] numbers = {53, 26, 6.7, 4.7, 5.3, 0.1, 0.5, 26, 53};

        for (double d: numbers) {
            numSet.add(d);
        }

        System.out.println("2-й по величине элемент набора чисел: "+getSecondAmountNum(nums)); // Если значения в наборе не могут повторяться
        System.out.println("2-й по величине элемент набора чисел: "+getSecondAmountNum(numSet)); // Если значения в наборе повторяются
    }

    private static double getSecondAmountNum(double[] array) { // Если значения в наборе не могут повторяться
        double temp;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] < array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        return array[1];
    }

    private static double getSecondAmountNum(TreeSet<Double> set){ // Если значения в наборе повторяются
        Double[] array = set.toArray(new Double[set.size()]);
        return array[array.length-2];
    }
}
