public class A16 {
    public static void main(String[] args) {
        System.out.println("Teil a)");
        a();

        System.out.println();

        System.out.println("Teil b)");
        b();

        System.out.println();

        System.out.println("Teil c)");
        c();
    }

    static void a() {
        int i = 2;
        int sum = 0;
        while (i <= 20) {
            sum += i;
            i += 2;
        }
        System.out.println(sum);
    }

    static void b() {
        int i = 1;
        int sum = 0;
        do {
            sum += i;
            i += 1;
        } while (sum <= 500);
        System.out.println(sum);
    }

    static void c() {
        int n = 10;
        while (n >= 2) {
            System.out.println(n * n);
            n -= 2;
        }
    }
}
