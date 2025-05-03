public class A30 {
    public static void main(String[] args) {
        {
            int i, j, k, sum;
            System.out.println("Teil a)");
            for (sum = 0, i = 0, k = 8; i < k; i++, k--)
                sum += 2 * i + k;
            System.out.println(sum);
        }

        {
            int i, j, k, sum;
            System.out.println("Teil b)");
            for (i = 0, j = 1; i * j < 100; i++, j *= 10)
                System.out.println(i * j);
        }
    }
}
