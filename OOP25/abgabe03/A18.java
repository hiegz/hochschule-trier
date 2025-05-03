public class A18 {
    public static void main(String[] args) {
        System.out.println("Teil a)");
        a();

        System.out.println();

        System.out.println("Teil b)");
        b();

        System.out.println();
    }

    static void a() {
        boolean stop = false;
        System.out.println("Before the loop");
        while (stop = false) {
            System.out.println("inside the loop");
        }
        System.out.println("After the loop");
    }

    static void b() {
        int i = 10;
        while (i > 0) {
            System.out.print(i);
            i++;
        }
    }
}
