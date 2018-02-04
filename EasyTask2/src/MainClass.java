public class MainClass {
    public static void main(String[] args) {
        /*2) Программа, выполняющая разложение числа на набор простых множителей*/

        simpleMultipliers(77);
    }

    public static void simpleMultipliers(int num) {
        if (num <= 1)
            return;
        for (int i = 2; i <= num; i++) {
            if (num % i == 0) {
                num = num / i;
                if (num > 1) {
                    System.out.print(i + " ");
                    simpleMultipliers(num);
                    return;
                } else {
                    System.out.print(i);
                    return;
                }
            }
        }
    }
}
