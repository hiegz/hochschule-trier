public class A09 {

    public static void main(String[] args) {
        final char[] chs = { 'a', 'b', 'c', 'g', 'h', 'i', 'z', 'v' };
        for (final char ch : chs) {
            System.out.println("ch = " + ch);
            original(ch);
            alternative(ch);
        }
    }

    static void original(char ch) {
        if (ch == 'a' || ch == 'b' || ch == 'c')
            System.out.println("im Bereich \"abc\"");
        else if (ch >= 'g' && ch < 'i')
            System.out.println("in der Mitte des Alphabets");
        else if (ch == 'z')
            System.out.println("ein z, ein z, ...");
        else
            System.out.println("andere Buchstaben");
    }

    static void alternative(char ch) {
        switch (ch) {
            case 'a':
            case 'b':
            case 'c':
                System.out.println("im Bereich \"abc\"");
                break;
            case 'g':
            case 'h':
                System.out.println("in der Mitte des Alphabets");
                break;
            case 'z':
                System.out.println("ein z, ein z, ...");
                break;
            default:
                System.out.println("andere Buchstaben");
        }
    }
}
