public class A05 {
    public static void main(String[] args) {
        int x = Integer.MAX_VALUE;
        x = x + 1; // Positive integer overflow
        System.out.println(x);
    }
}
