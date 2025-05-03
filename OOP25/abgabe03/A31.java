public class A31 {
    public static void main(String[] args) {
        int[] input = { 7, 4, 9 };
        for (int n : input) {
            int i;
            System.out.println("n = " + n);
            for (i = 1; i < 10; i++) {
                if (i % 4 == 0)
                    continue;
                else if (i == n)
                    break;
                else
                    System.out.println(i + " ");
            }
        }
    }
}
