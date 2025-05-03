public class A28 {
    public static void main(String[] args) {
        System.out.println("123456789012");
        System.out.println("************");
        for (int i = 1; i <= 3; i++)
            for (int j = 1; j <= 4; j++)
                System.out.print('*');
        System.out.println();
        for (int i = 3; i < 5; i++)
            for (int j = 6; j > 0; j--)
                System.out.print('*');
        System.out.println();
        for (int j = 2; j < 38; j += 3)
            System.out.print('*');
        System.out.println();
    }
}
