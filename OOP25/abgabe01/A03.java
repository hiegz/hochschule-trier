public class A03 {
    public static void main(String args[]) {
        int a, b;
        a = 20;
        a -= 4;
        System.out.println("a = " + a);
        a = 20;
        b = 4;
        a += b;
        System.out.println("a = " + a);
        b *= a;
        System.out.println("b = " + b);
        a %= b + 6;
        System.out.println("a = " + a);
        a = 35;
        b = 88;
        a++;
        System.out.println("a = " + a);
        b--;
        System.out.println("b = " + b);
    }
}
