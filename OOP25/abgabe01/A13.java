public class A13 {
    public static void main(String[] args) {
        int i;
        double d = 0.1;
        for (i = 1; i <= 20; i++) {
            System.out.println(1.0 + d);
            d = d / 10;
        }
    }
}
