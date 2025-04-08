public class A02 {
    public static void main(String[] args) {
        // double d = 7.99;
        // long l = d; // implizit
        // (a) possible lossy conversion from double to long

        // (b)
        double d = 7.99;
        long l = (long) d;
        System.out.printf("%.2f -> %d\n", d, l);
    }
}
