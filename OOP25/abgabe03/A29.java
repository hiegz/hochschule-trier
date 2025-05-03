public class A29 {
    public static void main(String[] args) {
        System.out.println("Teil a)");
        {
            int i, j, k;
            int counter = 0;
            i = 0;
            while (i <= 10) {
                j = 1;
                while (j < i) {
                    System.out.print('*');
                    counter += 1;
                    j++;
                }
                i++;
            }

            System.out.printf(" (%d)", counter);
        }
        System.out.println();

        System.out.println("Teil b)");
        {
            int i, j, k;
            int counter = 0;
            for (i = 0; i < 3; i++)
                for (j = 0; j < 3; j++)
                    for (k = 0; k < 2; k++) {
                        System.out.print('*');
                        counter += 1;
                    }

            System.out.printf(" (%d)", counter);
        }

        System.out.println();
    }
}
