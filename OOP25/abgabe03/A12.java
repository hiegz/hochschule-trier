public class A12 {
    public static void main(String[] args) {
        {
            System.out.println("Teil a)");

            int i = 1;
            while (i <= 8) {
                System.out.print(i + " ");
                i += 2;
            }
        }

        System.out.println();

        {
            System.out.println("Teil b)");

            int i = 4, k;
            do {
                k = 2 * i;
                System.out.print(k + " ");
                i--;
            } while (i >= 0);
        }

        System.out.println();
    }
}
