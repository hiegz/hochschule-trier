public class A07 {
    public static void main(String[] args) {
        final int[] ns = {40, 50, 15, 39};
        for (final int n : ns) {
            original(n);
            alternative(n);
        }
    }

    static void original(int n) {
        switch (n) {
            case 39:
            case 15:
                System.out.println("gewonnen");
                break;
            default:
                System.out.println("verloren");
                break;
        }
    }

    static void alternative(int n) {
        if (n == 39 || n == 15)
            System.out.println("gewonnen");
        else
            System.out.println("verloren");
    }
}
