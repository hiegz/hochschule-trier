public class A23 {
    public static void main(String[] args) {
        {
            System.out.println("Teil a)");

            int count = 0;
            for (int i = 1; i <= 5; i++)
                for (int j = 1; j <= 3; j++)
                    count++;

            System.out.println(count);
        }

        System.out.println();

        {
            System.out.println("Teil b)");

            int count = 0;
            for (int i = 1; i <= 3; i++)
                for (int j = 0; j < i; j++)
                    count++;

            System.out.println(count);
        }
    }
}
