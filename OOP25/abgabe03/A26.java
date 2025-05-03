public class A25 {
    public static void main(String[] args) {
        loop(new int[] { 10, 22, 6, 23, 24 });
    }

    static void loop(int[] input) {
        int pos = 0;
        for (int n = 5; n < 25; n++) {
            System.out.println(n);
            n = input[pos++];
        }
    }
}
