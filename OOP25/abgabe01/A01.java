public class A01 {
    public static void main(String[] args) {
        int a = 76, b = 37, c;
        c = b % a * 9;
        a++;
        b--;
        c += a + b;
        c %= 2 * 5;
        c++;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
    }
}
