public class A05 {
    public static void main(String[] args) {
        final int[] ns = { 17, 25, 7, 0, 9 };
        for (final int n : ns) {
            System.out.println("n = " + n);
            if (n <= 10)
                if (n / 3 < 2)
                    System.out.println("eins");
                else if (n / 3 >= 3)
                    System.out.println("zwei");
                else
                    System.out.println("drei");
            else if (n > 20)
                System.out.println("vier");
            else
                System.out.println("fuenf");
        }
    }
}
