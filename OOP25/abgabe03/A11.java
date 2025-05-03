public class A11 {
    public static void main(String[] args) {
        original(0, 0);
        alternative(0, 0);

        System.out.println();

        original(0, 1);
        alternative(0, 1);

        System.out.println();

        original(1, 0);
        alternative(1, 0);

        System.out.println();

        original(1, 1);
        alternative(1, 1);

        System.out.println();

        original(4, 2);
        alternative(4, 2);
    }

    static void original(int wert, int i) {
        System.out.printf("%d %d -> ", wert, i);
        while (wert > 0) {
            wert -= i * i;
            i--;
        }
        System.out.printf("%d %d\n", wert, i);
    }

    static void alternative(int wert, int i) {
        System.out.printf("%d %d -> ", wert, i);
        do {
            if (wert <= 0)
                break;
            wert -= i * i;
            i--;
        } while (true);
        System.out.printf("%d %d\n", wert, i);
    }
}
