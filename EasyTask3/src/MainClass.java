import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) {
        /*3) Программа, выполняющая проверку строки на то, что она является палиндромом*/
        /*
        * Программа реализована двумя способами, в первом случае с помощью библиотечных методов, во втором практически без них
        * 1 способ:
        * Получаем на вход строку, разворачиваем ее, удаляем все пробелы и сравниваем с исходной строкой, игнорируя регистр, у которой тоже удаляем все побелы
        * Если строки равны, то возвращаем true, если нет, то false
        * 2 способ:
        * Получаем на вход строку, приводим к нижнему регистру, преобразуем в массив символов, все символы кроме пробелов добавляем в ArrayList,
        * Сравниваем симметричные, относительно середины строки символы, пока счетчик не дойдет до середины размера листа или не найдутся разные символы,
        * Если счетчик дошел до середины размера листа, то возвращаем true, если нашлись разные символы, то возвращаем false
        * */

        System.out.println(isPalindrome("А роза     упала на лапу азора")); // С помощью библиотечного метода
        System.out.println(isPalindrome("РоЗа"));
        System.out.println(isPalindrome("Р"));
        System.out.println(isPalindrom("А роза     упала на лапу азора")); // Почти без библиотечных методов
        System.out.println(isPalindrom("РоЗа"));
        System.out.println(isPalindrom("а"));
    }

    private static boolean isPalindrome(String s) {// С помощью библиотечного метода
        StringBuffer sb = new StringBuffer(s);
        String reversString = sb.reverse().toString().replaceAll(" ", "");

        return reversString.compareToIgnoreCase(s.replaceAll(" ", "")) == 0;
    }

    private static boolean isPalindrom(String s) { // Почти без библиотечных методов
        s = s.toLowerCase();
        char[] charArray = s.toCharArray();
        ArrayList<Character> arrayIgnoreSpace = new ArrayList<>();
        for (int j = 0; j <= charArray.length - 1; j++) {
            if (charArray[j] != ' ') {
                arrayIgnoreSpace.add(charArray[j]);
            }
        }

        for (int i = 0; i <= arrayIgnoreSpace.size() / 2; i++) {
            if (!arrayIgnoreSpace.get(i).equals(arrayIgnoreSpace.get(arrayIgnoreSpace.size() - i - 1))) {
                return false;
            }
        }
        return true;
    }
}
