public class A17 {
    public static void main(String[] args) {
        System.out.println("Teil a)");
        a();

        System.out.println();

        System.out.println("Teil b)");
        b();

        System.out.println();
    }

    static void a() {
        int i = 14;
        while (i <= 22) {
            System.out.print(i + " ");
            i += 2;
        }
    }

    static void b() {
        int i = 7;
        while (i <= 11) {
            System.out.print(2 * i + " ");
            i += 1;
        }
    }
}
