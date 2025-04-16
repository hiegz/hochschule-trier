public class A08 {
    public static void main(String[] args) {
        final int[] ns = { 5, 4, 8 };
        for (final int n : ns) {
            System.out.println("n = " + n);
            func(n);
            func2(n);
        }
    }

    static void func(int n) {
        switch (n) {
            case 1:
            case 3:
            case 4:
                System.out.println(n);
                break;
            case 2:
            case 5:
            case 6:
                System.out.println(n * 10);
                break;
            default:
                System.out.println(n * 100);
                break;
        }
    }

    static void func2(int n) {
        switch (n) {
            case 1:
            case 3:
            case 4:
                System.out.println(n);
            case 2:
            case 5:
            case 6:
                System.out.println(n * 10);
            default:
                System.out.println(n * 100);
        }
    }
}
