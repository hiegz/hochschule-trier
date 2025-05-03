public class A20 {
    public static void main(String[] args) {
        original();
        System.out.println();
        alternative();
    }

    static void original() {
        for (int i = 1; i < 10; i++)
            System.out.println(i + 5);
    }

    static void alternative() {
        int i = 1;
        while (i < 10) {
            System.out.println(i + 5);
            i++;
        }
    }
}
