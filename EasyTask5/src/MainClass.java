public class MainClass {
    public static void main(String[] args) {
        /*Программа, выполняющая поиск подстроки в строке.*/

        /*
        * Программа реализована при помощи библиотечного метода contains
        * На вход передается два параметра, сама строка и подстрока для поиска в строке
        * */

        String string = "А роза упала на лапу азора";
        String validSubstring = "роза";
        String inValidString = "узор";

        System.out.println(getSubstring(string, validSubstring));
        System.out.println(getSubstring(string, inValidString));

    }

    private static String getSubstring(String string, String substring){
        if (string.contains(substring)){
            return "Строка \"" + string + "\" содержит подстроку \"" + substring + "\"";
        }
        else return "Строка \"" + string + "\" не содержит подстроку \"" + substring + "\"";
    }
}
