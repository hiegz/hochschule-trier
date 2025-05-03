public class A24 {
    public static void main(String[] args) {
        int i, j;
        for (i = 1, j = 5; i + 2 * j > 9; i++, j--)
            System.out.println(2 * i + 3 * j);
    }
}
