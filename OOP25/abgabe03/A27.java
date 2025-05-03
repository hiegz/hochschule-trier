public class A27 {
    public static void main(String[] args) {
        int[] input = { 40, 50, 100 };

        for (long n : input) {
            System.out.println("n = " + n);
            long p;

            for (p = 1; p < n; p *= 2)
                System.out.print(p + " ");
            System.out.println();
        }
    }
}
