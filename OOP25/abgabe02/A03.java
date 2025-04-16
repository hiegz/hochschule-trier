public class A03 {
    public static void main(String[] args) {
        final int[] ts = { 9, 20, 4, 7, 16 };
        for (final int t : ts) {
            System.out.println("t = " + t);
            if (t < 15)
                if (t > 7)
                    System.out.println("eins");
                else
                    System.out.println("zwei");
            else if (t < 18)
                System.out.println("drei");
            System.out.println("Ende");
        }
    }
}
