package org.example.lesson4;

public class Functions {
    //11
    //1
    //123321
    //2332

    //Определяем, является ли слово полиндромом - читается одинаково справа-налево и слева-направо
    public static boolean isPalindrome(String word) {
        if (word.length() < 2) {
            return true;
        }
//если длина слова < 2, вернуть false

        if (word.charAt(0) != word.charAt(word.length() - 1)) {
            return false;
        }
//если символ, стоящий на 1 месте не равен символу, стоящему на последнем месте, вернуть false
        return isPalindrome(word.substring(1, word.length() - 1));
        //возвращаем слово, укороченное на 1 символ

        //--------isPalindrome(123321) --true
        //-------isPalindrome(2332)  --true
        //-----isPalindrome(33)   --true
        //----isPalindrome()  --true

    }
}
