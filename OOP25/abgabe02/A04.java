public class A04 {
    public static void main(String[] args) {
        System.out.println("original(a = 3, b = 4, m = 1, n = 5)");
        original(3, 4, 1, 5);
        System.out.println("alternative(a = 3, b = 4, m = 1, n = 5)");
        alternative(3, 4, 1, 5);

        System.out.println("");

        System.out.println("original(a = 5, b = 3, m = 7, n = 4)");
        original(5, 3, 7, 4);
        System.out.println("alternative(a = 5, b = 3, m = 7, n = 4)");
        alternative(5, 3, 7, 4);

        System.out.println("");

        System.out.println("original(a = 3, b = 5, m = 7, n = 4)");
        original(3, 5, 7, 4);
        System.out.println("alternative(a = 3, b = 5, m = 7, n = 4)");
        alternative(3, 5, 7, 4);

        System.out.println("");

        System.out.println("original(a = 5, b = 3, m = 3, n = 7)");
        original(5, 3, 3, 7);
        System.out.println("alternative(a = 5, b = 3, m = 3, n = 7)");
        alternative(5, 3, 3, 7);
    }

    static void original(int a, int b, int m, int n) {
        if (a < b)
            if (m > n)
                System.out.println("schwarz");
            else
                System.out.println("rot");
        else if (m > n)
            System.out.println("gruen");
        else
            System.out.println("blau");
    }

    static void alternative(int a, int b, int m, int n) {
        if (m > n)
            if (a < b)
                System.out.println("schwarz");
            else
                System.out.println("gruen");
        else 
            if (a < b)
                System.out.println("rot");
            else
                System.out.println("blau");
    }
}
