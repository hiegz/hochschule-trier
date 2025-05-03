public class A21 {
    public static void main(String[] args) {
        original();
        System.out.println();
        alternative();
    }

    static void original() {
        int i = 1, sum = 0;
        while (i <= 15) {
            System.out.printf("%d %d\n", sum, i);
            sum += i;
            i += 2;
        }
    }

    static void alternative() {
        for (int i = 1, sum = 0; i <= 15; sum += i, i += 2)
            System.out.printf("%d %d\n", sum, i);
        ;
    }
}
