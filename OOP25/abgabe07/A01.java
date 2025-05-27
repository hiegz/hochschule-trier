public class A01 {
    public static int reverseInt(int x) {
        int y = x % 10;
        x = x / 10;
        while (x != 0) {
            y *= 10;
            y += x % 10;
            x /= 10;
        }
        return y;
    }

    public static void main(String[] args) {
        System.out.printf("reverseInt(1234) == %d\n", reverseInt(1234));
        System.out.printf("reverseInt(17) == %d\n", reverseInt(17));
        System.out.printf("reverseInt(454) == %d\n", reverseInt(454));
    }
}
