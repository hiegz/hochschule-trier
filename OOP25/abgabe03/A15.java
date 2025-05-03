public class A15 {
    public static void main(String[] args) {
        {
            System.out.println("Teil a)");
            int t = 6;
            while (t > 3) {
                System.out.println(t);
                t--;
            }
            System.out.println(t);
        }

        System.out.println();

        {
            System.out.println("Teil b)");
            int t = 6;
            do {
                System.out.println(t);
                t--;
            } while (t > 3);
            System.out.println(t);
        }
    }
}
