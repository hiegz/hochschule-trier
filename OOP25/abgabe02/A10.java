public class A10 {
    public static void main(String[] args) {
        final int[] ns = { 4, 5, 6, 7, 8, 9, 10 };
        for (final int n : ns) {
            System.out.println("n = " + n);
            original(n);
            alternative(n);
        }
    }

    static void original(int n) {
        if (n < 5 || n > 8)
            System.out.println("Bereich 1");
        else if (n >= 5 && n <= 7)
            System.out.println("Bereich 2");
        else
            System.out.println("Bereich 3");
    }

    static void alternative(int n) {
        switch (n) {
            default:
                System.out.println("Bereich 1");
                break;
            case 5:
            case 6:
            case 7:
                System.out.println("Bereich 2");
                break;
            case 8:
                System.out.println("Bereich 3");
                break;
        }
    }
}
