import java.util.ArrayList;
import java.util.HashMap;

public class MainClass {
    public static void main(String[] args) {
        /*
        * Если имеется в виду найти минимальное количество монет по 3,5 и 3,5,7 копеек в числе,
        * то это методы: changeCoin(int num) и changeCoinThreeParam(int num) соответственно
        * Если имеется в виду найти все возможные комбинации монет 3,5 и 3,5,7 копеек в числе,
        * то это методы twoCoinExchange(int num) и threeCoinExchange(int num) соответственно
        * */

        System.out.println(changeCoin(17));
        System.out.println();
        System.out.println(changeCoinThreeParam(86));
        System.out.println();
        twoCoinExchange(60);
        threeCoinExchange(21);
    }

    private static String changeCoin(int num) {
        int remainder = num % 5;
        int countFive = 0;
        int countThree = 0;

        if (remainder != 0) {
            countFive = num / 5;
            while (remainder % 3 != 0) {
                remainder += 5;
                countFive--;
                countThree += remainder / 3;
                remainder = remainder % 3;
            }
        }
        return "В числе " + num + " минимальное количство 5 копеек = " + countFive + ", минимальное количество 3 копеек = " + countThree;
    }


    private static String changeCoinThreeParam(int num) {
        int countSeven = 0;
        int countFive = 0;
        int countThree = 0;
        int remainder = num % 7;
        if (remainder > 0) {
            countSeven = num / 7;
            while (remainder % 3 != 0) {
                if (remainder == 1) {
                    countSeven--;
                    countFive++;
                    remainder += 5;
                    countThree++;
                    remainder = remainder % 3;
                }
                if (remainder == 2) {
                    countSeven--;
                    remainder += 7;
                    countThree += remainder / 3;
                    remainder = remainder % 3;
                }
                if (remainder > 3 && remainder < 5) {
                    remainder = remainder % 3;
                    countThree++;
                }
                if (remainder == 5) {
                    remainder = remainder % 5;
                    countFive++;
                }
            }
            if (remainder != 0) {
                countThree += remainder / 3;
            }
        }
        return "В числе " + num + " минимальное количество 7 копеек " + countSeven + ", минимальное количство 5 копеек = " + countFive + " минимальное количество 3 копеек = " + countThree;
    }

    private static void twoCoinExchange(int num) {
        int countThree = 0;
        int remainder = 0;
        int countFive = 0;

        checkCorrectNum(num);
        remainder = num;
        System.out.println("Число " + num + " можно разменять на :");
        for (String s : change3and5(num, countThree, countFive, remainder)) {
            System.out.println(s);
        }
        System.out.println();
    }

    private static void threeCoinExchange(int num) {
        ArrayList<String> strings;
        int countThree;
        int remainder;
        int countFive;
        int countSeven;
        checkCorrectNum(num);
        System.out.println("Число " + num + " можно разменять на :");
        for (int i = 0; num - i >= 0; i += 7) {
            countFive = 0;
            countThree = 0;
            countSeven = (num - i) / 7;
            remainder = num - countSeven * 7;
            strings = change3and5(num, countThree, countFive, remainder);
            for (String string : strings) {
                System.out.println(countSeven + " 7коп. монет, " + string);
            }

        }
    }


    private static void checkCorrectNum(int num) {
        if (num < 3) {
            System.out.println("Размен невозможен");
            return;
        }
    }

    private static ArrayList<String> change3and5(int num, int countThree, int countFive, int remainder) {
        int remainderFive;
        ArrayList<String> resultArray = new ArrayList<>();
        for (int i = 0; remainder - i >= 0; i += 5) {
            countFive = (remainder - i) / 5;
            remainderFive = remainder - countFive * 5;
            countThree = remainderFive / 3;
            remainderFive = remainderFive - countThree * 3;

            if (remainderFive == 0) {
                resultArray.add(countFive + " 5коп. монет и " + countThree + " 3коп. монет");
            }
        }
        return resultArray;
    }
}

