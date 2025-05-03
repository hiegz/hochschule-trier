import java.util.Scanner;

public class A33 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            int num = in.nextInt();
            if (num == 6)
                break;
            if (num % 3 == 0)
                continue;
            if (num < 8)
                System.out.println(num * num);
            else
                System.out.println(num);
        }
        in.close();
    }
}
