public class A19 {
    public static void main(String[] args) {
        original();
        System.out.println();
        alternative();
        System.out.println();
    }

    static void original() {
        int i = 10;
        while (i >= 1) {
            System.out.print(i + " ");
            i--;
        }
    }

    static void alternative() {
        for (int i = 10; i >= 1; i--) {
            System.out.print(i + " ");
        }
    }
}
