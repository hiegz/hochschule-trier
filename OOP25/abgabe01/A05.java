public class A05 {
    public static void main(String[] args) {
        assert isDigit('0') == true;
        assert isDigit('1') == true;
        assert isDigit('2') == true;
        assert isDigit('3') == true;
        assert isDigit('4') == true;
        assert isDigit('5') == true;
        assert isDigit('6') == true;
        assert isDigit('7') == true;
        assert isDigit('8') == true;
        assert isDigit('9') == true;
        assert isDigit('c') == false;
        assert isDigit('A') == false;
        assert isDigit('!') == false;
        assert isDigit('&') == false;

        assert isLowercase('a') == true;
        assert isLowercase('b') == true;
        assert isLowercase('k') == true;
        assert isLowercase('y') == true;
        assert isLowercase('3') == false;
        assert isLowercase('@') == false;
        assert isLowercase('K') == false;
        assert isLowercase('Y') == false;

        assert isUppercase('Y') == true;
        assert isUppercase('H') == true;
        assert isUppercase('N') == true;
        assert isUppercase('2') == false;
        assert isUppercase('*') == false;
        assert isUppercase('y') == false;

        assert isVowel('a') == true;
        assert isVowel('e') == true;
        assert isVowel('i') == true;
        assert isVowel('o') == true;
        assert isVowel('u') == true;
        assert isVowel('A') == true;
        assert isVowel('E') == true;
        assert isVowel('I') == true;
        assert isVowel('O') == true;
        assert isVowel('U') == true;
        assert isVowel('b') == false;
        assert isVowel('B') == false;
        assert isVowel('2') == false;
        assert isVowel('&') == false;
    }

    public static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public static boolean isLowercase(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    public static boolean isUppercase(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }

    public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
               ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
